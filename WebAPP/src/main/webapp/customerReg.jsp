<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/customerReg.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="./javascript/customerreg.js"></script>
    </head>
    <body>
        <body>
            <div>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <img src="./img/PGA logo.png"    class="logo">
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-item nav-link active" href="/"><b>Home</b></a>
                            </div>
                        </div>
                </nav>
        </div>
            <div class="container">
              <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto ">
                  <div class="card card-signin flex-row my-5">
                    <div class="card-body cardBorder">
                      <h5 class="card-title text-center"><b>Register</b></h5>
                      <form class="form-signin" >
                        <div class="form-label-group">
                          <input type="text" id="inputUserame" class="form-control" name="name" placeholder="Username" required autofocus>
                          <label for="inputUserame">Username</label>
                        </div>
          
                        <div class="form-label-group">
                          <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required>
                          <label for="inputEmail">Email address</label>
                        </div>
                        
          
                        <div class="form-label-group">
                          <input type="password" id="inputPassword" class="form-control" name = "password" placeholder="Password" required data-toggle="popover" title="Password Strength" data-content="Enter Password...">
                          <label for="inputPassword">Password</label>
                        </div>
                        
                        <div class="form-label-group">
                          <input type="password" id="inputConfirmPassword" class="form-control" name = "password1" placeholder="Password" required>
                          <label for="inputConfirmPassword">Confirm password</label>
                        </div>
                        <div class="form-label-group">
                            <input type="text" id="inputphone" class="form-control" name="phone" placeholder="Phone Number"  required>
                            <label for="inputphone">Phone</label>         
                         </div>
                         
                         <div class="form-label-group">
                          <input type="text" id="inputDriverLicenceId" class="form-control" name="DriverLicenceId" placeholder="DriverLicenceID" required>
                          <label for="inputDriverLicenceId">DriverLicenceID</label>
                        </div>
                        
                        <div class="form-label-group">
                          <input type="text" id="inputConfirmDriverLicenceId" class="form-control" name="DriverLicenceId1" placeholder="inputConfirmDriverLicenceId" required>
                          <label for="inputConfirmDriverLicenceId">Confirm ID</label>
                        </div>
                         
                        <br>
                        <br>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" value="/addCustomer">Register</button>
                        <br>
                        <a class="d-block text-center mt-2 small" href="./customerlogin.html"><b>Sign In</b></a>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </body>
    </body>
</html>