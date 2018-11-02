<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>out 内置对象</title>
</head>
<body>
	<%-- <%
	out.println("床前明月光");
	out.println("疑似地上霜");
	out.println("举头望明月");
	out.println("低头思故乡");
	%> --%>
	<p>床前明月光</p>
	<p>疑似地上霜</p>
	<%
		out.flush();
		//out.clear();
		out.clearBuffer();
	%>
	<p>举头望明月</p>
	<p>低头思故乡</p>
	<%=out.getBufferSize()%><br>
	<%=out.getRemaining()%><br>
	<%=out.isAutoFlush()%><br>
	<%
		out.flush();
	%>
</body>
</html>