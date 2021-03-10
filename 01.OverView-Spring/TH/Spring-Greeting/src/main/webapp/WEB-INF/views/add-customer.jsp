<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 3/10/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <h2>Stacked form</h2>
    <form:form method="post" action="/add" modelAttribute="customer">
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input class="form-control" id="email" path="name"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input class="form-control" id="email" path="email"/>
        </div>
        <div class="form-group">
            <label for="address">Adress:</label>
            <form:input class="form-control" id="email" path="address"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
</body>
</html>
