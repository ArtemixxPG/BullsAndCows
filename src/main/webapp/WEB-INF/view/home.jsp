<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 21.07.2020
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Добро пожаловать в игру "Быки и коровы!"</h2>

<form method="post" action="<c:url value='/rayting'/>">
    <input type="submit" value="Рейтинг" name="rayting"><br>
</form>
<form method="get" action="<c:url value='/lk'/>">
    <input type="submit" value="Личный кабинет" name="lk"><br>
</form>
<form method="post" action="<c:url value='/newgame'/>">
    <input type="submit" value="Новая игра" name="newgame"><br>
</form>
<form method="get" action="<c:url value='/logout'/>">
    <input type="submit" value="Выйти" name="logout"><br>
</form>
</body>
</html>
