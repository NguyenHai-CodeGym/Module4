<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 3/15/2021
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Mail</title>
</head>
<body>
<form:form method="post" action="update" modelAttribute="mail">
    <table>
        <tr>
            <td><form:label path="language">Language</form:label></td>
            <td><form:select path="language">
                <form:option value="English">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select></td>
        </tr>

        <tr>
            <td><form:label path="pageSize">Language</form:label></td>
           <td><form:select path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="filter">Spams Filter</form:label></td>
            <td><form:checkbox path="filter" value="1"/> Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
           <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
        <tr>
            <td>${mess}</td>
        </tr>
    </table>
</form:form>
</body>
</html>
