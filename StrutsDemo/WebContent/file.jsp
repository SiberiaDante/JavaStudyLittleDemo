<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>
</head>
<body>

<form action="file" method="post" enctype="multipart/form-data">
	<label for="myfile">upload your file</label>
	<input >
	<input type="file"  accept = "image/*" name="myfile">
	<input type="submit" value="submit">
</form>
</body>
</html>