<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Test Login Result</title>
</head>
<body>
	<jsp:useBean id="loginUser" class="com.jsp.bean.LoginUserBean"
		scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="loginUser" />

	<!-- the first way of get the value -->
	username:<%=loginUser.getUsername()%>
	<br> password:<%=loginUser.getPassword()%>
	<hr>
	<!-- this second way of get the value -->
	username:<jsp:getProperty property="username" name="loginUser" /><br>
	password:<jsp:getProperty property="password" name="loginUser" />

	<%
		String username = loginUser.getUsername();
		String password = loginUser.getPassword();
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		//session save obj
		session.setAttribute("username", username);
		if ("admin".equals(username1) && "123456".equals(password1)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		} else {
			response.sendRedirect("loginFailed.jsp");
		}
	%>
</body>
</html>