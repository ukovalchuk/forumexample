<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 14.09.2017
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topic</title>
</head>
<body>
<html>
<head>
    <title>edit_topic</title>
</head>
<body style="background-color:#ffe0a7;">
<center>
    <font size="+2" color=#ff0000>F</font>
    <font size="+2" color=#ff8c40>O</font>
    <font size="+3" color=#800080>R</font>
    <font size="+3" color=#008000>U</font>
    <font size="+2" color=#0000ff>M</font>
</center>
<br>

<style>
    form {
        display: inline;
    }

    h2 {
        display: inline;
    }

</style>
<script type="text/javascript">
    function clock() {
        var d = new Date();
        var month_num = d.getMonth()
        var day = d.getDate();
        var hours = d.getHours();
        var minutes = d.getMinutes();
        var seconds = d.getSeconds();

        month = new Array("января", "февраля", "марта", "апреля", "мая", "июня",
            "июля", "августа", "сентября", "октября", "ноября", "декабря");

        if (day <= 9) day = "0" + day;
        if (hours <= 9) hours = "0" + hours;
        if (minutes <= 9) minutes = "0" + minutes;
        if (seconds <= 9) seconds = "0" + seconds;

        date_time = "Сегодня - " + day + " " + month[month_num] + " " + d.getFullYear() +
            " г.&nbsp;&nbsp;&nbsp;Текущее время - " + hours + ":" + minutes + ":" + seconds;
        if (document.layers) {
            document.layers.doc_time.document.write(date_time);
            document.layers.doc_time.document.close();
        }
        else document.getElementById("doc_time").innerHTML = date_time;
        setTimeout("clock()", 1000);
    }
</script>
<span id="doc_time">
 Дата и время
</span>
<script type="text/javascript">
    clock();
</script>
<br><br>
    <h2>${topic.text}</h2>
<br><br>
<c:forEach var="comment" items="${comment}">
    ${comment.text}
    <br>
</c:forEach>
<form action="" method="post">
    <p><textarea rows="10" cols="45" name="text"></textarea></p>
    <input type="submit" value="ADD">
</form>
<form action="/main" method="get"><input type="submit" value="BACK"/></form>
</body>
</html>

</body>
</html>
