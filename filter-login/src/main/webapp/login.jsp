<%--
  Created by IntelliJ IDEA.
  User: Salman_AF
  Date: 12/1/2020
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Selamat Datang di WEBSITE SEDERHANA</h2>
<p style="color: darkblue">
    <c:if test="${param.notlogged}">
        Anda Belum Login !
    </c:if>
</p>
<form method="post" action="login">
    <div>
        <label for="username">username</label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">password</label>
        <input type="password" name="password" id="password">
    </div>
    <button type="submit" value="login">Submit</button>
</form>
<p style="color: red;">
    <c:if test="${param.error}">
        Invalid Username/Password
    </c:if>
</p>
</body>
</html>
