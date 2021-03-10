
<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 3/10/2021
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Từ Điển</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Từ Điển 12 Tháng Trong Năm</h2>
    <form:form action="/search" method="post">
        <div class="form-group">
            <label for="usr">Nhập Tháng muốn tìm bằng tiếng anh</label>
            <input type="text" class="form-control" id="usr" name="month"/>
        </div>
        <c:if test="${result != null}">
            <strong>Result: ${result}</strong>
        </c:if>
        <button type="submit" class="btn btn-primary">Convert</button>
    </form:form >
</div>
</body>
</html>
