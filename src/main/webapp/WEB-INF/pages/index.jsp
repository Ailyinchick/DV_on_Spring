<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<form action="/myAction">
    <input type="submit" value="Hello from spring">
    <h1> ${attrib} </h1>
</form>


<form action="/findById">
    <input type="text" name="userID"/>
    <input type="submit" value="Find by ID">
    <h1> ${userById} </h1>
</form>

<form action="/findRichest">
    <input type="submit" value="Show Richest">
    <h1> ${richestUser} </h1>
</form>

<form action="/findAll">
    <input type="submit" value="Display all">
    <h1> ${allUsers} </h1>
</form>

<form action="/bankSumm">
    <input type="submit" value="Bank summ">
    <h1> ${bankSumm} </h1>
</form>

</body>
</html>
