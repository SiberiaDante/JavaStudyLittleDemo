<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="loginUser" class="com.jsp.bean.LoginUserBean"
		scope="page"></jsp:useBean>

	<%
		String username = loginUser.getUsername();
	%>

	<p>Login Success,Welcome</p>
	username:<%=session.getAttribute("username")%>
	<!-- resulet null -->
	username:<%=loginUser.getUsername()%>
</body>
</html>