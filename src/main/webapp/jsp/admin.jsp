<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <%@include file="headerFragment.jsp" %>
            <div class="container">
                <div class="row">
                    <!--  display table-->
                    <div class="col-md-6">
                        <h2>Item List</h2>
                        <%@include file="itemListTableFragment.jsp" %>
                    </div>
                    <div class="col-md-6">
                        <h2>Add Item</h2>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="add-name" class="col-md-4 control-label">Name:</label>
                                <div class="col-md-8">
                                    <input id="add-name" name="itemName" type="text" class="form-control" placeholder="Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-cost" class="col-md-4 control-label">Cost:</label>
                                <div class="col-md-8">
                                    <input id="add-cost" name="itemCost" type="number" class="form-control" placeholder="0.00"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-inventory" class="col-md-4 control-label">Inventory Amount:</label>
                                <div class="col-md-8">
                                    <input id="add-inventory" name="itemInventory" type="number" class="form-control" placeholder="0"/>
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

