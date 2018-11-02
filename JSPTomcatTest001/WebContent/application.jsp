<%@page import="java.util.Enumeration"%>
<%@page import="javax.lang.model.element.Element"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application JSP</title>
</head>
<body>
	<%
		application.setAttribute("city", "beijing");
		application.setAttribute("postcode", 10000);
		application.setAttribute("email", "ssss@qq.com");
	%>

	get the city:<%=application.getAttribute("city")%>
	<br> attribute:
	<%
		Enumeration ele = application.getAttributeNames();
		while (ele.hasMoreElements()) {
			out.print(ele.nextElement() + "<br>");
		}
	%>
	JSP code:<%=application.getServerInfo()%>

</body>
</html>