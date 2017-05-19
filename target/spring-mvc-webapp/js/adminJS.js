/* 
 *  Copyright 2017 SarahBoka
 */

/*global angular*/
var adApp = angular.module('adminApp', ['ngMessages']);

adApp.controller('adminController', ['$scope', '$log', '$http', '$sce', function($scope, $log, $http, $sce){
    
    loadItems();
    
    function loadItems(){
        $http.get('items')
                .then(function(response) {
                    $scope.items = response.data;
                    $log.log($scope.items);
                });
    }
    
    $scope.viewEditModal = function(id){
        $http.get('item/' + id)
                .then(function(response){
                    $scope.item = response.data;
                    $log.log($scope.item);
                    
                    $("#edit-item-id").text($scope.item.id);
                    $("#edit-item-name").val($scope.item.name);
                    $("#edit-item-cost").val($scope.item.cost);
                    $("#edit-item-inv").val($scope.item.inventory);
                    
                });
    };
 
    $scope.deleteItem = function(id){
        $http.delete('item/' + id)
                .then(function(){
                    loadItems();
        });
    };
    
    $scope.addItem = function() {
        var imageString = '<img src="' + $scope.itemImage + '" height="' + $scope.imageHeight + '" width="' + $scope.imageWidth + '"/>';
        $http.post('item', {name: $scope.itemName, cost: $scope.itemCost, inventory: $scope.itemInventory, image: imageString})
                .then(function(response){
                    loadItems();
                    $scope.itemName = null;
                    $scope.itemCost = null;
                    $scope.itemInventory = null;
                    $scope.itemImage = null;
                    $scope.imageHeight = null;
                    $scope.imageWidth = null;
                    $scope.myForm.$setUntouched();
        });
    };
    
}]);

   
    // angular doesn't work within modal so edit button goes through reg js
//    $scope.editItem = function(){
//        $http.put('item/'+ $scope.item.id, {name : $scope.item.name, cost : $scope.item.cost, inventory : $scope.item.inventory, image: $scope.item.image});
//        $log.log($scope.item);
//    };
    
$(document).ready(function(){
    
//    loadItems();
    
//    $("#add-button").click(function(event){
//        event.preventDefault();
//        addItem();
//    });
    
//    $("#item-edit-modal").on('show.bs.modal', function(event){
//        var element = $(event.relatedTarget);
//        var itemId = element.data('item-id');
//        itemEditDetails(itemId);
//    });
//    
    $("#edit-button").click(function(event){
        event.preventDefault();
        editItem();
    });
    
});

//function loadItems(){
//    
//    $.ajax({
//        url : 'items',
//        type : 'GET'
//    }).success(function(data){
//        processItemList(data);
//    });
//}
//
//function clearTable(){
//    $('#itemListRows').empty();
//    
//}
//
//function processItemList(items){
//    
//    clearTable(); 
//
//    var itemListRows = $('#itemListRows');
//
//    $.each(items, function(index, item){
//        
//        var nameField = $("<td>");
//        var costField = $("<td>");
//        var invField = $("<td>");
//        var editField = $("<td>");
//        var deleteField = $("<td>");
//        
//        nameField.text(item.name);
//        costField.text(item.cost);
//        invField.text(item.inventory);
//        
//        var editLink = $("<a>");
//        editLink.attr({
//            'data-toggle': 'modal',
//            'data-target': '#item-edit-modal',
//            'data-item-id' : item.id
//        });
//        editLink.text("Edit");
//        editField.append(editLink);
//        
//        var deleteLink = $("<a>");
//        deleteLink.attr({
//            'onclick': 'deleteItem('+item.id+')'
//        });
//        deleteLink.text("Delete");
//        deleteField.append(deleteLink);
//        
//        var itemListRow = $("<tr>");
//        itemListRow.append(nameField);
//        itemListRow.append(costField);
//        itemListRow.append(invField);
//        itemListRow.append(editField);
//        itemListRow.append(deleteField);
//        
//        itemListRows.append(itemListRow);
//        
//    });
//}
//
//function itemEditDetails(id){
//    $.ajax({
//        type: 'GET',
//        url: 'item/' + id,
//        headers: {
//            'Accept': 'application/json'
//        }
//    }).success(function(item){
//        $("#edit-item-id").text(item.id);
//        $("#edit-item-name").val(item.name);
//        $("#edit-item-cost").val(item.cost);
//        $("#edit-item-inv").val(item.inventory);
//    });
//}

function editItem(){
    var id = $("#edit-item-id").text();
    var itemName = $("#edit-item-name").val();
    var itemCost = $("#edit-item-cost").val();
    var itemInv = $("#edit-item-inv").val();
    
    $.ajax({
        url: 'item/'+ id,
        type: 'PUT',
        headers: {
            'Content-type' : 'application/json'
        },
        'dataType' : 'json',
        data : JSON.stringify({
            name : itemName,
            cost : itemCost,
            inventory : itemInv
        })
    }).success(function(data){
        location.reload();
    });
}

function addItem(){
    var itemName = $("#add-name").val();
    var itemCost = $("#add-cost").val();
    var itemInv = $("#add-inventory").val();
    
    $.ajax({
        url : 'item',
        type : 'POST',
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        'data-Type' : 'json',
        data : JSON.stringify({
            name : itemName,
            cost : itemCost,
            inventory : itemInv
        })
    }).success(function(data){
        location.reload();
        
        $("#validationErrors").hide();

        $("#add-name").val('');
        $("#add-cost").val('');
        $("#add-inventory").val('');
    }).error(function(data,status){
        var errorDiv = $("#validationErrors");
        errorDiv.empty();
        errorDiv.show();
        
        $.each(data.responseJSON.fieldErrors, function(index, validationError){
            errorDiv.append(validationError.message);
            errorDiv.append("<br>");
        });
    });
}

//function deleteItem(id){
//    var answer = confirm("Do you really want to delete this item?");
// 
//    if (answer === true) {
//        $.ajax({
//            type : 'DELETE',
//            url : 'item/' + id
//        }).success(function(){
//            loadItems();
//        });
//    }
//}