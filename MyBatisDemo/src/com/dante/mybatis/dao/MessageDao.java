package com.dante.mybatis.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dante.mybatis.bean.MessageBean;
import com.dante.mybatis.db.DBAccess;

/**
 * table message dao
 *
 */
public class MessageDao {
	
	public void deleteBatchMessageById(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatchMessage", ids);
			// 修改相关的操作，需要手动提交session
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * delete one msg
	 * 
	 * @param id
	 */
	public void deleteOneMessageById(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOneMessage", id);
			// 修改相关的操作，需要手动提交session
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	/**
	 * query msg all
	 * 
	 * @param command
	 * @param description
	 * @return
	 */
	public List<MessageBean> queryMessageByMyBatis(String command, String description) {
		List<MessageBean> msgBeans = new ArrayList<>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			MessageBean msgBean = new MessageBean();
			msgBean.setCommand(command);
			msgBean.setDescription(description);
			msgBeans = sqlSession.selectList("Message.queryMessage", msgBean);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return msgBeans;
	}

	/**
	 * user jdbc query message
	 * 
	 * @param command
	 * @param description
	 * @return
	 */
	public List<MessageBean> queryMessage(String command, String description) {
		List<MessageBean> msgBeans = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/micro_message?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
					"root", "123456");
			StringBuilder sql = new StringBuilder("select id,command,description,content from message where 1=1");
			List<String> appendSql = new ArrayList<>();
			if (null != command && !"".equals(command.trim())) {
				sql.append(" and command=?");
				appendSql.add(command);
			}
			if (null != description && !"".equals(description.trim())) {
				sql.append(" and description like '%' ? '%'");
				appendSql.add(description);
			}
			PreparedStatement statement = con.prepareStatement(sql.toString());
			for (int i = 0; i < appendSql.size(); i++) {
				statement.setString(i + 1, appendSql.get(i));
			}
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				MessageBean msg = new MessageBean();
				msgBeans.add(msg);
				msg.setId(result.getInt("id"));
				msg.setCommand(result.getString("command"));
				msg.setDescription(result.getString("description"));
				msg.setContent(result.getString("content"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msgBeans;
	}
}
