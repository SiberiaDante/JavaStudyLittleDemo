<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Session 内置对象</h1>
	<hr>
	Session Create Time<%=session.getCreationTime()%><br>

	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(session.getCreationTime());
		String times = sdf.format(date);

		session.setAttribute("username", "admin");
		session.setAttribute("psd", "123456");
		session.setAttribute("age", 20);

		//session.setMaxInactiveInterval(10);
	%>
	<%=times%><br> ID code:<%=session.getId()%><br> user name:<%=session.getAttribute("username")%><br>
	<%-- <%
		session.invalidate();
	%> --%>
	<a href="session1.jsp" target="_blank">jump to session1</a><br><br><br>
	<a href="pageContext.jsp" target="_blank">jump to pageContext.jsp</a>


</body>
</html>