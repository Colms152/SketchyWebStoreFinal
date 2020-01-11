 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.servlets;

import com.bsapp.dao.OrderDAO;
import com.bsapp.dao.ProductDAO;
import com.bsapp.dao.UserDAO;
import com.bsapp.model.CartItem;
import com.bsapp.model.Order;
import com.bsapp.model.User;
import com.bsapp.utils.SetupDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Colm
 */
public class ConfirmOrderServlet extends HttpServlet {

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
        System.out.println("Start Confirm Order Servlet");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("SKUSER");
        System.out.println(user);
        
        if (session.getAttribute("SKUSER") != null){
            System.out.println("Getting to there is a user logged in");
            
            long UserID = user.getId();
            OrderDAO orderDAO4ID = new OrderDAO();
            System.out.println(orderDAO4ID.getMaxOrderNo());
            int orderno = orderDAO4ID.getMaxOrderNo() + 1;
            System.out.println("Order Number:" + orderno);
            
            if (session.getAttribute("cart") != null) {
                System.out.println("Getting to true theres a cart available");
                List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
                        
                        //for (CartItem item : cart){
                        //System.out.println(item);
                        //int itemno = item.product.getId();
                        //}
                for (int i = 0; i < cart.size(); i++) {
                    long itemnumberL = cart.get(i).getProduct().getId();
                    int itemquant = cart.get(i).getQuantity();
                    System.out.println(itemnumberL);    
                    Order tempOrder = new Order() ;
        
                    tempOrder.setPRODUCT_ID(itemnumberL);
                    tempOrder.setQUANTITY(itemquant);
                    tempOrder.setCUSTOMER_ID(UserID);
                    tempOrder.setORDER_ID(orderno);
                            
                    OrderDAO orderDAO = new OrderDAO();
                    OrderDAO orderDAO2 = new OrderDAO();


                    orderDAO.insertORDER(tempOrder);
                    System.out.println("Inserted");
                    orderDAO2.updateOrderedProductsStock(tempOrder);

                    SetupDb setupDb = new SetupDb();

                    setupDb.showData();  
                    }

            }
        }
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("LogOutServlet");
        rd.forward(request, response); 
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConfirmOrderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmOrderServlet at " + request.getContextPath() + "</h1>");
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
