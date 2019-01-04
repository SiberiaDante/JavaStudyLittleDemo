<%--
  Created by IntelliJ IDEA.
  User: 山_2
  Date: 2019/1/4
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student Result</title>
</head>
<body>
<table>
    <tr>
        <td>名称：</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>年龄：</td>
        <td>${age}</td>
    </tr>
    <tr>
        <td>编号：</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${password}</td>
    </tr>
    <tr>
        <td>地址：</td>
        <td>${address}</td>
    </tr>
    <tr>
        <td>订阅新闻：</td>
        <td>${receivePaper}</td>
    </tr>
    <tr>
        <td>喜欢的技术/框架：</td>
        <td>
            <% String[] favoriteFrameworks = (String[]) request.getAttribute("favoriteFrameworks");
                for (String frameworks : favoriteFrameworks) {
                    out.println(frameworks);
                }
            %>
        </td>
    </tr>
    <tr>
        <td>性别：</td>
        <td>${(gender=="MAN"?"男":"女")}</td>
    </tr>
    <tr>
        <td>喜欢的数字：</td>
        <td>${numbers}</td>
    </tr>
    <tr>
        <td>国家：</td>
        <td>${country}</td>
    </tr>
    <tr>
        <td>技术：</td>
        <td>
            <%
                String[] skillList = (String[]) request.getAttribute("skills");
                for (String skill : skillList) {
                    out.println(skill);
                }
            %>
        </td>
    </tr>
</table>
</body>
</html>
