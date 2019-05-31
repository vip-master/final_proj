<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html>
<body>
<h2><fmt:message key="login.base" /></h2>
<form action="login" method="POST">
    <fmt:message key="login.name" /><input name="login" />
    <br><br>
    <fmt:message key="login.pass" /><input name="password" />

    <input type="submit" value="<fmt:message key="login.button" />" />
</form>
</body>
</html>