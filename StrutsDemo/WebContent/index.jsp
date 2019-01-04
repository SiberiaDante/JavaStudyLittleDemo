<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<p>Struts2 Demo</p>
	<form action="hello">
		<label for="name">Please enter your name</label><br /> <input
			type="text" name="name" /> <input type="submit" value="Say Hello" />
	</form>
</body>
</html>