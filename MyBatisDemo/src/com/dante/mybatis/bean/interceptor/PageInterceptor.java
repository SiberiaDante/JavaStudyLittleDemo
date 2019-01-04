package com.dante.mybatis.bean.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.dante.mybatis.bean.entity.Page;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class PageInterceptor implements Interceptor {
	private String test;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		// 配置文件中的SQL语句的ID
		String id = mappedStatement.getId();
		if (id.matches(".+ByFilterPage$")) {
			BoundSql boudSql = statementHandler.getBoundSql();
			// 原始SQL语句
			String sql = boudSql.getSql();
			System.out.println(sql);
			// 查询总条数
			String countSql = "select count(*) from (" + sql + ") m";
			Connection connection = (Connection) invocation.getArgs()[0];
			PreparedStatement countStatement = connection.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(countStatement);
			ResultSet rs = countStatement.executeQuery();

			// Map<String, Object> parameter = (Map<String, Object>)
			// boudSql.getParameterObject();
			Map<?, ?> parameter = (Map<?, ?>) boudSql.getParameterObject();
			Page page = (Page) parameter.get("page");
			if (rs.next()) {
				int totalNums = rs.getInt(1);
				System.out.println("----------------:" + totalNums);
				page.setTotaNum(rs.getInt(1));
			}
			// 改造后分页查询的语句
			String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNum();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		this.test = arg0.getProperty("test");
	}

}
