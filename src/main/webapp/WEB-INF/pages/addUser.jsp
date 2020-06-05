<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header.jsp"/>
<h1>Add a user</h1>

<c:url var="contextPathUrl" value="/user-details"/>

<ul>
    <li>${pageScope.contextPathUrl}</li>
    <li>${requestScope.contextPathUrl}</li>
    <li>${sessionScope.contextPathUrl}</li>
    <li>${applicationScope.contextPathUrl} </li>
</ul>
<form method="post" action="${contextPathUrl}">
    First Name : <input type="text" name="firstname" placeholder="Your firstname"/> <br>
    Last Name : <input type="text" name="lastname" placeholder="Your lastname"/> <br>
    Salary : <input type="number" name="salary"/> <br>
    <input type="hidden" name="action" value = "list"/>
    <input type="submit"/>
</form>


<jsp:include page="../templates/footer.jsp"/>
