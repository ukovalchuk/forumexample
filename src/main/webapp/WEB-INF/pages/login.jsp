<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 11.09.2017
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start Page</title>
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
    b {
        width: 80px;
        display: inline-block;
    }
    form{
        display: inline;
    }
</style>
<form action="/main" method="post">
    <b>Login:</b> <input name="login" placeholder="Login" required/><br>
    <b>Password:</b> <input name="password" placeholder="Password" required/><br>
    <input type="submit" value="OK"/></form>
<form action="/register" method="get"><input type="submit" value="Register"/></form>
<marquee behavior="alternate" direction="right"><h2>Here could be your advertisement.</h2></marquee>


</body>
</html>
