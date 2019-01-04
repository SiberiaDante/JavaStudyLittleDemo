package com.dante.mybatis.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.mybatis.bean.MessageBean;
import com.dante.mybatis.bean.entity.Page;
import com.dante.mybatis.service.QueryService;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String currentPage = req.getParameter("currentPage");
		System.out.println("-------------:"+currentPage);
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		Page page = new Page();
		if (currentPage == null || !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}

		// query by jdbc
		// MessageDao msgDao = new MessageDao();
		// List<MessageBean> messageBeans = msgDao.queryMessage(command, description);
		// ListService listService = new ListService();
		// List<MessageBean> messageBeans = listService.queryMessage(command,
		// description);
		QueryService queryService = new QueryService();
		List<MessageBean> messageBeans = queryService.quesryMsgByFilterPage(command, description, page);

		req.setAttribute("messageBeans", messageBeans);
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
