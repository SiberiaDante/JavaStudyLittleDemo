package com.dante.mybatis.db;


import org.junit.jupiter.api.Test;

import com.dante.mybatis.dao.MessageDao;

class MyBatisTest {

	@Test
	void testSqlSession() {
		MessageDao messageDao=new MessageDao();
		messageDao.queryMessageByMyBatis("", "");
	}

}
