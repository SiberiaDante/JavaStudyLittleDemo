<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="salary" scope="session" value="${2000*2}" />
	<c:out value="2000*2=${salary}" />
	<c:remove var="salary" scope="session" />
	<p>user remove label later:</p>
	<c:out value="2000*2=${salary}" />
	<hr>
	<c:catch var="catchException">
		<%
			int x = 5 / 0;
		%>
	</c:catch>

	<c:if test="${catchException!=null}">
		<p>
			exception is:${catchException }<br>
		</p>
		exception message:${catchException.message}
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${salary>8000 }">
			salary > 000
		</c:when>
		<c:when test="${salary>=4000 }">
			salary > 4000
		</c:when>
		<c:otherwise>
			salary < 2000
		</c:otherwise>
	</c:choose>
	<hr>
	<c:import url="http://www.baidu.com" var="data"></c:import>
	<c:out value="${data }" />
	<hr>
	<c:forEach var="i" begin="1" end="10" step="2">
		<c:out value="${i }" />
	</c:forEach>
	<hr>
	<c:forTokens items="AAA,BBB,CCC,DDD" delims="," var="str">
		<c:out value="${str }" />
	</c:forTokens>
	<hr>
	<a href="<c:url value="http://www.baidu.com"></c:url>">This link
		from &lt;c:url&gt;</a>
	<hr>
	<%-- 	<c:redirect url="http://www.baidu.com"></c:redirect> --%>
	<hr>
	<c:url var="myurl" value="index.jsp">
		<c:param name="name" value="Dante"></c:param>
		<c:param name="url" value="github"></c:param>
	</c:url>
	<a href="/<c:out value="${myurl }"/>">use &lt;c: param&gt;send two params for this
		url</a>
</body>
</html>