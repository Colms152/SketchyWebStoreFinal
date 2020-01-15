<%-- 
    Document   : NewUser
    Created on : 29-Dec-2019, 10:36:29
    Author     : Colm
--%>
<%@page import="com.bsapp.model.Product"%>
<%@page import="java.util.Vector"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>SAS | New Account</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/checkout/">

    <!-- Bootstrap core CSS -->
<link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="form-validation.css" rel="stylesheet">
    </head>
    <body>
	 <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  
            <a href="../sketchywebstore" class="navbar-brand d-flex align-items-center">
                  <img src="img/paint-palette-and-brush.svg" width="32.5" height="32.5" style="margin-right: 6px;">
                   The Sketchy Art Shop
                </a>
            
        </nav>
  
  <body class="bg-light">
    <div class="container">
  <div class="py-5 text-center">
    
    <h2>New User</h2>
    </div>
        
  <div class="row" >
     
      <div class="col-md-8 order-md-1">
      <h4 class="mb-3">Enter Your Details Below</h4>
      
      <form class="needs-validation" novalidate="" method="POST" action="AddUserServlet" name="userdetails">
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">First name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required="">
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required="">
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        </div>

        

        <div class="mb-3">
          <label for="email">Email <span class="text-muted"></span></label>
          <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com">
          <div class="invalid-feedback">
            Please enter a valid email address.
          </div>
        </div>
        
        <div class="mb-3">
          <label for="password">Password <span class="text-muted"></span></label>
          <input type="password" class="form-control" id="password" name="password" placeholder="">
          <div class="invalid-feedback">
            Please enter a valid password.
          </div>
        </div>
          
        

        <div class="mb-3">
          <label for="address">EirCode</label>
          <input type="text" class="form-control" id="address" name="ecode" placeholder="T12K8AF" required="">
          <div class="invalid-feedback">
            Please enter your eirCode.
          </div>
        </div>

        
       
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Create New Account</button>
      </form>
    </div>
      
    
  </div>

    
        
  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017-2019 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
        
</div>
      
    
      
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">   
      </script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')
      </script>
      <script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous">
      </script>
      <script src="https://getbootstrap.com/docs/4.4/examples/checkout/form-validation.js">      
      </script>	
    </body>
</html>
