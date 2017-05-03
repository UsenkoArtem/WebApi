<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> Hello </h1>
<jsp:useBean id="userAll" scope="request" type="java.util.List"/>
<c:forEach items="${userAll}" var="user" >
 <c:out value="${user.name}"></c:out>
 <c:out value="${user.username}"></c:out>
 <c:out value="${user}"></c:out>
    </br>
</c:forEach>
</body>
</html>