<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 山_2
  Date: 2019/1/4
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form:form modelAttribute="user" method="post" action="register">
        <table>
            <tr>
                <td>姓名:</td>
                <td><form:input path="username"/></td>
                <td><font color="red"><form:errors path="username"/></font></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><form:input path="sex"/></td>
                <td><font color="red"><form:errors path="sex"/></font></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><form:input path="age"/></td>
                <td><font color="red"><form:errors path="age"/></font></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"/></td>
            </tr>
        </table>
    </form:form>
</head>
<body>

</body>
</html>
