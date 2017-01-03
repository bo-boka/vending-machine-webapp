<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Vending Machine Web App</h1>
<hr/>
<div class="navbar">
    <ul class="nav nav-tabs">
        <li role="presentation" class="${pageContext.request.requestURI eq '/BlogCapstone/jsp/home.jsp' ? ' active' : ''}"><a class="menu" href="${pageContext.request.contextPath}/home">Home</a></li>
        <li role="presentation" class="${pageContext.request.requestURI eq '/BlogCapstone/jsp/home.jsp' ? ' active' : ''}"><a class="menu" href="${pageContext.request.contextPath}/stats">Stats</a></li>
        <sec:authorize access="isFullyAuthenticated()">
            <li role="presentation" class="${pageContext.request.requestURI eq '/BlogCapstone/jsp/admin.jsp' ? ' active' : ''}"><a class="menu" href="${pageContext.request.contextPath}/admin">Admin</a></li>
        </sec:authorize>
        <sec:authorize access="!isFullyAuthenticated()">
            <li role="presentation" class="pull-right"><a href="${pageContext.request.contextPath}/login">Login</a></li>
        </sec:authorize>
        <sec:authorize access="isFullyAuthenticated()">
            <li role="presentation" class="pull-right"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li> 
        </sec:authorize> 
    </ul>    
</div>