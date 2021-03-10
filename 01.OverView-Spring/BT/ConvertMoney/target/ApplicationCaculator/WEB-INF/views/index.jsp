
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
    <title>Convert Money</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Currency conversion</h2>
    <form:form action="/convert" method="post">
        <div class="form-group">
            <label for="usr">Số lượng</label>
            <input type="number" class="form-control" id="usr" name="money"/>
        </div>
        <div class="form-group">
            <select name="convertFrom" class="form-control">
                <option value="USD">USD</option>
                <option value="VND">VND</option>
            </select>
        </div>
        <label for="usr">To</label>
        <div class="form-group">
            <select name="convertTo" class="form-control">
                <option value="VND">VND</option>
                <option value="USD">USD</option>
            </select>
        </div>
        <c:if test="${moneyConvert != null}">
            <strong>Result: ${moneyConvert}</strong>
        </c:if>
        <button type="submit" class="btn btn-primary">Convert</button>
    </form:form >
</div>
</body>
</html>
