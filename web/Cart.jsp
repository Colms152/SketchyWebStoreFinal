<%-- 
    Document   : Cart
    Created on : 22-Dec-2019, 11:16:48
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
    <meta http-equiv=“CACHE-CONTROL” content=”NO-CACHE”>
    <title>Checkout example · Bootstrap</title>

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
   
  
    <body class="bg-light">
        <header>
            <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  
            <a href="../sketchywebstore" class="navbar-brand d-flex align-items-center">
                  <img src="img/paint-palette-and-brush.svg" width="32.5" height="32.5" style="margin-right: 6px;">
                   The Sketchy Art Shop
                </a>
            
        </nav>
        </header>
    <div class="container">
            
  <div class="py-5 text-center">
    
    <h2>Shopping Cart</h2>
    <p class="lead">Please find Items in your cart below. Click below to finalize your order and continue to our payment partner.</p>
  </div>
        
  <div class="row" >
    <div class="col-md-8 order-md-1">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Your cart</span>
        <span class="badge badge-secondary badge-pill">3</span>
      </h4>
      <ul class="list-group mb-3">
          
          <c:forEach var="item" items="${sessionScope.cart}">
			<c:set var="total" value="${total + item.product.CODE * item.quantity }"></c:set>
                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                <h6 class="my-0">${item.product.getProdName() }</h6>
                                <small class="text-muted">${item.product.getProdDescription()}  <a href="${pageContext.request.contextPath }/CartServlet?action=remove&id=${item.product.id }"
					onclick="return confirm('Are you sure?')">Remove</a></small>
                                </div>
                                <span class="text-muted">
                                    <table>
                                        <tr>
                                            <td> &euro; ${item.product.CODE }</td>
                                <td>${item.quantity} Units </td>
                                <td>&euro; ${item.product.CODE * item.quantity} </td>
                                    </tr>
                                    </table>
                                    </span>
		</c:forEach>
        
        
        
        <li class="list-group-item d-flex justify-content-between">
          <span>Total </span>
          <strong> &euro; ${total}</strong>
        </li>
      </ul>
        <p>
        <a href="${pageContext.request.contextPath }/ConfirmOrderServlet?action=${ONum}" class="btn btn-primary my-2">Pay With PayPal</a>
        <a href="${pageContext.request.contextPath }/ProductsServlet" class="btn btn-secondary my-2">Return to Products</a>
        </p>
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
      <script src="form-validation.js">      
      </script>	
       

	
    </body>
</html>
