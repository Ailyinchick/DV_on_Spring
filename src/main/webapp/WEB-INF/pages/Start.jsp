<%--
  Created by IntelliJ IDEA.
  User: ailyi
  Date: 22.09.2019
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Death Valley</title>
</head>
<body>
<form action="findByID">
    <input type="text" name="userID"/>
    <input type="submit" name="Submit">
    <p> Find by id: ${findbyid} </p>
</form>
<form action="findAll">
    <input type="submit" value="Display bank">
    <p>Accounts: ${account}</p>
</form>
<form action="findRichest">
    Find the richest <input type="submit" value="Submit"/>
    <p> Name: ${name}</p>
</form>
<form action="totalBank">
    Get total bank <input type="submit" value="Submit"/>
    <p> Name: ${summ}</p>
</form>
</body>
</html>
