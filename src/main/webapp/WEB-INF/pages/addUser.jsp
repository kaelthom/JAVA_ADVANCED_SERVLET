<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
<h1>Add a user</h1>
<form method="post" action="user-details">
    First Name : <input type="text" name="firstname" placeholder="Your firstname"/> <br>
    Last Name : <input type="text" name="lastname" placeholder="Your lastname"/> <br>
    Salary : <input type="number" name="salary"/> <br>
    <input type="hidden" name="action" value = "list"/>
    <input type="submit"/>
</form>
</body>
</html>
