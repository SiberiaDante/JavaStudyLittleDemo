<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="<%=basePath%>resources/js/common/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/js/add/add.js"></script>
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" value="<%=basePath%>" id="basePath" />
	<%-- <form action="<%=basePath%>AddMessageServlet.action" method="post"> --%>
	<table>
		<tr>
			<td>请输入指令：</td>
			<td><input type="text" id="command" /></td>
		</tr>
		<tr>
			<td>请输入描述</td>
			<td><input type="text" id="description" /></td>
		</tr>
		<tr>
			<td>请输入内容</td>
			<td><input type="text" id="content"></td>
		</tr>
		<tr>
			<td><input type="button" onclick="addMsg()" value="提交"></td>
		</tr>
	</table>
	<!-- </form> -->
</body>
</html>