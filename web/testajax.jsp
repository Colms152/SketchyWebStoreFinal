<%-- 
    Document   : testajax.jsp
    Created on : 27-Dec-2019, 16:36:19
    Author     : Colm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <style>
          h1 {
   letter-spacing: 6px;
   font-size: 1.6em;
   color: #be7429;
   font-weight: bold;
}

h2 {
   text-align: left;
   letter-spacing: 6px;
   font-size: 1.4em;
   color: #be7429;
   font-weight: normal;
   width: 450px;
}

table {
   width: 550px;
   padding: 10px;
   background-color: #c5e7e0;
   font-family: sans-serif;
}

td {
   padding: 10px;
}

a {
  color: #be7429;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

.popupBox {
  position: absolute;
  left: 140px;
}

.popupCell {
   background-color: #fffafa;
}

.popupCell:hover {
  background-color: #f5ebe9;
}

.popupItem {
  color: #333;
  text-decoration: none;
  font-size: 1.2em;
}
       </style>   
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auto-Completion using AJAX</title>

        <script type="text/javascript" src="javascriptsws.js"></script>
  </head>
  <body onload="init()">
    <h1>Auto-Completion using AJAX</h1>

        <p>This example shows how you can do real time auto-completion using Asynchronous
            JavaScript and XML (Ajax) interactions.</p>

    <p>In the form below enter a product name. Possible names that will be completed are displayed below
        the form. </p>

    <form name="autofillform" action="autocomplete">
      <table border="0" cellpadding="5"> 
        <tbody>
          <tr>
            <td><strong>Product Name:</strong></td>
            <td><input type="text" size="40" id="complete-field" onkeyup="doCompletion()"></td>
          </tr>
          <tr>
            <td id="auto-row" colspan="2"><table id="complete-table" class="popupBox" /></td>
          </tr>
        </tbody>
      </table>
    </form>
  </body>
</html>
