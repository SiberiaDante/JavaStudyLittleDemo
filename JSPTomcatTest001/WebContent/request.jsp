<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		request.setAttribute("password", "123456");
	%>
	user name:<%=request.getParameter("username")%><br> password:<%=request.getAttribute("password")%><br>
	favorite:<%
		if (request.getParameterValues("favorite") != null) {
			String[] favorite = request.getParameterValues("favorite");
			for (int i = 0; i < favorite.length; i++) {
				out.println(favorite[i] + "&nbsp;&nbsp;");
			}
		}
	%>
	<hr>
	请求MiME类型：<%=request.getContentType() %><br>
	返回请求的协议类型和版本号<%=request.getProtocol() %><br>
	返回接受请求的服务器主机名<%=request.getServerName()%><br>
	返回服务器接受此请求所用的端口号<%=request.getProtocol()%><br>
	返回请求的字符编码方式<%=request.getCharacterEncoding()%><br>
	返回请求体长度（字节）<%=request.getContentLength() %><br>
	返回发送此请求的客户端IP地址<%=request.getRemoteAddr() %><br>
	返回一虚拟路径的真实路径<%=request.getRealPath("request.jsp") %><br>
	返回上下文路径<%=request.getContextPath() %><br>
</body>
</html>