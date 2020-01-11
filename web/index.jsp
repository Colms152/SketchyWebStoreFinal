<%-- 
    Document   : index
    Created on : Jan 4, 2020, 7:02:58 PM
    Author     : Colm Sheehan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<!doctype html>
<html lang="en">
    <c:set var="loc" value="en_US"/>
<c:if test="${!(empty param.locale)}">
    <c:set var="loc" value="${param.locale}"/>
</c:if>
<fmt:setLocale value="${loc}" />

<fmt:bundle basename="com.bsapp.utils/app">
    
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <meta http-equiv=“CACHE-CONTROL” content=”NO-CACHE”>
    <title>The Sketchty Art Shop</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >

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
    #x {
    position: relative;
    float: right;
    top: -10px;
    right: -10px;
}  
    </style>
    <!-- Custom styles for this template -->
    <link href="css/cover.css" rel="stylesheet">
    <link href="signin.css" rel="stylesheet">
    
  </head>
  <body class="text-center"  style="background-image: url(../sketchywebstore/img/HompageBG.jpg);">
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">The Sketchy Art Shop</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a onclick="document.getElementById('id01').style.display='block'" class="nav-link active" href="#"><fmt:message key="LogIn"/></a>
        <a onclick="document.getElementById('id02').style.display='block'" class="nav-link active" href="#"><img src="img/language.svg" width="26" height="26" ></a>
      </nav>
    </div>
  </header>

  <main role="main" class="inner cover">
    <h1 class="cover-heading">The Sketchy Art Shop</h1>
    <p class="lead"><fmt:message key="Banner"/></p>
    <p class="lead">
      <a href="ProductsServlet" class="btn btn-lg btn-secondary"><fmt:message key="ShopNow"/></a>
    </p>
    
    <!-- LogIN Windows -->
    <div id="id01" class="modal">
    <div class="box">
      <button type="button" class="close" aria-label="Close" id="x">
          <a href="${pageContext.request.contextPath}/index.jsp"> 
                <span aria-hidden="true">&times;</span></a> 
                </button> 
        <h2><fmt:message key="RequestLogin"/></h2>
      
      <form action="LoginServlet" method="POST">
        <div class="inputBox">
          <input type="email"  name="email" required onkeyup="this.setAttribute('value', this.value);" value="">
          <label>eMail</label>
        </div>
        <div class="inputBox">
            <input type="password" name="password" required value="" >
        <label><fmt:message key="password"/></label>
        </div>
        <center>
              <button type="submit" class="btn btn-success" name="sign-in" value="Sign In" style="margin: 10px;"><fmt:message key="LogIn"/></button>  <br>  
        <a href="NewUser.jsp" class="btn btn-primary"><fmt:message key="NewAccount"/></a>
        </center>
      </form>
    </div>
    </div>
      
    <script>
      // Get the modal
      var modal1 = document.getElementById('id01');
      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
      if (event.target == modal1) {
        modal1.style.display = "none";
      }
      }
    </script>
    <!-- End Modal Login -->
    
    <!-- LogIN Windows -->
    <div id="id02" class="modal">
    <div class="box">
                <button type="button" class="close" aria-label="Close" id="x">
                <a href="${pageContext.request.contextPath}/index.jsp">    
                    <span aria-hidden="true">&times;</span></a>
                </button>    
                <h4>Please Select Your Preferred Language</h4>
                    <c:url value="application.jsp" var="engURL">
                 <c:param name="locale" value="en_US"/>
                  </c:url>

                  <a href="index.jsp?locale=en_US">
                   <img src="https://media.giphy.com/media/Mh9fsz5AolnDq/giphy.gif" height="50" width="50"/>
                  </a>

                  <c:url value="application.jsp" var="frenchURL">
                   <c:param name="locale" value="fr_FR"/>
                </c:url>

                <a href="index.jsp?locale=fr_FR"> 
                     <img src="https://media.giphy.com/media/ErPDvrEYZYNOM/giphy.gif" height="50" width="50"/>
                </a>  

                  </div>
                  </div>
      
    <script>
      // Get the modal
      var modal = document.getElementById('id02');
      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
      }
    </script>
    <!-- End Modal Login -->
    
  </main>

        
      
       
  <footer class="mastfoot mt-auto">
    
  </footer>
</div>
</body>
</fmt:bundle>

</html>
