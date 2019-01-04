package com.dante.mybatis.bean.entity;

import java.util.List;
import java.util.Map;

import com.dante.mybatis.bean.MessageBean;

public interface IMessage {
	public List<MessageBean> queryMessage(MessageBean messageBean);

	public void deleteOneMessage(int id);

	public void deleteBatchMessage(List<Integer> ids);

	public void insertMessage(MessageBean messageBean);

	public int quesryAllMsgCount(MessageBean messageBean);

	public List<MessageBean> quesryMsgByPage(Map<String,Object> maps);
	
	public List<MessageBean> quesryMsgByFilterPage(Map<String,Object> maps);
}
