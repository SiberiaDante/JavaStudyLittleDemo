package com.dante.mybatis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.mybatis.service.MaintainService;

@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String[] ids = req.getParameterValues("cb_id");
		MaintainService maintainService = new MaintainService();
		maintainService.deleteBatchMessage(ids);
		req.getRequestDispatcher("/list.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
