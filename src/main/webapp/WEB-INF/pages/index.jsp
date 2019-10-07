<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<form action="myAction">
    <input type="submit" value="Say hello">
    <h1> ${attrib} </h1>
</form>

<form action="findRichest">
    <input type="submit" value="Show Richest">
    <h1> ${dev} </h1>
</form>

</body>
</html>
