<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login.action" method="post">
		username:<input type="text" name="user.username"><br><s:fielderror name="username"></s:fielderror>
		password:<input type="password" name="user.password">
		<input type="submit" value="submit">
	</form>
</body>
</html>