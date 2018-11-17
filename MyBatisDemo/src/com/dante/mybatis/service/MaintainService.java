package com.dante.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import com.dante.mybatis.dao.MessageDao;

/**
 * 维护相关业务
 * 
 *
 */
public class MaintainService {

	public void deleteOneMessage(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao msgDao = new MessageDao();
			msgDao.deleteOneMessageById(Integer.valueOf(id));
		}
	}

	public void deleteBatchMessage(String[] ids) {
		List<Integer> mIds = new ArrayList<>();
		for (String id : ids) {
			mIds.add(Integer.valueOf(id));
		}
		MessageDao msgDao = new MessageDao();
		msgDao.deleteBatchMessageById(mIds);
	}
}
