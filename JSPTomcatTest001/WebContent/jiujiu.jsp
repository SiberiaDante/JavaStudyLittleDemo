<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String printlnJiuJiu() {
		String result = "";
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				result += i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			result += "<br>";
		}
		return result;

	}%>
	<%!void printJiuJiu(JspWriter out) throws IOException {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				out.println(i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;");
				
			}
			out.println("<br>");
		}
	}%>
	<h2>jiu jiu biao</h2>
	<hr>
	<%=printlnJiuJiu()%>
	<hr>
	<%printJiuJiu(out);%>
</body>
</html>