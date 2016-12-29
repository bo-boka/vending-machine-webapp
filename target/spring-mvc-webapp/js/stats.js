/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    drawChart();
});

//===========
//functions
//===========

function drawChart(){
    var data = google.visualization.arrayToDataTable([
        ['Company', '# Contacts'],
        ['Oracle', 10],
        ['Apple', 11],
        ['Microsoft', 6],
        ['SWC Guild', 18]
    ]);
 
    var options = {
        title: 'Item Inventory',
        vAxis: {title: 'Item', titleTextStyle: {color: 'red'}},
        hAxis: {title: 'Num in Stock', titleTextStyle: {color: 'red'}},
        'width': 500,
        'height': 400
    };
 
    var chart = new google.visualization.BarChart(document.getElementById('invChart'));
    
    chart.draw(data, options);
};