<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 21.07.2020
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Все игроки</h2><br />

<c:forEach var="rayting" items="${sessionScope.rayting}">
    <ul>

        <li>Ник: <c:out value="${rayting.nickName}"/></li>

        <li>Рейтинг: <c:out value="${rayting.rayting.score}"/></li>
    </ul>
    <hr />

</c:forEach>
<form method="get" action="/back">

    <input type="submit" value="Вернуться на главную страницу!" name="back">
</form>
</body>
</html>
