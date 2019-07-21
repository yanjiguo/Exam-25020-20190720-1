<%--
  Created by IntelliJ IDEA.
  User: yjgzy
  Date: 2019/7/21
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>电影信息列表</title>
</head>
<body>
    <h3>电影信息列表</h3>
    <c:forEach var="film"  items="${allFilm}">
        <div class="film">
            <p>${film.getFilmId()} </p>
            <p>${film.getTitle()}</p>
            <p>${film.getDescription()} </p>
            <p>${film.getName()} </p>
        </div>
        <li><a href="deleteFilm?filmId=${film.getFilmId()}"  style="color: red;">删除</a>
            <a href="skipUpdateFilmPage?filmId=${film.getFilmId()}" style="color: red;">编辑</a></li>
    </c:forEach>
    <div class="position">
        <a href="javascript:first();" title="首页">&laquo;首页</a>
        <a href="javascript:sub(${pageNo});" title="上一页">&laquo; 上一页</a>
        <a href="javascript:first();" class="number current" title="1">1</a>
        <a href="javascript:second();" class="number" title="2">2</a>
        <a href="javascript:three();" class="number" title="3">3</a>
        <a href="javascript:four();" class="number" title="4">4</a>
        <a href="javascript:add(${pageNo});" title="下一页">下一页&raquo;</a>
        <input value="1" size="2" />
        &nbsp;页<a href="#">GO</a>
        </li>
    </div>
</body>
<script type="text/javascript">


    function add(pageno){
        pageno = pageno+1;
        location.href="FilmServlet?pageNo="+pageno+"&pagesize=10";
    }

    function sub(pageno){
        if(pageno>1){
            pageno = pageno-1;
            location.href="FilmServlet?pageNo="+pageno+"&pagesize=10";
        }else{
            alert("已经是第一页");
        }
    }
    function first(){
        location.href="FilmServlet?pageNo=1&pagesize=10";
    }
    function second(){
        location.href="FilmServlet?pageNo=2&pagesize=10";
    }
    function three(){
        location.href="FilmServlet?pageNo=3&pagesize=10";
    }
    function four(){
        location.href="FilmServlet?pageNo=4&pagesize=10";
    }

</script>
</html>
