<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Test Hexagon</title>
<link href="resources/style.css" rel="stylesheet" />
<script src="resources/phaser.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<script type="text/javascript">
$( document ).ready(function() { 
	
	var isControlVisible = false;
    
	$.ajax({
        type: "GET", 
        url: '<c:url value="/getMap?posX=0&posY=0"/>',
        cache:false,
        dataType :'json',
        success: function(data){
             console.log(data);    
             console.log("loading complete");
             refreshMap(data);     
       }
    }); 
	
    $('#divToScroll').draggable({ 
    	cursor: "move",  
    	stop: function() { 
    		viewCoordinates = getViewCoordinates(parseInt($(this).css('left'))*-1, parseInt($(this).css('top'))*-1, 800,600);
    		console.log("position: " + parseInt($(this).css('left'))*-1 + "/" + parseInt($(this).css('top'))*-1);  
        	console.log("now viewing: " + viewCoordinates);
        	
        	$.ajax({
                type: "GET",
                url: '<c:url value="/getMap?posX=' + viewCoordinates[0] + '&posY=' + viewCoordinates[1] + '"/>',
                cache:false,
                dataType :'json',
                success: function(data){
                     console.log(data);    
                     console.log("loading complete");
                     refreshMap(data);    
               }
            });
        	 
    	} 
	})
	
	function refreshMap(data){
    	$('#divToScroll').html("");
        for(k in data){
       	 //console.log("k " + mapArray[k]['type']);

	       	 if(data[k]['type'] == '1'){
	       	 	s = "<div id=\"tile_" + data[k]['posX'] + "_" + data[k]['posY'] + "\" class=\"tile\" style=\"position: absolute; top: " + data[k]['posY'] * 61 + "px; left: " + data[k]['posX'] * 61 + "px;\">" + data[k]['posX'] + "/" + data[k]['posY'] + "</div>";
	       	 }else{
	       	    s = "<div id=\"tile_" + data[k]['posX'] + "_" + data[k]['posY'] + "\" class=\"tile\" style=\"position: absolute; top: " + data[k]['posY'] * 61 + "px; left: " + data[k]['posX'] * 61 + "px; background: red;\">" + data[k]['posX'] + "/" + data[k]['posY'] + "</div>";
	       	 }
	       	 $('#divToScroll').append(s);
	       	 $("#tile_" +  data[k]['posX'] + "_" +  data[k]['posY']).data('tile', data[k]);
		     $("#tile_" +  data[k]['posX'] + "_" +  data[k]['posY']).dblclick(function(){
		        	console.log("clicked on " + $(this).data("tile")["posX"] + "/" + $(this).data("tile")["posY"]); 
		        	$("#controlPanel").toggle();
		     });
        } 
    }
    
    function toggleControl(){
    	console.log("toggle control" + isControlVisible);
    	if(!isControlVisible){
    		$("#controlPanel").css("display: block;");
    	}else{
    		$("#controlPanel").css("display: none;");
    	}
    	
    	isControlVisible = !isControlVisible;
    }
	
});  


function getViewCoordinates(posX,posY,sizeX,sizeY){ 
	var topLeft,topRight,bottomLeft,bottomRight;
	
	var tileSizeX = 60; 
	var tileSizeY = 60;
	
	topLeftX = Math.floor(posX / tileSizeX);
	topLeftY = Math.floor(posY / tileSizeY);
	
	return [topLeftX,topLeftY];
}
</script>  
	<c:if test="${!empty message}">
		<div id="messageContainerSuccess"> 
		${ message }   
		</div>
	</c:if> 
	<div id="map" style="width: 100%; height: 100vh; position: absolute; top: 0; left: 0; overflow: hidden;"> 
		<div id="divToScroll">  </div>
	</div>
	
	<div id="controlPanel" style="width: 400px; position: absolute; top: 0; right: 0; background: #333; height: 100vh; color: #fff; display: none;"><a href="javascript:$('#controlPanel').toggle();">Close</a></div>
</body>
</html>