<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="machineApp">
    <head>
        <title>ELECTROvend</title>
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="css/VendingCSS.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="https://code.angularjs.org/latest/angular-messages.min.js"></script>
        <script src="https://code.angularjs.org/latest/angular-resource.min.js"></script>
    </head>
    <body>
    <center>
        <div class="container">
            
            <div class="container">
                <sec:authorize access="isFullyAuthenticated()">
                    <div role="presentation" class="pull-right"><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></div> 
                </sec:authorize>
                <div class="row vendOuter" ng-controller="machineController">
                    
                    <sec:authorize access="!isFullyAuthenticated()">
                        <div role="presentation" class="pull-right"><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-cog" style="color: white;"></span></a></div>
                    </sec:authorize>
                    <sec:authorize access="isFullyAuthenticated()">
                        <div role="presentation" class="pull-right"><a class="menu" href="${pageContext.request.contextPath}/admin"><span class="glyphicon glyphicon-cog" style="color: white;"></span></a></div>
                    </sec:authorize>
                    
                    <div class="col-sm-12">
                        <marquee scrollamount="15">ELECTROvend</marquee>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12">
                        
                        <!--<div id="itemRows"></div>-->
                        <div class="row clearfix">
                            <div ng-repeat="item in items">
                                <div class="col-sm-3 item" ng-click="purchaseItem(item.id)"><button><strong>{{item.name}}</strong><br>\${{item.cost}}</button></div>
                                
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12">
                        <div class="moneyDiv">
                            Enter Amount: <input type="number" id="amount" placeholder="$"/>
                            <br><br>
                            <strong>Change:</strong> 
                            <br><div style="background-color: white;">$  <span id="changeBack"></span></div>
                        </div>
                        <div>
                            <div id="vendItem" style="display: none;">
                                <div ng-cloak> {{ item }}</div>
                                <img src="http://fixmybrokenmac.co.uk/wp-content/uploads/2017/03/iphone-6GREY.png" height="300" width="260"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <center><img src='${pageContext.request.contextPath}/img/icon.png'/></center>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vending.js"></script>
    </center>
</body>
</html>

