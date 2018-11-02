<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%!private int initVar = 0;
	private int serviceVar = 0;
	private int destoryVar = 0;
	private int day = 1;%>
	<%!public void jspInit() {
		initVar++;
		System.out.println("jspInit():被初始化了" + initVar + "次");
	}

	public void jspDestory() {
		destoryVar++;
		System.out.println("jspDestory():被销毁了" + destoryVar + "次");
	}%>
	<%
		serviceVar++;
		System.out.println("jspService():JSP共响应了" + serviceVar + "次");
		String content1 = "初始化次数：" + initVar;
		String content2 = "响应请求次数：" + serviceVar;
		String content3 = "销毁次数：" + destoryVar;
		out.println("Your IP address is :" + request.getRemoteAddr());
	%>
	<h1>菜鸟教程JSP实例</h1>
	<p><%=content1%></p>
	<p><%=content2%></p>
	<p><%=content3%></p>
	<%
		if (day == 1 | day == 7) {
	%>
	<p>今天是周末</p>
	<%
		}
	%>
	<%-- <jsp:include page="NewFile.jsp" flush="true"></jsp:include> --%>

	<jsp:forward page="NewFile.jsp" />
	<%-- <jsp:useBean id="test" class="com.dante.main.TestBean" />
	<jsp:setProperty name="test" property="message" value="菜鸟教程..." />
	<jsp:getProperty property="message" name="test" /> --%>
</body>
</html>