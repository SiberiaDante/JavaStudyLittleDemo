<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/hibtest?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC"
		user="root" password="123456" />

	<!-- insert -->
	<sql:update dataSource="${snapshot }" var="result">
		INSERT INTO student (name,age,address) VALUES ("AAA","19","ShangHai");
	</sql:update>
	<!-- delete -->
	<sql:update dataSource="${snapshot }" var="result">
		DELETE FROM student WHERE id = ?;
		<sql:param value="${16 }"></sql:param>
	</sql:update>
	<!-- update -->
	<sql:update dataSource="${snapshot }" var="result">
		UPDATE student SET name ="BBB" Where id=?;
		<sql:param value="${17 }"></sql:param>
	</sql:update>
	<!-- query -->
	<sql:query dataSource="${snapshot}" var="result">
		SELECT * FROM student;
	</sql:query>
	<c:out value="${result }" />
	<hr>
	<table border=1 width=20%>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>address</th>
		</tr>
		<c:forEach var="row" items="${result.rows }">
			<tr>
				<td><c:out value="${row.id }"></c:out></td>
				<td><c:out value="${row.name }"></c:out></td>
				<td><c:out value="${row.age }"></c:out></td>
				<td><c:out value="${row.address }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<hr>


</body>
</html>