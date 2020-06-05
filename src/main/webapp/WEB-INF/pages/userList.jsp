<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
    <h2>Users :</h2>
    <ul>
        <c:forEach items="${users}" var = "userOfList">
            <li>
                <a href= ${userOfList.linkFromUserList}>${userOfList.firstname} ${userOfList.lastname}</a>
                <a href= "/MyWebApp/user-details?action=detail&id=${userOfList.lastname}">${userOfList.firstname} ${userOfList.lastname}</a>
                <c:choose>
                    <c:when test="${userOfList.salary>20}">High salary</c:when>
                    <c:when test="${userOfList.salary>10}">Medium salary</c:when>
                    <c:otherwise>Low salary</c:otherwise>
                </c:choose>
            </li>
        </c:forEach>
    </ul>

    <form action = "user-details">
        <input type="hidden" name="action" value="add"/>
        <input type="submit" value="Add a new user"/>
    </form>

    <a href="?action=add">Add an user</a>

<jsp:include page="../templates/footer.jsp"></jsp:include>
