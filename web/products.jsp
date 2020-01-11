<%-- 
    Document   : products
    Created on : Nov 16, 2019, 3:56:01 PM
    Author     : Colm Sheehan
--%>

<%@page import="com.bsapp.model.Product"%>
<%@page import="com.bsapp.model.User"%>
<%@page import="java.util.Vector"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Products | Sketchy Art Shop</title>
<script type="text/javascript" src="javascriptsws.js"></script>
 
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/album/">

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
      
                .box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 25rem;
  padding: 2.5rem;
  box-sizing: border-box;
  background: rgba(0, 0, 0, 0.9);
  border-radius: 0.625rem;
}
.box h2 {
  margin: 0 0 1.875rem;
  padding: 0;
  color: #fff;
  text-align: center;
}
.box .inputBox {
  position: relative;
}
.box .inputBox input {
  width: 100%;
  padding: 0.625rem 0;
  font-size: 1rem;
  color: #fff;
  letter-spacing: 0.062rem;
  margin-bottom: 1.875rem;
  border: none;
  border-bottom: 0.065rem solid #fff;
  outline: none;
  background: transparent;
}
.box .inputBox label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 0.625rem 0;
  font-size: 1rem;
  color: #fff;
  pointer-events: none;
  transition: 0.5s;
}
.box .inputBox input:focus ~ label,
.box .inputBox input:valid ~ label,
.box .inputBox input:not([value=""]) ~ label {
  top: -1.125rem;
  left: 0;
  color: #03a9f4;
  font-size: 0.75rem;
}
.box input[type="submit"] {
  border: none;
  outline: none;
  color: #fff;
  background-color: #03a9f4;
  padding: 0.625rem 1.25rem;
  cursor: pointer;
  border-radius: 0.312rem;
  font-size: 1rem;
}
.box input[type="submit"]:hover {
  background-color: #1cb1f5;
}

.dropdown {
  position: relative;
  display: inline-block;
}
.dropdown-content {
  display: none;
  position: relative;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  
  z-index: 1;
}
.dropdown-content {
  display: block;
}
 
    </style>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.3/examples/album/album.css" rel="stylesheet">
    
  </head>
  <c:set var = "salary" scope = "session" value = "${2000*2}"/> 
  <body onload="init();">
    
   <header>
        
        <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  
            <a href="../sketchywebstore" class="navbar-brand d-flex align-items-center">
                  <img src="img/paint-palette-and-brush.svg" width="32.5" height="32.5" style="margin-right: 6px;">
                   The Sketchy Art Shop
                </a>
            <div>         
            <form name="autofillform" action="searchresultsservlet" method="GET"><input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search" size="40" name="search" id="complete-field" onkeyup="doCompletion()"></form>
            <div class="dropdown-content" style="" id="complete-table">
                        <table  class="popupBox" > </table>
                      </div>
            </div> 
            <ul class="navbar-nav px-3">
              <li class="nav-item text-nowrap" stlye="float: left;">
                <c:choose>
                      <c:when test="${status}">
                          <a href="${pageContext.request.contextPath }/LogOutServlet?&action=LogOut&id=${SKUSER}" class="text-white"><li><img src="img/door-exit.svg" width="18" height="18" >Sign Out</li></a
                      </c:when>    
                      <c:otherwise>
                          <a href="#" class="text-white" onclick="document.getElementById('id01').style.display='block'"><li><img src="img/door-exit.svg" width="18" height="18" >Sign In</li></a>
                          </c:otherwise>
                      </c:choose>
              </li>
              <li stlye="float: left;"><a href="../${pageContext.request.contextPath }/CartServlet" class="text-white"><img src="img/shopping-cart.svg" width="18" height="18" >Cart</a></li>

            </ul>
        </nav>
        
    </header>

<main role="main" style="text-align: center;">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">Products</h1>
      <p class="lead text-muted"></p>
      
    </div>
  </section>

  <div class="album py-5 bg-light">
    <div class="container">

      <div class="row">
        
          
          <c:forEach items="${RKALLPRODUCTS}" var="tempproduct"> 
              <!-- Product <c:out value="${tempproduct.getId()}"/> -->
              <div class="col-md-4">
          <div class="card mb-4 shadow-sm">
            <img src="ProdImg/<c:out value="${tempproduct.getId()}"/>.jpg" width="100%" height="100%"  >
            
            <div class="card-body">
              <h5>&euro; <c:out value="${tempproduct.getCODE()}"/> </h5>
              <p class="card-text"><c:out value="${tempproduct.getProdDescription()}"/> 

              </p>
             <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <c:choose>
    <c:when test="${status}">
        <a type="button" class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath }/CartServlet?&action=buy&id=${tempproduct.getId()}">Buy</a>
    </c:when>    
    <c:otherwise>
        <button type="button" class="btn btn-sm btn-outline-secondary" onclick="document.getElementById('id01').style.display='block'">LogIn</button>
    </c:otherwise>
</c:choose>
        </div>
              </div>
            </div>
          </div>
        </div>
          </c:forEach>
        
      </div>
        
    </div>
      
  </div>
 
</main>

<footer class="text-muted">
  <div class="container">
    <p class="float-right">
      <a href="#">Back to top</a>
    </p>
    </div>
</footer>
      
        <!-- LogIN Windows -->
    <div id="id01" class="modal">
    <div class="box">
      <h2>Please Login to add items to your cart</h2>
      <form action="LoginServlet" method="POST">
        <div class="inputBox">
          <input type="email" name="email" required onkeyup="this.setAttribute('value', this.value);" value="">
          <label>Username</label>
        </div>
        <div class="inputBox">
            <input type="password" name="password" required value=""
             >
        <label>Password</label>
        
        </div>
          <center>
              <button type="submit" class="btn btn-success" name="sign-in" value="Sign In" style="margin: 10px;">Sign In</button>  <br>  
        <a href="NewUser.jsp" class="btn btn-primary">Create New account</a>
        </center>
      </form>
    </div>
    </div>
    
        
        
    <script>
      // Get the modal
      var modal = document.getElementById('id01');
      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
      }
      
     
    </script>
    <!-- End Modal Login -->
      
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
          
      </script>
<script>
    window.jQuery || document.write('<script src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js"><\/script>');
</script>
<script src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous">    
</script>


  </body>

</html>
