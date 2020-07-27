<%--
  Created by IntelliJ IDEA.
  User: DNS
  Date: 21.07.2020
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Calculator!</title>
<%--    <script>src = "http://code.jquery.com/jquery-2.2.4.js"--%>
<%--    type = "text/javascript"</script>--%>
<%--    <script>src="app.js"--%>
<%--    type = "text/javascript" </script>--%>
</head>
<body>
<label>Компьютер загадывает 4-х значное число. Цифры загаданного числа не
    повторяются.<br> Ваша задача угадать загаданное число. У
    Вас неограниченное<br> число попыток. В каждую попытку
    Вы даете компьютеру свой вариант числа.<br> Компьютер сообщает
    сколько цифр точно угадано (бык)<br> и сколько цифр угадано без учета
    позиции (корова).</label>
<form name = "MyCalc" method="post" action="/game">
    <p>
        <input type="textfield" name="answer" value="${inp}">
    </p>
    <p>
        <input type="button" value="1" onClick="answer.value+='1'">
        <input type="button" value="2" onClick="answer.value+='2'">
        <input type="button" value="3" onClick="answer.value+='3'">
    </p>
    <p>
        <input type="button" value="4" onClick="answer.value+='4'">
        <input type="button" value="5" onClick="answer.value+='5'">
        <input type="button" value="6" onClick="answer.value+='6'">
    </p>
    <input type="button" value="7" onClick="answer.value+='7'">
    <input type="button" value="8" onClick="answer.value+='8'">
    <input type="button" value="9" onClick="answer.value+='9'">
    <p>
        <input type="button" value="0" onClick="answer.value+='0'">
        <input type="button" value="C" onClick="answer.value=''">
    </p>
    <p> <input type="submit" value="OK" name="ok" ></p>
</form>
<c:forEach var="attempts" items="${sessionScope.attempts}">
    <ul>
        <li>
            Ваше число: <c:out value="${attempts.inputPlayer}"/>
        </li>
        <li>Ответ: <c:out value="${attempts.output}"/></li>

    </ul>
</c:forEach>
</body>
</html>
