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
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		out.println("------------print cookies content-------------<br/>");
		if (cookies != null) {
			for (Cookie c : cookies) {
				out.println("name:" + c.getName() + "---value:" + c.getValue() + "<br/>");
			}
		}
	%>

</body>
</html>