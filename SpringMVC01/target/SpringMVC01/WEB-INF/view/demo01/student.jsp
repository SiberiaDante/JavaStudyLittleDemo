<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 山_2
  Date: 2019/1/4
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<form:form method="POST" modelAttribute="student" action="/SpringMVCDemo01/addStudent">
    <table>
        <tr>
            <td><form:label path="name">名字：</form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">年龄：</form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><form:label path="id">编号：</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="password">密码：</form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="address">地址：</form:label></td>
            <td><form:textarea path="address" rows="5" cols="30"/></td>
        </tr>
        <tr>
            <td><form:label path="receivePaper">订阅新闻：</form:label></td>
            <td><form:checkbox path="receivePaper"/></td>
        </tr>
        <tr>
            <td>喜欢的技术/框架</td>
            <td><form:checkboxes path="favoriteFrameworks" items="${webFrameworkList}"/></td>
        </tr>
        <tr>
            <td><form:label path="gender">性别：</form:label></td>
            <td>
                <form:radiobutton path="gender" value="MAN" label="男"/>
                <form:radiobutton path="gender" value="WOMEN" label="女"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="numbers">喜欢的数字：</form:label></td>
            <td><form:radiobuttons path="numbers" items="${numberList}"/></td>
        </tr>
        <tr>
            <td><form:label path="country">所在国家：</form:label></td>
            <td>
                <form:select path="country">
                    <form:option value="NONE" label="请选择..."/>
                    <form:options items="${countryList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="skills">技术：</form:label></td>
            <td><form:select path="skills" items="${skillsList}"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="提交表单"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
