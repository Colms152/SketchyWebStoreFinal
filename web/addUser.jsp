
<%@page import="com.bsapp.model.User"%>
<%@page import="java.util.Vector"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>SAS | Add User</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
        </style>
        <link href="css/bootstrap-responsive.css" rel="stylesheet">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="../assets/js/html5shiv.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="../assets/ico/favicon.png">
    </head>

    <body>

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#">Project name</a>
                    <div class="nav-collapse collapse">
                        <p class="navbar-text pull-right">
                            <% User user = (User) session.getAttribute("SKUSER");%>
                            Logged in as <a href="#" class="navbar-link"><%= user.getFirstName()%></a>
                        </p>
                        <ul class="nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <%@include  file="Recurring_items/adminhomenav.html" %><!--/.well -->
                </div><!--/span-->
                <div class="span9">
                    <H4>Add New User</H4>
                    <div class="hero-unit"> 
                        <c:url var="postUrl" value="/UserManagement">
                        <c:param name="action" value="add"/>
                    </c:url>
        
                    <form action="${postUrl}" method="POST">
                        <div class="form-group">
                            <label for="email">Email Address:</label>
                            <input type="email" name="EMAIL" class="form-control" id="email">
                        </div>
                        
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" name="PASSWORD"class="form-control" id="pwd">
                        </div>
                        <div class="form-group">
                            <label for="fname">First Name:</label>
                            <input type="fname" name="FNAME" class="form-control" id="fname">
                        </div>
                        <div class="form-group">
                            <label for="lname">Last Name:</label>
                            <input type="lname" name="LNAME" class="form-control" id="lname">
                        </div>
                        
                        
                        <div class="form-group">
                            <label for="usertype">User Type:</label>
                            <select class="form-control" id="usertype" name = "USERTYPE" type="usertype" required="">
                            <option value="GENUSER">GENUSER</option>
                            <option>ADMIN</option>
                            </select>
                        </div>
                        
                        
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    </div>
                    
                    <br/>

                    <!-- /.row -->

                </div>
            </div>

            
        </div><!--/span-->
    </div><!--/row-->

    <hr>

    <footer>
        <p>&copy; Company 2013</p>
    </footer>

</div><!--/.fluid-container-->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!--<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap-transition.js"></script>
<script src="../assets/js/bootstrap-alert.js"></script>
<script src="../assets/js/bootstrap-modal.js"></script>
<script src="../assets/js/bootstrap-dropdown.js"></script>
<script src="../assets/js/bootstrap-scrollspy.js"></script>
<script src="../assets/js/bootstrap-tab.js"></script>
<script src="../assets/js/bootstrap-tooltip.js"></script>
<script src="../assets/js/bootstrap-popover.js"></script>
<script src="../assets/js/bootstrap-button.js"></script>
<script src="../assets/js/bootstrap-collapse.js"></script>
<script src="../assets/js/bootstrap-carousel.js"></script>
<script src="../assets/js/bootstrap-typeahead.js"></script> -->

</body>
</html>
