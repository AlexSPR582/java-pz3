<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>
        Hello, <%= session.getAttribute("user") %>
    </h1>
    <c:if test="${isAdmin}">
        <p><a href="${pageContext.request.contextPath}/BSAC/allUsers.jsp">View all users</a></p>
    </c:if>

    <form action="logout" method="post">
        <input type="hidden" name="authAction" value="logout">
        <input type="submit" value="Logout" />
    </form>
</body>
</html>
