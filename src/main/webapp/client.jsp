<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html>
<body>
<h2><fmt:message key="client.base" /></h2>

<table><tr>
    <th>
        <fmt:message key="client.table.id"/>
    </th>
    <th>
        <fmt:message key="client.table.target"/>
    </th>
    <th>
        <fmt:message key="client.table.time"/>
    </th>
</tr>
    <c:forEach items="${tickets}" var="ticket">
        <tr>
            <td>
                <c:out value="${ticket.id}"/>
            </td>
            <td>
                <c:out value="${ticket.target}"/>
            </td>
            <td>
                <c:out value="${ticket.time}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br><br><br>
<form action="client" method="POST">
    <fmt:message key="client.table.choose" />
    <br><br>
    <fmt:message key="client.table.id" /><input name="id" />

    <input type="submit" value="<fmt:message key="login.button" />" />
</form>
</body>
</html>