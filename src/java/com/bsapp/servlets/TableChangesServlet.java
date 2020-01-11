/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.servlets;

import com.bsapp.dao.OrderDAO;
import com.bsapp.dao.ProductDAO;
import com.bsapp.dao.UserDAO;
import com.bsapp.model.Order;
import com.bsapp.model.Product;
import com.bsapp.model.User;
import com.bsapp.utils.IConstants;
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
 * @author Colm Sheehan
 */
public class TableChangesServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
            System.out.println("Launches here");
            if (action.equalsIgnoreCase("User")) {
                updateUsers(request,response);
            }
            if (action.equalsIgnoreCase("UserD")) {
                 deleteUser(request,response);
            }
            if (action.equalsIgnoreCase("Product")) {
                updateProduct(request,response);
            }
            if (action.equalsIgnoreCase("ProductD")) {
                 deleteProduct(request,response);
            }
            if (action.equalsIgnoreCase("Order")) {
                updateOrder(request,response);
            }
            if (action.equalsIgnoreCase("OrderD")) {
                 deleteOrder(request,response);
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

        private void updateUsers(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String strId = request.getParameter("id");
            long lId = Long.parseLong(strId);
            String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String pWord = request.getParameter("password");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType");
        String eCode = request.getParameter("ecode");
        System.out.println(fName + lName + pWord + email + userType + eCode);
        
        Vector<User> UserData = new Vector();
        
        User tempUser = new User() ;
        tempUser.setId(lId);
        tempUser.setPassword(pWord);
        tempUser.setEmail(email);
        tempUser.setEirCode(eCode);
        tempUser.setFirstName(fName);
        tempUser.setLastName(lName);
        tempUser.setUserType(userType);
        
        UserDAO userDAO = new UserDAO();
        
        userDAO.updateUser(tempUser);
        
        SetupDb setupDb = new SetupDb();
        
        setupDb.showData();
            
        response.sendRedirect("adminServlet?&action=List");    
        
        }
  }
            
        private void deleteUser(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String strId = request.getParameter("id");
            long lId = Long.parseLong(strId);
        User tempUser = new User() ;
        UserDAO userDAO = new UserDAO();
        
        
        tempUser.setId(lId);
        
        userDAO.deleteUser(tempUser);
        
        SetupDb setupDb = new SetupDb();
        
        setupDb.showData();
            
        response.sendRedirect("adminServlet?&action=List");
        }
        
        private void updateProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
        String strId = request.getParameter("id");
        long lId = Long.parseLong(strId);
        String pName = request.getParameter("pName");
        String pType = request.getParameter("pType");
        String pDesc = request.getParameter("pDesc");
        String pPrice = request.getParameter("pPrice");
        String strpUnits = request.getParameter("pUnits");
        long lpUnits = Long.parseLong(strpUnits);
        
        Product tempProduct = new Product();
                
                tempProduct.setId(lId);
                tempProduct.setProdName(pName);
                tempProduct.setProdType(pType);
                tempProduct.setProdDescription(pDesc);
                tempProduct.setCODE(pPrice);
                tempProduct.setStock(lpUnits);
        
        ProductDAO productDAO = new ProductDAO();
        
        productDAO.updateProduct(tempProduct);
        
        SetupDb setupDb = new SetupDb();
        
        setupDb.showData();
            
        response.sendRedirect("adminServlet?&action=Listp");    
        
        }
        }

        private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String strId = request.getParameter("id");
            long lId = Long.parseLong(strId);
        Product tempProduct = new Product() ;
        ProductDAO productDAO = new ProductDAO();
        
        
        tempProduct.setId(lId);
        
        productDAO.deleteProduct(tempProduct);
        
        SetupDb setupDb = new SetupDb();
        
        setupDb.showData();
            
        response.sendRedirect("adminServlet?&action=Listp");
        }
        
        private void updateOrder(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
        String strRECORDId = request.getParameter("strRecord_ID");
        long lRECORDId = Long.parseLong(strRECORDId);   
        String strId = request.getParameter("id");
        long lId = Long.parseLong(strId);
        String strcustomerId = request.getParameter("strcustomerId");
        int intCustomerID = Integer.parseInt(strcustomerId);
        String strShippingId = request.getParameter("strShippingId");
        int intShippingId = Integer.parseInt(strShippingId);
        String strproductId = request.getParameter("strproductId");
        int intproductId = Integer.parseInt(strproductId);
        String strquantity = request.getParameter("strquantity");
        int intquantity = Integer.parseInt(strquantity);
        String strpayID = request.getParameter("strpayID");
        int intpayID = Integer.parseInt(strpayID);
        
        Order tempOrder = new Order();
                tempOrder.setRECORD_ID(lRECORDId);
                tempOrder.setORDER_ID(lId);
                tempOrder.setCUSTOMER_ID(intCustomerID);
                tempOrder.setSHIPPING_ID(intShippingId);
                tempOrder.setPRODUCT_ID(intproductId);
                tempOrder.setQUANTITY(intquantity);
                tempOrder.setEXTERNALPAYMENT_ID(intpayID);
        
        OrderDAO OrderDAO = new OrderDAO();
        
        OrderDAO.updateOrder(tempOrder);
        
        SetupDb setupDb = new SetupDb();
        
        setupDb.showData();
            
        response.sendRedirect("adminServlet?&action=Listo");    
        
        }
        }

        private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String strRECORDId = request.getParameter("id");
        System.out.println(strRECORDId);
        long lRECORDId = Long.parseLong(strRECORDId);
        Order tempOrder = new Order() ;
        OrderDAO orderDAO = new OrderDAO();
        
        
        tempOrder.setRECORD_ID(lRECORDId);
        
        orderDAO.deleteOrder(tempOrder);
        
        SetupDb setupDb = new SetupDb();
        
        setupDb.showData();
            
        response.sendRedirect("adminServlet?&action=Listo");
        }
        

}
        




