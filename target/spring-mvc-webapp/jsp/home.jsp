<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="css/VendingCSS.css" rel="stylesheet" type="text/css">
        <style>

        </style>
    </head>
    <body>
    <center>
        <div class="container">
            <h1>Vending Machine Web App</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                </ul>    
            </div>
            <div class="container">
                <div class="vendOuter">
                    <form>
                        <div class="row">
                            <div class="col-sm-7">
                                <h3>Get Some</h3>
                                <%@include file="vendingTableFragment.jsp" %>
                            </div>
                            <div class="col-sm-5">
                                <h3>Insert Some</h3>
                                Amount: <input type="number" id="amount" placeholder="$"/><br>
                                <div class="formatDiv">
                                    <strong>Change:</strong> $ <span id="changeBack"></span>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vending.js"></script>
    </center>
</body>
</html>

