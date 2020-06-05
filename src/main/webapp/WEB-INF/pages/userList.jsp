<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users</title>
    <h2>Users :</h2>
    <ul>
        <c:forEach items="${users}" var = "userOfList">
            <li>
                <a href= ${userOfList.linkFromUserList}>${userOfList.firstname} ${userOfList.lastname}</a>
                <a href= "/MyWebApp/user-details?action=detail&id=${userOfList.lastname}">${userOfList.firstname} ${userOfList.lastname}</a>
            </li>
        </c:forEach>
    </ul>

    <form action = "user-details">
        Add a new user : <input type="hidden" name="action" value="add"/>
        <input type="submit"/>
    </form>


</head>
<body>

</body>
</html>
