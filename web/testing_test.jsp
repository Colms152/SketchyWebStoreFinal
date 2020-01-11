<%-- 
    Document   : testing_test
    Created on : Dec 19, 2019, 2:45:41 PM
    Author     : Colm Sheehan
--%>

<%@page import="com.bsapp.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.bsapp.model.User"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath }/CartServlet">Buy</a>
        
        <% Vector<User> allUsers = (Vector<User>) request.getAttribute("RKALLUSERS");%>-
                        <%
                           for (User theUser: allUsers){
                               out.println(theUser.getFirstName());
                           } 
                         %>
        
        <h1>Hello World!</h1>
        
        <% Vector<Product> allProducts = (Vector<Product>) request.getAttribute("RKALLPRODUCTS");%>-
                        <%
                           for (Product theProduct: allProducts){
                               out.println(theProduct.getCODE());
                           } 
                         %>
        
             
        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Last Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (User theUser: allUsers){%>   
                                    <tr>
                                        <td><%=theUser.getLastName()%></td>

                                    </tr> <%}%>

                            </tbody>
                        </table>>
        
        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${RKALLUSERS}" var="tempuser">    
                                    <tr>
                                        <td scope="row"><c:out value="${tempuser.getId()}"/></td>
                                        <td>${tempuser.firstName}"</td>
                                        <td>${tempuser.lastName}"</td>
                                        <td>${tempuser.email}"</td>
                                        <td><a> link to edit </a> </td>
                                    </tr>
                                </c:forEach>
                                    


                            </tbody>
                        </table>
                                        
                                        
                                        <p>Lets print the string value we added to the request</p>
                        <p> ${stringKey}</p>
                        
                        <p>What about the user object</p>
                        <p>${UserObjectKey.firstName}, ${UserObjectKey.lastName} </p>
                        
                        <p>What about the user object on the session</p>
                        <p>${SessionUserObjectKey.firstName}, ${SessionUserObjectKey.lastName} </p>
                        
                        
                      <p>We have access to lots of things - e.g. the header</p>
                         <p>${header["user-agent"]}}
    </body>
</html>
