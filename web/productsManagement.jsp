<%@page import="com.bsapp.model.User"%>
<%@page import="java.util.Vector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>SAS | Products Management</title>
    
    
        <!-- Le styles -->
        <link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        
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
    </style>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.4/examples/dashboard/dashboard.css" rel="stylesheet">
    </head>

   <body>
       <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a href="../${pageContext.request.contextPath}" class="navbar-brand d-flex align-items-center">
        <img src="img/paint-palette-and-brush.svg" width="32.5" height="32.5" style="margin-right: 6px;" >
         The Sketchy Art Shop
      </a>
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="LogOutServlet">Sign out</a>
    </li>
  </ul>
</nav>
       
        <div class="container-fluid">
        <div class="row">
            <%@include  file="Recurring_items/adminhomenav_new.html" %>

            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
              <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Dashboard</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                  
                </div>
              </div>
                <canvas id="thisChart" width="400" height="150"></canvas>
                


              <h2>Products Management</h2>
              <div class="table-responsive">
                <table class="table table-striped table-sm">
                  <thead>
                    <tr>
                        <th>#</th>
                                    <th>Name</th>
                                    <th>Type</th>
                                    <th>Price</th>
                                    <th>Amt in Stock</th>
                                    <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${RKALLPRODUCTS}" var="tempproduct">    
                                    <tr>
                                        <td scope="row"><c:out value="${tempproduct.getId()}"/></td>
                                        <td><c:out value="${tempproduct.getProdName()}"/></td>
                                        <td><c:out value="${tempproduct.getProdType()}"/></td>
                                        <td><c:out value="${tempproduct.getCODE()}"/></td>
                                        <td><c:out value="${tempproduct.getStock()}"/></td>
                                        <td><button type="button" class="btn btn-primary btn-sm" onclick="document.getElementById('${tempproduct.getId()}').style.display='block'">Edit Record</button></td>
                                    </tr>
                                </c:forEach>
                  </tbody>
                </table>
              </div>
            </main>
            </div>
          </div>
    <c:forEach items="${RKALLPRODUCTS}" var="tempproduct">         
            <!-- Edit Record Windows -->
    <div id="${tempproduct.getId()}" class="modal" >
    <div class="box">
      <h2>Product ${tempproduct.getId()}</h2>
      <form action="${pageContext.request.contextPath }/UpdateUser?&action=Product&id=${tempproduct.getId()}" method="POST">
        <div class="inputBox">
          <input type="" name="pName" required onkeyup="this.setAttribute('value', this.value);" value="${tempproduct.getProdName()}">
          <label>Product Name</label>
        </div>
        <div class="inputBox">
            <input type="" name="pType" required value="<c:out value="${tempproduct.getProdType()}"/>">
        <label>Product Type</label>
        
        </div>
        <label  style="color:white">Product Description</label>
        <div class="inputBox">
            <textarea id = "myTextArea" name="pDesc" rows = "4" cols = "30" maxlength="100">${tempproduct.getProdDescription()}</textarea>
        </div>
        <div class="inputBox">
            
            <input type="text" class="form-control" id="lastName" name="pPrice" placeholder="" value="${tempproduct.getCODE()}" required="">
            <label for="lastName">Price &euro;</label>
        </div>
        
        <div class="inputBox">
          
          <input type="text" class="form-control" id="address" name="pUnits" placeholder="" required="" value="<c:out value="${tempproduct.getStock()}"/>">
          <label for="address">Units in Stock</label>
        </div>
                   
         <center>
              <button type="submit" class="btn btn-primary" name="updateP" value="updateP" style="margin: 10px;">Save Changes</button>
              <a class="btn btn-warning" href="${pageContext.request.contextPath }/adminServlet?&action=Listp">Cancel</a>
        <a href="${pageContext.request.contextPath }/UpdateUser?&action=ProductD&id=${tempproduct.getId()}" class="btn btn-danger">Delete Product</a>
        </center>
      </form>
    </div>
    </div>
      
    
    <!-- End Modal  -->
     </c:forEach>        
          <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
                <script>window.jQuery || document.write('<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="/docs/4.4/dist/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
                  <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
                  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
                  
                      <!--  stock Bar Chart -->
                      <script>
                        var ctx = document.getElementById('thisChart');
                        var thisChart = new Chart(ctx, {
                            type: 'bar',
                            data: {
                                labels: [<c:forEach items="${RKALLPRODUCTS}" var="tempproduct">    
                                    '${tempproduct.getProdName()}', </c:forEach>],
                                datasets: [{
                                    label: 'Units in Stock',
                                    data: [<c:forEach items="${RKALLPRODUCTS}" var="tempproduct">    
                                    '${tempproduct.getStock()}', </c:forEach>],
                                    backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                    ],
                                    borderColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderWidth: 1
                                }]
                            },
                            options: {
                                scales: {
                                    yAxes: [{
                                        ticks: {
                                            beginAtZero: true
                                        }
                                    }]
                                }
                            }
                        });
                    </script>
                  
                  
                  <script src="https://getbootstrap.com/docs/4.4/examples/dashboard/dashboard.js"></script>
   </body>
</html>
