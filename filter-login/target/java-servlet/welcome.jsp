<%--
  Created by IntelliJ IDEA.
  User: Salman_AF
  Date: 12/1/2020
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Selamat Datang, ${username}</h1>
    <p>Request Attribute ${handsomeguy}</p>
    <c:set var="login" value="<%= request.getAttribute("login")%>"/>
    <p>
        <c:if test="${login}">
            <c:out value="${login}"/>
        </c:if>
    </p>

    <form action="logout" method="post">
        <button type="submit" value="logout">logout</button>
    </form>
</body>
</html>
