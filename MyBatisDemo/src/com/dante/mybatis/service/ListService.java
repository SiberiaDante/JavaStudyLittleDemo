package com.dante.mybatis.service;

import java.util.List;

import com.dante.mybatis.bean.MessageBean;
import com.dante.mybatis.dao.MessageDao;

public class ListService {
	public List<MessageBean> queryMessage(String command, String description) {
		MessageDao msgDao = new MessageDao();
		//query by jdbc
//		return msgDao.queryMessage(command, description);
		return msgDao.queryMessageByMyBatis(command, description);
	}
}
