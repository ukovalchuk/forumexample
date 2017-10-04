<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 13.09.2017
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
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
    form {
        display: inline;
    }


</style>
<form:form id="regForm" modelAttribute="userForm" action="registerProcess" method="post">
    <b>Login:</b> <input name="login" placeholder="Login" required/><br>
    <b>Password:</b> <input name="password" placeholder="Password" required/><br>
    <b>Email:</b> <input name="email"placeholder="Email" required/><br>
    <input type="submit" value="OK"/></form:form>
<form action="/login" method="POST"><input type="submit" value="<---"/></form>


</body>
</html>
