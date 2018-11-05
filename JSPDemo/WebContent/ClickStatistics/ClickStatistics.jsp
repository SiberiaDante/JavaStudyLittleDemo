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
		Integer clickTime = (Integer) application.getAttribute("click_time");
		if (clickTime == null || clickTime == 0) {
			out.println("welcome to study JSP");
			clickTime=1;
		}else{
			out.println("welcome to study JSP again!!!");
			out.println(clickTime);
			clickTime++;
		}
		application.setAttribute("click_time", clickTime);
	%>
</body>
</html>