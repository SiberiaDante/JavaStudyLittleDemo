<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSP 生命周期</title>
</head>
<body>
	<%!private int initCount = 0;
	private int serviceCount = 0;
	private int destoryCount = 0;%>

	<%!public void jspInit() {
		initCount++;
		System.out.println("jspInit()：初始化了----" + initCount + "次-----");
	}

	public void jspDestory() {
		destoryCount++;
		System.out.println("jspDestory():销毁了----" + destoryCount + "次-----");
	}%>

	<%
		serviceCount++;
		System.out.println("-jspService():JSP共响应了----" + serviceCount + "次------");
		String contentInit = "初始化次数：" + initCount;
		String contentService = "响应次数：" + serviceCount;
		String contentDestory = "销毁次数：" + destoryCount;
	%>

	<h1>JSP 生命周期测试</h1>
	<p><%=contentInit%></p>
	<p><%=contentService%></p>
	<p><%=contentDestory%></p>
</body>
</html>