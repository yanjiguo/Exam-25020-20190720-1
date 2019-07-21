<%--
  Created by IntelliJ IDEA.
  User: yjgzy
  Date: 2019/7/21
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新电影信息</title>
</head>
<body>
    <form action="updateFilm" method="post">
        <input type = "text" name="fileId" value="${film.getFilmId()}" style="display:none">
        <input type = "text"  placeholder="请输入标题"  name="title" value="${film.getTitle()}">
        <textarea name="description" rows="5" cols="40">
            ${film.getDescription()}
        </textarea>
        <select name = "language">
            <option value ="${film.getName()}">${film.getName()}</option>
        </select>
        <input type="submit"  value="修改"/>
        <p style="color:red;font-size: 14px;margin: 20px;">${str}</p>
    </form>
</body>
</html>
