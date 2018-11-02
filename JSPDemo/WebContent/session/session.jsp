<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		long time = session.getCreationTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = sdf.format(new Date(time));
		String username = request.getParameter("username");
		session.setAttribute("username", username);
	%>
	<%
		String path = application.getContextPath();
	%>
	<p>
		session create time=<%=createTime%></p>
	<p>
		session id =<%=session.getId()%></p>
	<p>
		session get username =
		<%=session.getAttribute("username")%></p>
	<p>
		request get username =
		<%=username%></p>

	<hr>
	<a href="<%=path%>/session/session1.jsp" target="_blank">jump to
		session1.jsp page</a>
</body>
</html>