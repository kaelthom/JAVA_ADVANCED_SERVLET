<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add a user</title>



</head>
<body>
<h1>Add a user</h1>
<form method="post" action="user-details">
    First Name : <input type="text" name="firstname"/> <br>
    Last Name : <input type="text" name="lastname"/> <br>
    Salary : <input type="text" name="salary"/> <br>
    <input type="hidden" name="action" value = "list"/>
    <input type="submit"/>
</form>
</body>
</html>
