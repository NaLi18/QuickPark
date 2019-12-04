<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Garage"%>
<%@ page isELIgnored ="false" %> 
<link rel="stylesheet" type="text/css" href="garageProfile.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/garageProfile.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <img src="./img/PGA logo.png"    class="logo">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/"><b>Home</b></a>
      <a class="nav-item nav-link active" href="garageLogin"><b>SignOut</b></a>
    </div>
  </div>
</nav>
<div class="container margin">
    <div class="row ">
        <div class="col-lg">
            <img src="./img/garagee.png"class="cover">
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-sm-3 col-xs-12">
                <div class="row ">
                    <div class="col-md-12 col-md-12-sm-12 col-xs-12 ">
                        <img src="https://www.jamf.com/jamf-nation/img/default-avatars/generic-user-purple.png" class="rounded-circle profilepic">
                    </div>
                    <button type="button" class="btn btn-success btn-position">Edit Profile</button>
                </div>
        </div>
        <div class="col-sm col-xs ">
                <h2>${GarageO.name }</h2>
                <h5 class="text-success" >Garage Owner</h5>
        </div>
    </div>
    <div class="row">
        <div class="col profile-panel">
            <ul class="nav nav-tabs" role="tablist" >
                <li class="active nav-item"><a class="nav-link" href="#profile">Profile</a></li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade show active" id="profile">
                    <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">EMAIL</label>
                        </div>
                        <div class="col-md-6">
                            <p>${GarageO.email}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <label class="text-primary">PHONE</label>
                        </div>
                        <div class="col-md-6">
                            <p>${GarageO.phone}</p>
                        </div>
                    </div>
                        </div>      
                </div>
            </div>
            <div class="row">
                <div class="center">
                    <aside class="menu">
                        <li ><a href= "./info.jsp" target="main">Garage Information</a></li>
                        <li ><a href="./reservation.jsp" target="main">Reservation</a></li>
                        <li ><a href= "./message.jsp" target="main">Message</a></li>
                        <li ><a href= "./payment.jsp" target="main">Payment</a></li>
                    </aside>
                </div>
                    <div class="col-main">
                            <div class="main-wrap">
                                <iframe id="external-frame" scrolling="no" onload="setIframeHeight(this)" name="main" width=800px scrolling="auto" height=1000px frameborder="0"></iframe>
                            </div>
                        </div>
                    </div>
            </div>
            <script type="text/javascript">
                function setIframeHeight(iframe) {
                    if(iframe) {
                        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
                        if(iframeWin.document.body) {
                            iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
                        }
                    }
                };
            
                window.onload = function() {
                    setIframeHeight(document.getElementById('external-frame'));
                };
            </script>
        </div>
    </div>
</body>
</html>