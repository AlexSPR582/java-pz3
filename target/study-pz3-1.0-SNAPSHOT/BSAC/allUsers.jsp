<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>View All Users</title>
</head>
<body>
    <h1>View all users</h1>
    <a href="${pageContext.request.contextPath}/BSAC/home.jsp">Home Page</a><br>
    <c:if test="${isAdmin}">
        <h3>You are Admin</h3>
        <p>
            Count all users
            <c:out value="${users.size()}"/>
            <table width="100%" border="1">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Last login date</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                        <td>
                            <c:if test="${user.loginDate == null}">
                                Пользователь не логинился
                            </c:if>
                            <c:if test="${user.loginDate != null}">
                                <f:formatDate value="${user.loginDate}" type="both" dateStyle="long"/>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </p>
    </c:if>
</body>
</html>
