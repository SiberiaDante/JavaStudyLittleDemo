<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	get user name from session:<%=session.getAttribute("username")%>
	<br> get id from session:<%=session.getId()%><br> attribute
	from session:<%
		String[] names = session.getValueNames();
		for(int i=0;i<names.length;i++){
			out.print(names[i]+"<br>");
		}
	%>
</body>
</html>