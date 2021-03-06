<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Customer"%>
<%@ page isELIgnored ="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/customerProfile.css" type="text/css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
    
    <div class="outline">
  		<img src="./img/PGA logo.png" class="logo"  style="margin-left:45px">
  		<a href="homepage.jsp" style="float:right;border-radius: 5px; padding:5px; width:100px;background-color: #3F88C5; color:#ffffff; margin-right:60px; text-align:center">Home</a>
		<a href="customerLogin" style= "float:right;border-radius: 5px; padding:5px; width:100px;background-color: #3F88C5;color:#ffffff;margin-right:20px; text-align:center">Log out</a>
    <div class="row ">
        <div class="col-lg">
            <img src="./img/cover.png"class="cover" width=95% height=180px >
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-sm-3 col-xs-12">
                <div class="row ">
                    <div class="col-md-10 col-md-10-sm-10 col-xs-10 ">
                        <img src="./img/DefaultProfile.jpg" class="rounded-circle profilepic" width=30% height=180px>
                    </div>
                </div>
        </div>
        <div class="col-sm col-xs ">
                <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">Name:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.name}</p>
                        </div>
	            </div>
	            <div class="row">
                        <div class="col-md-2 ">
                            <label class="text-primary">Account ID:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.driverLicenceId}</p>
                        </div>
                </div>
                <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">Email:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.email}</p>
                        </div>
                </div>
                <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">Phone:</label>
                        </div>
                        <div class="col-md-5">
                            <p>${customer.phone}</p>
                        </div>
        	    </div>
        </div>
    </div> 
	<div class="row">
    	<div class="center" style="margin-left:25px;">
			<aside class="menu">
            	<li ><a href= "./customerProfileElement/personinfo.jsp" target="main">Personal Information</a></li>
	        	<li ><a href="getReservationInfo" target="main">Reservation</a></li>
            	<li ><a href= "./customerProfileElement/message.html" target="main">Message</a></li>
            	<li ><a href= "getHistory" target="main">History</a></li>
    	    	<li ><a href= "./customerProfileElement/payment.html" target="main">Payment</a></li>
	        	<li ><a href= "./customerProfileElement/privacy.html" target="main">Privacy Center</a></li>
   			 </aside>
   	 </div>
    <div class="col-main">
        <div class="main-wrap" style=" margin-left:60px">
            <iframe id="external-frame" scrolling="no" onload="setIframeHeight(this)" name="main" width=800px scrolling="auto" height=700px src="" frameborder="0"></iframe>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    function setIframeHeight(iframe) {
        if(iframe) {
            var iframeWin = iframe.contentWindow ;
            if(iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
    };

    window.onload = function() {
        setIframeHeight(document.getElementById('external-frame'));
    };
</script>
</body>
</html>