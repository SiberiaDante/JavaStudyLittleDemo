<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
	Cookie secondName = new Cookie("second_name", request.getParameter("second_name"));
	firstName.setMaxAge(60 * 24 * 24);
	secondName.setMaxAge(60 * 24 * 24);
	response.addCookie(firstName);
	response.addCookie(secondName);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Setting Cookies</title>
</head>
<body>
	<ul>
		<li><p>
				FirstName:<%=request.getParameter("first_name")%></p></li>
		<li><p>
				SecondName:<%=request.getParameter("second_name")%></p></li>
	</ul>


</body>
</html>