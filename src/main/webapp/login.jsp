<%--
  Created by IntelliJ IDEA.
  User: yjgzy
  Date: 2019/7/21
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="LoginServlet" method="post">
        用户名：<input type="text"  placeholder="请输入你的姓名" name="firstName">
        <input style="margin-left: 80px;background-color: red;border-radius: 10px;color: #ffffff" onclick="login()" type="submit" value="登录">
        <p style="color:red;font-size: 14px;margin: 20px;">${str}</p>
    </form>
</body>
</html>
