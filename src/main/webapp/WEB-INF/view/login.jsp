<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 21.07.2020
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>

<div class="form">

    <h1 >Вход в систему</h1><br>

    <form method="post" action="/auth">

        <input al type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Войти">

    </form>
    <form method="get" action="/registration">
        <h2>Если Вы не зарегистрированы, нажмите здесь!</h2>
        <input type="submit" value="login" name="Login!">
    </form>
</div>
</body>
</html>
