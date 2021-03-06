package com.dante.mybatis.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dante.mybatis.bean.MessageBean;
import com.dante.mybatis.bean.entity.IMessage;
import com.dante.mybatis.db.DBAccess;

/**
 * table message dao
 *
 */
public class MessageDao {

	public List<MessageBean> quesryMsgByFilterPage(Map<String, Object> map) {
		List<MessageBean> msgBeans = new ArrayList<>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			msgBeans = iMessage.quesryMsgByFilterPage(map);
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
	 * 简单分页查找
	 * 
	 * @param map
	 * @return
	 */
	public List<MessageBean> quesryMsgByPage(Map<String, Object> map) {
		List<MessageBean> msgBeans = new ArrayList<>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			msgBeans = iMessage.quesryMsgByPage(map);
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
	 * 简单分页查询查询总条数
	 * 
	 * @param msgBean
	 * @return
	 */
	public int queryAllMsgCount(MessageBean msgBean) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int allCount = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			allCount = iMessage.quesryAllMsgCount(msgBean);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return allCount;
	}

	public void saveMsg(String command, String description, String content) {
		DBAccess dbAccess = new DBAccess();
		MessageBean msg = new MessageBean();
		msg.setCommand(command);
		msg.setDescription(description);
		msg.setContent(content);
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			iMessage.insertMessage(msg);
			// sqlSession.insert("Message.insertMessage", msg);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public void deleteBatchMessageById(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			iMessage.deleteBatchMessage(ids);
			// sqlSession.delete("Message.deleteBatchMessage", ids);
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
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			iMessage.deleteOneMessage(id);
			// sqlSession.delete("Message.deleteOneMessage", id);
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
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			msgBeans = iMessage.queryMessage(msgBean);
			// msgBeans = sqlSession.selectList("Message.queryMessage", msgBean);
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
