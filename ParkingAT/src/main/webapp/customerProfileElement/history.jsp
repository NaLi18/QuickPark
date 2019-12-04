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
<link rel="stylesheet" href="/history.css">
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
    	text-align:center;
    	margin:auto
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
		    width: 100%;
		    background: #f3f3f3;
		}
		
		button{
		    float: right;
		    margin-right: 0%;
		    background-color: coral;
		    width: 150px;
		    height:40px;
		    border-radius: 5px;
		    border: 1px;
		    margin-right: 20px;
		}
	</style>
</head>

<body>
	<div class="Reservations">
	<c:if test="${not empty historys}">
		<table class="Ordertable">
			<tbody>
				<tr>
					<th>Reservation ID</th>
					<th>Garage Name</th>
					<th>Check In</th>
					<th>Check Out</th>
					<th>Unit Price</th>
					<th>Spot</th>
					<th>Paid</th>
					
				</tr>
				<c:forEach items="${historys}" var="res">
					<tr>
						<td><c:out value="${res.reservationID}"></c:out></td>
						<td><c:out value="${res.garageID}"></c:out></td>
						<td><c:out value="${res.checkInDate} ${res.checkInTime}"></c:out></td>
						<td><c:out value="${res.checkOutDate} ${res.checkOutTime}"></c:out></td>
						<td><c:out value="$${res.price}"></c:out></td>
						<td><c:out value="${res.spots}"></c:out></td>
						<td><c:out value="${res.paid}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
    <br>
	    <button>Clear History</button>
	</div>
</body>
</html>