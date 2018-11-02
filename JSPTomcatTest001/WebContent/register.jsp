<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>user register</title>
</head>
<body>
	<h1>User Register</h1>
	<hr>
	<!-- <form action="request.jsp" method="post" name="regForm"> -->
	<form action="response.jsp" method="post" name="regForm">
		<table>
			<tr>
				<td>user name:</td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td>favorite</td>
				<td><input type="checkbox" name="favorite" value="read" />read
					<input type="checkbox" name="favorite" value="music" />music <input
					type="checkbox" name="favorite" value="movie" />movie <input
					type="checkbox" name="favorite" value="internet" />internet</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit value=" submit" /></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<a href="request.jsp?username=sd啊啊啊的">test url</a>
</body>
</html>