<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  isELIgnored ="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.parking.entity.Administer"%>
<%@ page import="com.parking.entity.GarageOwner"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/adminProfile.css" type="text/css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <img src="./img/PGA logo.png" class="logo">
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="./homepage.jsp"><b>Home</b></a>
                <a type="button" href="administerLogin" class="btn btn-danger signout ">Signout</a>
            </div>
        </div>
        
    </nav>
    <div class="container margin">
        <div class="row ">
            <div class="col-lg">
                <img src="./img/cover.png" class="cover">
            </div> 
        </div>
        <div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-3">
                        <div class="profile-img">
                            <img src="https://www.jamf.com/jamf-nation/img/default-avatars/generic-user-purple.png"
                                class="rounded-circle profilepic" />
                        </div>
                        
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                            <br>
                            <h2>
                                ${administer.adminName}
                            </h2>
                            <h5 class="text-success">
                                Administrator
                            </h5>
                            <br>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                                        aria-controls="home" aria-selected="true">Profile</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab"
                                        aria-controls="profile" aria-selected="false">Timeline</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-md-9 ">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active " id="home" role="tabpanel"
                                aria-labelledby="home-tab">
                                <div class="profile-panel">
                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label class="text-primary">Name</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>${administer.adminName}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label class="text-primary">Email</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>${administer.adminEmail}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label class="text-primary">Phone</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>${administer.adminPhone}</p>
                                            
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label class="text-primary">Profession</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>Administrator</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                <div class="profile-panel ">
                                    <c:forEach items="${garageOwners}" var="gs">
										<tr >
											
											<td><c:out value="${gs.name}"></c:out></td>
											<td><c:out value="${gs.email}"></c:out></td>
											<td><c:out value="${gs.phone}"></c:out></td>
											<a type="button" class="btn btn-danger" href ="admingaragedelete" >delete</a>
										</tr>
									</c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        </div>
</body>