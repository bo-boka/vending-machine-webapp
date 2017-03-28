
$(document).ready(function(){
    
    loadItems();
    
    $("#add-button").click(function(event){
        event.preventDefault();
        addItem();
    });
    
    $("#item-edit-modal").on('show.bs.modal', function(event){
        var element = $(event.relatedTarget);
        var itemId = element.data('item-id');
        itemEditDetails(itemId);
    });
    
    $("#edit-button").click(function(event){
        event.preventDefault();
        editItem();
    });
    
});

function loadItems(){
    
    $.ajax({
        url : 'items',
        type : 'GET'
    }).success(function(data){
        processItemMachine(data);
        processItemList(data);
    });
}

function processItemMachine(items){
    
//    clearTable(); 
    $('#itemRows').empty();

    var itemRows = $('#itemRows');
    var itemRow = $("<tr>");
    $.each(items, function(index, item){
        
        var nameField = $("<td>");
        
        var nameButton = $("<button>");
        
        nameButton.attr({
            'onclick' : 'purchaseItem(' +item.id+'); return false;' 
        });
        nameButton.text(item.name + ' ' + '$' + item.cost); 
        nameField.append(nameButton);
        
        if (index % 4 === 0){ //creates rows of 4 items
            itemRow = $("<tr>");
        }
        
        itemRow.append(nameField);
        
        itemRows.append(itemRow);
        
    });
}

function clearTable(){
    $('#itemListRows').empty();
    
}

function processItemList(items){
    
    clearTable(); 

    var itemListRows = $('#itemListRows');

    $.each(items, function(index, item){
        
        var nameField = $("<td>");
        var costField = $("<td>");
        var invField = $("<td>");
        var editField = $("<td>");
        var deleteField = $("<td>");
        
        nameField.text(item.name);
        costField.text(item.cost);
        invField.text(item.inventory);
        
        var editLink = $("<a>");
        editLink.attr({
            'data-toggle': 'modal',
            'data-target': '#item-edit-modal',
            'data-item-id' : item.id
        });
        editLink.text("Edit");
        editField.append(editLink);
        
        var deleteLink = $("<a>");
        deleteLink.attr({
            'onclick': 'deleteItem('+item.id+')'
        });
        deleteLink.text("Delete");
        deleteField.append(deleteLink);
        
        var itemListRow = $("<tr>");
        itemListRow.append(nameField);
        itemListRow.append(costField);
        itemListRow.append(invField);
        itemListRow.append(editField);
        itemListRow.append(deleteField);
        
        itemListRows.append(itemListRow);
        
    });
}

function itemEditDetails(id){
    $.ajax({
        type: 'GET',
        url: 'item/' + id,
        headers: {
            'Accept': 'application/json'
        }
    }).success(function(item){
        $("#edit-item-id").text(item.id);
        $("#edit-item-name").val(item.name);
        $("#edit-item-cost").val(item.cost);
        $("#edit-item-inv").val(item.inventory);
    });
}

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
        loadItems();
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
        loadItems();
        
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

function deleteItem(id){
    var answer = confirm("Do you really want to delete this item?");
 
    if (answer === true) {
        $.ajax({
            type : 'DELETE',
            url : 'item/' + id
        }).success(function(){
            loadItems();
        });
    }
}

function purchaseItem(id){
    
    $.ajax({
        type: 'GET',
        url : 'item/' + id,
        headers: {
            'Accept': 'application/json'
        }
    }).success(function(item){
        
        var itemName = item.name;
        
        var itemCost = item.cost;
        var amount = $("#amount").val();
        var sum = amount - itemCost;
        document.getElementById("changeBack").innerHTML = sum.toFixed(2);
        
        var itemInv = item.inventory - 1;
        
        $.ajax({
            type: 'PUT',
            url: 'item/' + id,
            headers: {
                'Content-type': 'application/json'
            },
            'dataType' : 'json',
            data : JSON.stringify({
                name : itemName,
                cost : itemCost,
                inventory : itemInv
            })
        }).success(function(item){
            loadItems();
            $("#amount").val('');
        });
    
    });
        
}


