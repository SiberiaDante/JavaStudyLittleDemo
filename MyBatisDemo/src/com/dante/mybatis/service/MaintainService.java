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
		if (null == ids) {
			return;
		}
		if (ids.length == 0) {
			return;
		}
		List<Integer> mIds = new ArrayList<>();
		for (String id : ids) {
			mIds.add(Integer.valueOf(id));
		}
		MessageDao msgDao = new MessageDao();
		msgDao.deleteBatchMessageById(mIds);
	}

	public void saveMsg(String command, String description, String content) {
		MessageDao msgDao = new MessageDao();
		msgDao.saveMsg(command, description, content);

	}
}
