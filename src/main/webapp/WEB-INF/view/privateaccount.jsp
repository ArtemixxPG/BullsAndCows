<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 21.07.2020
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Личный кабинет</h2>

    <ul>

        <li>Имя: <c:out value="${sessionScope.player.nickName}"/></li>

        <li>Рейтинг: <c:out value="${sessionScope.player.rayting.score}"/></li>
    </ul>

<form method="get" action="/goupdate">
    <h2>Чтобы изменить свои параметры нажмите здесь</h2>
    <input type="submit" value="Изменить..." name="update">
</form>
<form method="post" action="/delete">
    <h2>Чтобы изменить свои параметры нажмите здесь</h2>
    <input type="submit" value="Удалить" name="update">
</form>
<form method="get" action="/home">

    <input type="submit" value="Вернутся на главную" name="return">
</form>
<form method="get" action="/back">

    <input type="submit" value="Вернуться на главную страницу!" name="back">
</form>
</body>
</html>
