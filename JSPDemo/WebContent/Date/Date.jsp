<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf.format(date);
		boolean isAfter = date.after(new Date(2018, 11, 11));
		boolean isBefore = date.before(new Date(2018, 11, 11));
	%>
	current date:<%=formatDate%><br> current date is after 2018-11-11:<%=isAfter%><br>
	current date is before 2018-11-11:<%=isBefore%>

</body>
</html>