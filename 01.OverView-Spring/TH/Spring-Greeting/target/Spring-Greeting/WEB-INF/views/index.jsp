<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 3/10/2021
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>

<div class="container">
        <c:if test="${mess != null}">
            <div class="alert alert-success">
            <strong>${mess}</strong>
            </div>
        </c:if>
    <button type="button" class="btn"></button>
    <button type="button" class="btn btn-success"><a href="/add">Add Item</a></button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="customer">
        <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td><a href="/delete?id=${customer.id}">Delete</a></td>
                <td><a href="/edit?id=${customer.id}">Edit</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
