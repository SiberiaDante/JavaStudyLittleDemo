package com.dante.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.dante.mybatis.bean.Command;
import com.dante.mybatis.bean.CommandContent;
import com.dante.mybatis.bean.MessageBean;
import com.dante.mybatis.bean.entity.Page;
import com.dante.mybatis.dao.CommandDao;
import com.dante.mybatis.dao.MessageDao;
import com.dante.mybatis.utils.Iconst;

public class QueryService {
	
	public List<MessageBean> quesryMsgByFilterPage(String command, String description, Page page) {
		MessageBean msgBean = new MessageBean();
		msgBean.setCommand(command);
		msgBean.setDescription(description);
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("message", msgBean);
		MessageDao messageDao = new MessageDao();
		return messageDao.quesryMsgByFilterPage(map);
	}
	
	public List<MessageBean> queryMessageList(String command, String description, Page page) {
		MessageDao messageDao = new MessageDao();
		MessageBean msgBean = new MessageBean();
		msgBean.setCommand(command);
		msgBean.setDescription(description);
		int totalCount = messageDao.queryAllMsgCount(msgBean);
		System.out.println("----------:" + totalCount);
		page.setTotaNum(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("message", msgBean);
		return messageDao.quesryMsgByPage(map);
	}

	public List<MessageBean> queryMessageList(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageByMyBatis(command, description);
	}

	/**
	 * 通过指令查询自动回复的内容
	 * 
	 * @param command
	 *            指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand1(String command) {
		MessageDao messageDao = new MessageDao();
		List<MessageBean> messageList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			messageList = messageDao.queryMessageByMyBatis(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < messageList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = messageDao.queryMessageByMyBatis(command, null);
		if (messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}

	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> messageList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			messageList = commandDao.queryMessage(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < messageList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + messageList.get(i).getName() + "]可以查看" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = commandDao.queryMessage(command, null);
		if (messageList.size() > 0) {
			List<CommandContent> contentList = messageList.get(0).getContentList();
			return contentList.get(new Random().nextInt(contentList.size())).getName();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
