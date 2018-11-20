package com.dante.mybatis.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.mybatis.service.MaintainService;

@SuppressWarnings("serial")
public class AddMessageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw=resp.getWriter();
		
		MaintainService ms=new MaintainService();
		ms.saveMsg(command, description, content);
		System.out.println("---------save result---------");
		pw.write("保存成功");
		pw.flush();
		
//		req.getRequestDispatcher("").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
