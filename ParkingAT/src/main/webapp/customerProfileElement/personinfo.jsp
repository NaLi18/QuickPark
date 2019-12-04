<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored ="false"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/customerProfile.css">
        <link rel="stylesheet" href="./personinfo.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <style type="text/css">
    .updateprofile{
    max-width: 500px;
    margin: auto;
    background: #f3f3f3;
    padding-left: 30px;
    padding-right: 30px;
    padding-top: 20px;
	}

	.updateprofile button{
    	width: 120px;
    	margin:auto;
    	font-size:14;
    	background-color: green;
	}
	.updateProfile label{
		color:green;
	}
    </style>
    <body>
    
    <form class="updateprofile" action ="../editCustomer" method="post">
        <div class="form-label-group">
                <label for="inputUsername">Name</label>
                <input type="text" id="inputUsername" name="name" class="form-control" value="${customer.name}" required autofocus>
        </div>
        <div class="form-label-group">
                    <label for="inputEmail">Email</label>
                <input type="email" id="inputEmail" name="email" class="form-control" value="${customer.email}" required >
         </div>
        <div class="form-label-group">
            <label for="inputphone">Phone</label>
            <input type="text" id="inputphone" name="phone" class="form-control" value="${customer.phone}" required >
    </div>
    <div class="form-label-group">
            <label for="inputpassward">Passward</label>
            <input type="password" id="inputpassward" name="password" class="form-control" placeholder="passward" required >
    </div>
    <div class="form-label-group">
            <label for="comfirmpassward">Comfirm Passward</label>
            <input type="passward" id="inputcomfirmpassward" name="password1" class="form-control" placeholder="comfirm passward" required>
    </div>
    <div class="form-label-group">
    	<label for="uploadProfile">Profile Update</label><br>
    	Select a file: <input type="file" name="myFile"><br><br>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
	<br>
</form>
   
    </body>
</html>