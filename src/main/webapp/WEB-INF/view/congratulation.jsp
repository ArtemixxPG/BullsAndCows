<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 26.07.2020
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>End</title>
</head>
<body>
<h2>Поздравляем, Вы выиграли!</h2>
<c:forEach var="attempts" items="${sessionScope.attempts}">
    <ul>
        <li>
            Ваше число: <c:out value="${attempts.inputPlayer}"/>
        </li>
        <li>Ответ: <c:out value="${attempts.output}"/></li>

    </ul>
</c:forEach>
<form method="get" action="/back">

    <input type="submit" value="Вернуться на главную страницу!" name="back">
</form>

<form method="post" action="<c:url value='/newgame'/>">
    <input type="submit" value="Новая игра" name="newgame"><br>
</form>
</body>
</html>
