<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	user name:<%=pageContext.getSession().getAttribute("username")%><br>
	<%
	//pageContext.forward("register.jsp");
	pageContext.include("includePage.jsp");
	%>
	
</body>
</html>