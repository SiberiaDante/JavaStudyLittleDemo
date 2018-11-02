<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Response 内置对象</title>
</head>
<body>
	<%
		response.setContentType("text/html;charset=utf-8");
		out.print("<h1>response 内置对象</h1>");
		//out.flush();
		
		PrintWriter printWriter=response.getWriter();
		printWriter.print("我是PrintWriter,Response 生成的");
		//response.sendRedirect("http://www.baidu.com");
		//response.sendRedirect("request.jsp");
		request.getRequestDispatcher("request.jsp").forward(request, response);
	%>

</body>
</html>