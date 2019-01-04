package com.dante.mybatis.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dante.mybatis.bean.Command;
import com.dante.mybatis.db.DBAccess;

public class CommandDao {
	public List<Command> queryMessage(String command, String description) {
		List<Command> commandList = new ArrayList<>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command commandBean = new Command();
			commandBean.setName(command);
			commandBean.setDescription(description);
			commandList = sqlSession.selectList("Command.queryCommand", commandBean);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
}
