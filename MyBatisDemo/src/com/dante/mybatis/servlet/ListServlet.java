package com.dante.mybatis.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.mybatis.bean.MessageBean;
import com.dante.mybatis.service.ListService;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");

		req.setAttribute("command", command);
		req.setAttribute("description", description);
		//query by jdbc
		// MessageDao msgDao = new MessageDao();
		// List<MessageBean> messageBeans = msgDao.queryMessage(command, description);
		ListService listService = new ListService();
		List<MessageBean> messageBeans = listService.queryMessage(command, description);
		req.setAttribute("messageBeans", messageBeans);
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
