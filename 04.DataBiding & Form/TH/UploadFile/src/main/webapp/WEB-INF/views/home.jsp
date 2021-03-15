<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Index</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<form:form method="post" action="uploadFile" enctype="multipart/form-data" modelAttribute="MyFiled">
    File: <form:input type="file" path="multipartFile"/> <br /> <br/>
    Description: <form:input path="description"/> <br />
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>