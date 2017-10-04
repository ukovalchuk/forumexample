<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<form action="" method="post">
    <h2>${topic.text}</h2>
    <input type="submit" value="EDIT">

</form>
<br><br>
<c:forEach var="comment" items="${comment}">
    ${comment.text}
    <form action="" method="post">
        <input type="submit" value="EDIT">

    </form><br>
</c:forEach>
<form action="" method="post">
    <p><textarea rows="10" cols="45" name="text"></textarea></p>
    <input type="submit" value="ADD">
</form>
<form action="" method="POST"><input type="submit" value="BACK"/></form>
</body>
</html>
