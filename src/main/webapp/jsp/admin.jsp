<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="adminApp">
    <head>
        <title>ElectroVend</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="css/VendingCSS.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="https://code.angularjs.org/latest/angular-messages.min.js"></script>
        <script src="https://code.angularjs.org/latest/angular-resource.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
    </head>
    <body>
    <center>
        <div class="container">
            <%@include file="headerFragment.jsp" %>
            <div class="container">
                <div class="row" ng-controller="adminController">
                    <!--  display table-->
                    <div class="col-md-6">
                        <h2>Item List</h2>
                        <table id="itemListTable" class="table table-hover">
                            <thead>
                                <th width="40%">Name</th>
                                <th width="15%">Cost</th>
                                <th width="15%">Stock</th>
                                <th width="15%"></th>
                                <th width="15%"></th>
                            </thead>
                            <tbody id="itemListRows" ng-repeat="item in items">
                                <tr>
                                    <td>{{ item.name }}</td>
                                    <td>{{ item.cost }}</td>
                                    <td>{{ item.inventory }}</td>
                                    <td><a data-toggle="modal" data-target="#item-edit-modal" ng-click="viewEditModal(item.id)">Edit</a></td>
                                    <td><a ng-click="deleteItem(item.id)">Delete</a></td>
                                </tr>
                                <%@include file="editModalFragment.jsp" %>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-6">
                        <h2>Add Item</h2>
                        <form class="form-horizontal" role="form" name="myForm">
                            <div class="form-group">
                                <label for="add-name" class="col-md-4 control-label">Name:</label>
                                <div class="col-md-8">
                                    <input id="add-name" name="itemName" ng-model="itemName" required maxlength="15" minlength="5" type="text" class="form-control" placeholder="Name"/>
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
                                <label for="add-image-url" class="col-md-4 control-label">Image:</label>
                                <div class="col-md-8">
                                    <input id="add-image-url" name="itemImage" ng-model="itemImage" min="5" type="text" class="form-control" placeholder="url"/>
                                    <div ng-if="myForm.itemImage.$touched" ng-messages="myForm.itemImage.$error" role="alert">
                                        <div class="alert alert-danger" ng-message="required">Please enter a value for this field.</div>
                                        <div class="alert alert-danger" ng-message="min">Please enter at least 5 characters.</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <!--<label for="add-image-height" class="col-md-4 control-label">Image height:</label>-->
                                <div class="col-md-4"></div>
                                <div class="col-md-4">
                                    Img height: <input id="add-image-height" name="imageHeight" ng-model="imageHeight" required max="1000" min="20" type="number" class="form-control" placeholder="0"/>
                                    <div ng-if="myForm.imageHeight.$touched" ng-messages="myForm.imageHeight.$error" role="alert">
                                        <div class="alert alert-danger" ng-message="required">Please enter a value for this field.</div>
                                        <div class="alert alert-danger" ng-message="min">Please enter at least 20.</div>
                                        <div class="alert alert-danger" ng-message="max">Items must be less than 1000.</div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    Img width: <input id="add-image-width" name="imageWidth" ng-model="imageWidth" required max="700" min="20" type="number" class="form-control" placeholder="0"/>
                                    <div ng-if="myForm.imageWidth.$touched" ng-messages="myForm.imageWidth.$error" role="alert">
                                        <div class="alert alert-danger" ng-message="required">Please enter a value for this field.</div>
                                        <div class="alert alert-danger" ng-message="min">Please enter at least 20.</div>
                                        <div class="alert alert-danger" ng-message="max">Items must be less than 700.</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-6 col-sm-4">
                                    <button type="submit" id="add-button" class="btn btn-primary" ng-click="addItem()">Add Item</button>
                                </div>
                            </div>
                            
                        </form>
                        <div id="validationErrors" class="alert alert-danger" style="display:none"></div>
                    </div>
                </div>
            </div>
        </div>
                    
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vending.js"></script>
        <script src="${pageContext.request.contextPath}/js/adminJS.js"></script>
    </center>
</body>
</html>

