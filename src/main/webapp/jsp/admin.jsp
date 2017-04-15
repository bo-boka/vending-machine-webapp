<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
    <head>
        <title>Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="css/VendingCSS.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="https://code.angularjs.org/latest/angular-messages.min.js"></script>
    </head>
    <body>
    <center>
        <div class="container">
            <%@include file="headerFragment.jsp" %>
            <div class="container">
                <div class="row">
                    <!--  display table-->
                    <div class="col-md-6">
                        <h2>Item List</h2>
                        <%@include file="itemListTableFragment.jsp" %>
                    </div>
                    <div  ng-controller="mainController" class="col-md-6">
                        <h2>Add Item</h2>
                        <!---->
<!--                        <form name="myForm">
                            <label>
                              Enter text:
                              <input type="email" ng-model="field" name="myField" required maxlength="15" />
                            </label>
                            <div ng-messages="myForm.myField.$error" role="alert">
                              <div ng-message="required">Please enter a value for this field.</div>
                              <div ng-message="email">This field must be a valid email address.</div>
                              <div ng-message="maxlength">This field can be at most 15 characters long.</div>
                            </div>
                        </form>-->
                        <!---->
                        
                        <form class="form-horizontal" role="form" name="myForm">
                            <div class="form-group">
                                <label for="add-name" class="col-md-4 control-label">Name:</label>
                                <div class="col-md-8">
                                    <input id="add-name" name="itemName" ng-model="itemName" required maxlength="10" minlength="5" type="text" class="form-control" placeholder="Name"/>
                                    <div ng-if="myForm.itemName.$touched" ng-messages="myForm.itemName.$error" role="alert">
                                        <div class="alert alert-danger" ng-message="required">Please enter a value for this field.</div>
                                        <div class="alert alert-danger" ng-message="minlength">This field is too short.</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-cost" class="col-md-4 control-label">Cost:</label>
                                <div class="col-md-8">
                                    <input id="add-cost" name="itemCost" ng-model="itemCost" required max="100" min="1" type="number" class="form-control" placeholder="0.00"/>
                                    <div ng-if="myForm.itemCost.$touched" ng-messages="myForm.itemCost.$error" role="alert">
                                        <div class="alert alert-danger" ng-message="required">Please enter a value for this field.</div>
                                        <div class="alert alert-danger" ng-message="min">Please enter at least $1.</div>
                                        <div class="alert alert-danger" ng-message="max">Items must be less than $100.</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-inventory" class="col-md-4 control-label">Inventory Amount:</label>
                                <div class="col-md-8">
                                    <input id="add-inventory" name="itemInventory" ng-model="itemInventory" required max="1000" min="1" type="number" class="form-control" placeholder="0"/>
                                    <div ng-if="myForm.itemInventory.$touched" ng-messages="myForm.itemInventory.$error" role="alert">
                                        <div class="alert alert-danger" ng-message="required">Please enter a value for this field.</div>
                                        <div class="alert alert-danger" ng-message="min">Please enter at least 1.</div>
                                        <div class="alert alert-danger" ng-message="max">Items must be less than 1000.</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-8">
                                    <button type="submit" id="add-button" class="btn btn-default">Add Item</button>
                                </div>
                            </div>
                            
                        </form>
                        <div id="validationErrors" class="alert alert-danger" style="display:none"></div>
                    </div>
                </div>
            </div>
        </div>
                    <%@include file="editModalFragment.jsp" %>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vending.js"></script>
    </center>
</body>
</html>

