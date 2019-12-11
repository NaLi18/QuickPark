<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Reservation"%>
<%@ page isELIgnored ="false" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="../css/customerProfile.css">
<link rel="stylesheet" href="./reservation.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Reservation Page</title>
<style type="text/css">
		.Ordertable, th,td{
   			border: 1px solid white;
    		border-collapse: collapse;
    		border-radius: 5px;
    		margin:auto;
    		text-align:center;
		}
		td{
    		background-color: rgba(64, 241, 158, 0.219);

		}
		th{
    		background-color: rgba(64, 241, 158, 0.514);
    		height: 45px;
		}
		.Ordertable{
    		margin: auto;
    		width: 100%;;
    		background: #f3f3f3;
		}
		button{
    		float: right;
    		margin-right: 0%;
    		background-color: aquamarine;
    		width: 150px;
    		height:40px;
    		border-radius: 5px;
    		border: 1px;
    		margin-right: 60px;
		}
		button:first-of-type{
   			background-color: coral;
		}
	</style>
</head>

<body>
	<div class="Reservations" id="someReservations">
	<c:if test="${not empty reservations}">
		<table class="Ordertable">
			<tbody>
				<tr>
					<th>Select</th>
					<th>Reservation ID</th>
					<th>Garage Name</th>
					<th>Arrive Time</th>
					<th>Leave Time</th>
					<th>Unit Price</th>
					<th>Spot</th>
					<th>Paid</th>
					<th>Cancel</th>
				</tr>
				<c:forEach items="${reservations}" var="res">
					<tr>
						<td><input  class="messageCheckbox" type="checkbox" name="garg" value="${res.reservationID}"></td>
						<td><c:out value="${res.reservationID}"></c:out></td>
						<td><c:out value="${res.garageID}"></c:out></td>
						<td><c:out value="${res.checkInDate} ${res.checkInTime}"></c:out></td>
						<td><c:out value="${res.checkOutDate} ${res.checkOutTime}"></c:out></td>
						<td><c:out value="$${res.price}"></c:out></td>
						<td><c:out value="${res.spots}"></c:out></td>
						<td><c:out value="${res.paid}"></c:out></td>
						<td><a href="cancelReservation?id=${res.reservationID}" style="color:blue;">cancel</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
    <br>
        <a href="./homepage.jsp" target="_top" style="color:black;float: right;background-color: aquamarine;width: 150px;height:30px;border-radius: 5px;border: 1px;margin-right: 40px; text-align: center;text-decoration: none; padding:0">New Reservation</a>
    <br>
    <br>
         <a href="#"  Onclick="openForm()" style="color:white; float: right;background-color: coral;width: 150px;height:30px;border-radius: 5px;border: 1px;margin-right: 40px; text-align: center;text-decoration: none; padding:0">Edit Reservation</a>
    <br>
	</div>
	 <div class="form-popup" id="myForm" style="display: none; padding:25px; border-radius: 10px; padding-top:0px; width:80%; margin:auto; background-color:E3DFDF;">
 			<form action="updateReservation" class="form-container" method="post" style="padding:10px; ">
 				<label>Reservation ID: </label>
    			<input id="ID" name="reservationID" value=""/><br>
    			<label for="SartDate">From:</label>
         		<input type="date" onchange="checkDate()" id="start" name="parking-start" />
         		<input id="setStartime" type="time" name="startTime"style="margin-right:10px"/><br>
         		<label for="endDate">To:</label>
         		<input type="date" id="end" onchange="datevalid()" name="parking-end" />
         		<input id="setEndtime" type="time" style="margin-right:10px" name="endtime"/><br>
    			<br>
    			<button type="submit" class="btn">update</button>
    			<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  			</form>	 
		</div>
	<script>
			function openForm() {
		  		document.getElementById("myForm").style.display = "block";
		  		document.getElementById("someReservations").style.display = "none";
		  		
		  		var checkedValue = null; 
				var inputElements = document.getElementsByClassName('messageCheckbox');
				for(var i=0; inputElements[i]; ++i){
				      if(inputElements[i].checked){
				           checkedValue = inputElements[i].value;
				           break;
				      }
				}
				document.getElementById("ID").value=checkedValue;
				//document.getElementById("cus").value=cus.getName();
			}

			function closeForm() {
  				document.getElementById("myForm").style.display = "none";
  				document.getElementById("someReservations").style.display = "block";
			}
			function checkDate() {
		    	   var selectedText = document.getElementById('start').value;
		    	   var selectedDate = new Date(selectedText);
		    	   var now = new Date();
		    	   if(selectedDate.getFullYear() >= now.getFullYear() || selectedDate.getMonth() >= now.getMonth()){
		    		   if((selectedDate.getDate()+1) < now.getDate()){
		    	    		alert("Date must be in the future");
		    	    		location.reload();
		    	    		}
		    	   }
		    	 }
		    	function datevalid() {
		     	   var selectedText1 = document.getElementById('end').value;
		     	   var selectedDate1 = new Date(selectedText1);
		     	   var now = new Date();
		     	  	if(selectedDate1.getFullYear() >= now.getFullYear() || selectedDate1.getMonth() >= now.getMonth()){
		     		  if((selectedDate1.getDate()+1) < now.getDate()){
		   	    			alert("Date must be in the future");
		   	    			location.reload();
		   	    		}
		     	   	else if(new Date(document.getElementById('start').value)!=null){
		     		  	var selectedText = document.getElementById('start').value;
		       	   		var selectedDate = new Date(selectedText);
		       	   		if(selectedDate > selectedDate1){
		       	   			alert("Check out date need After the check in");
		     	    		location.reload();
		       	   			}
		     	   		}
		     	  	}
		     	 }
	</script>
	
</body>
</html>