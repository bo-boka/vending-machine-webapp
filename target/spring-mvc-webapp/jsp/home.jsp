<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="css/VendingCSS.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan" rel="stylesheet">
        <style>

        </style>
    </head>
    <body>
    <center>
        <div class="container">
            <%@include file="headerFragment.jsp" %>
            
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
                                
                                <div class="formatDiv">
                                    Enter Amount: <input type="number" id="amount" placeholder="$"/>
                                    <br><br>
                                    <strong>Change:</strong> 
                                    <br><div style="background-color: white;">$  <span id="changeBack"></span></div>
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

