<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html>
<body>
<h2><fmt:message key="admin.base" /></h2>

<table><tr>
    <th>
        <fmt:message key="admin.table.id"/>
    </th>
    <th>
        <fmt:message key="admin.table.login"/>
    </th>
    <th>
        <fmt:message key="admin.table.password"/>
    </th>
    <th>
        <fmt:message key="admin.table.id_trip"/>
    </th>
</tr>
    <c:forEach items="${passangers}" var="passanger">
        <tr>
            <td>
                <c:out value="${passanger.id}"/>
            </td>
            <td>
                <c:out value="${passanger.login}"/>
            </td>
            <td>
                <c:out value="${passanger.id_trip}"/>
            </td>
        </tr>
    </c:forEach></table>

<form action="change/admin" method="POST">
    <fmt:message key="admin.table.change" />
    <br><br>
    <fmt:message key="admin.table.id" /><input name="id" />
    <br><br>
    <fmt:message key="admin.table.login" /><input name="login" />
    <br><br>
    <fmt:message key="admin.table.password" /><input name="password" />
    <br><br>
    <fmt:message key="admin.table.id_trip" /><input name="id_trip" />

    <input type="submit" value="<fmt:message key="login.button" />" />
</form>
<br><br><br><br>
<form action="delete/admin" method="POST">
    <fmt:message key="admin.table.delete" />
    <br><br>
    <fmt:message key="admin.table.id" /><input type="text" name="id" />

    <input type="submit" value="<fmt:message key="login.button" />" />
</form>
</body>
</html>