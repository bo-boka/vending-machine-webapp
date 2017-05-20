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
                    var imgStr = $scope.item.image;
                    $log.log(imgStr);
                    var len = imgStr.length;
                    var quotes = 0;
                    var src = "";
                    var height = "";
                    var width = "";
                    for (var i = 0; i < len; i++){
                        if (imgStr.charAt(i)==='"'){
                            quotes += 1;
                        }else if (quotes === 1){
                            src += imgStr.charAt(i);
                        }else if (quotes === 3){
                            height += imgStr.charAt(i);
                        }else if (quotes === 5){
                            width += imgStr.charAt(i);
                        }
                    }
                    $log.log(src);
                    $log.log(height);
                    $log.log(width);
                    $("#edit-item-img").val(src);
                    $("#img-edit-height").val(height);
                    $("#img-edit-width").val(width);
                    
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

    $("#edit-button").click(function(event){
        event.preventDefault();
        editItem();
    });
    
});

function editItem(){
    var id = $("#edit-item-id").text();
    var itemName = $("#edit-item-name").val();
    var itemCost = $("#edit-item-cost").val();
    var itemInv = $("#edit-item-inv").val();
    var itemImg = $("#edit-item-img").val();
    var imageHeight = $("#img-edit-height").val();
    var imageWidth = $("#img-edit-width").val();
    
    var imageString = '<img src="' + itemImg + '" height="' + imageHeight + '" width="' + imageWidth + '"/>';
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
            inventory : itemInv,
            image: imageString
        })
    }).success(function(data){
        location.reload();
    });
}
