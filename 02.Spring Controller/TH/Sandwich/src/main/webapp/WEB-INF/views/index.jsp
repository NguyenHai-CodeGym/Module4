<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 3/11/2021
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<form:form method="post" action="/save">
   <c:forEach items="${list}" var="ingredient">
       <input type="checkbox" id="${ingredient.name}" name="spice" value=${ingredient.name}>
       <label for="${ingredient.name}">${ingredient.name}</label>
   </c:forEach>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
