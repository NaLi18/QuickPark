<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Garage"%>
<%@ page isELIgnored ="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/homepage.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <title>Creating a Garage Locator on Google Maps</title>
	
  </head>
<body>
   	<div class="topMenu">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <img src="./img/PGA logo.png"    class="logo">
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-item nav-link active" href="/"><b>Home</b></a>
                        </div>
                    </div>
                    <%
	Object obj=session.getAttribute("customer");
	if(null==obj){
		%>
                    <div class="dropdown dropdownAlignment">
                            <button class="btn btn-secondary dropdown-toggle" style= "background-color: #3F88C5;color:#ffffff;" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Login / Signup 
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                              <a class="dropdown-item" href="./Admin.html">Admin</a>
                              <a class="dropdown-item" href="./customerlogin.html">Customer</a>
                              <a class="dropdown-item" href="./garagelogin.html">Garage Owner</a>
                            </div>
                          </div>
                  <% 
    }else{
	
		%>
					<a href="customerProfile.jsp" style="border-radius: 5px; padding:5px; background-color: #3F88C5;color:#ffffff; margin-right:10px">My Account</a>
					<a href="customerlogin.html" style= "border-radius: 5px; padding:5px; background-color: #3F88C5;color:#ffffff;">Log out</a>
		
		<% }%>
            </nav>
        </div>
        <form class="Order" action = "addReservation" method="post">
         	<label for="SartDate">From:</label>
         	<input type="date" id="start" name="parking-start" value="Today" required>
         	<input id="setStartime" type="time" step="1" required>
         	<label for="endDate">To:</label>
         	<input type="date" id="end" name="parking-end" value="Today" required>
         	<input id="setEndtime" type="time" step="1" required>
	     	<label for="radiusSelect">Radius:</label>
    	 	<select id="radiusSelect" label="Radius" style="width:100px">
          	<option value="50" selected>50 kms</option>
          	<option value="30">30 kms</option>
          	<option value="20">20 kms</option>
          	<option value="10">10 kms</option>
        	</select>
        <input class="buttonS" type="submit" id="searchButton" style="background-color: #27D154;color:white;margin-right:0%;width: 100px;" value="Search"/>
    	</form>
</body>
</html>