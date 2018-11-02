<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:useBean id="userLoginBean" class="com.jsp.bean.LoginUserBean"
	scope="page"></jsp:useBean>
<jsp:useBean id="userLoginDao" class="com.jsp.dao.UserBeanDao"
	scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="userLoginBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Test Login Result</title>
</head>
<body>
	<%
		if (userLoginDao.loginSuccess(userLoginBean)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		} else {
			response.sendRedirect("loginFailed.jsp");
		}
	%>

</body>
</html>