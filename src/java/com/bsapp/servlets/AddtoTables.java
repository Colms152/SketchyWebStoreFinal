/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.servlets;

import com.bsapp.dao.ProductDAO;
import com.bsapp.dao.UserDAO;
import com.bsapp.model.Product;
import com.bsapp.model.User;
import com.bsapp.utils.SetupDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Colm
 */
public class AddtoTables extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action == null){
        action = "notproduct";
        }
        if(action.equalsIgnoreCase("nProduct")){
            String pName = request.getParameter("pName");
            String pType = request.getParameter("pType");
            String pDesc = request.getParameter("pDesc");
            String pPrice = request.getParameter("pPrice");
            String strpUnits = request.getParameter("pUnits");
            long lpUnits = Long.parseLong(strpUnits);

            Product tempProduct = new Product();

            tempProduct.setProdName(pName);
            tempProduct.setProdType(pType);
            tempProduct.setProdDescription(pDesc);
            tempProduct.setCODE(pPrice);
            tempProduct.setStock(lpUnits);


            ProductDAO productDAO = new ProductDAO();

            productDAO.insertProduct(tempProduct);

            SetupDb setupDb = new SetupDb();

            setupDb.showData();

            RequestDispatcher rd = request.getRequestDispatcher("/adminServlet?&action=Listp");
            rd.forward(request, response);
        }
        
        
        
        String fName = request.getParameter("firstName");
        if(fName != null){
        String lName = request.getParameter("lastName");
        String pWord = request.getParameter("password");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType");
        String eCode = request.getParameter("ecode");
        System.out.println(fName + lName + pWord + email + userType + eCode);
        
        Vector<User> UserData = new Vector();
        
        User tempUser = new User() ;
        
        tempUser.setPassword(pWord);
        tempUser.setEmail(email);
        tempUser.setEirCode(eCode);
        tempUser.setFirstName(fName);
        tempUser.setLastName(lName);
        tempUser.setUserType(userType);
        
        UserDAO userDAO = new UserDAO();
        
        userDAO.insertUser(tempUser);
        
        SetupDb setupDb = new SetupDb();
        
        setupDb.showData();
        
        RequestDispatcher rd = request.getRequestDispatcher("LogOutServlet");
        rd.forward(request, response);
            }
       
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Added</h1><br><p>"+ fName + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
