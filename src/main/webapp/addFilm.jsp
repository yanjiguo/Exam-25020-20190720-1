<%--
  Created by IntelliJ IDEA.
  User: yjgzy
  Date: 2019/7/21
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加电影</title>
</head>
<body>
    <form action="addFilm" method="post">
        <input type="text"  placeholder="请输入标题"  name="title">
        <input type="text" placeholder="请输入电影描述" name="description">
        <select name="language">
            <c:forEach var="language"  items="${language}">
                <option value ="language">${language}</option>
            </c:forEach>
        </select>
        <input type="submit"  value="新增"/>
        <p style="color:red;font-size: 14px;margin: 20px;">${str}</p>
    </form>
</body>
</html>
