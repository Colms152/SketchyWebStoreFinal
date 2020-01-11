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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Colm Sheehan
 */
public class adminServlet extends HttpServlet {

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
            
		if (action == null) {
			System.out.println("no action");
                } else{
                    if (action.equals("List")){
                        System.out.println(action);
                        listUsers(request,response);
                    }
                    if (action.equals("Listp")){
                        System.out.println(action);
                        listProducts(request,response);
                    }
                    if (action.equals("Listo")){
                        System.out.println(action);
                        listOrders(request,response);
                    }
                    if (action.equals("addInit")){
                        System.out.println(action);
                        addInitUsers(request,response);
                    }
                    if (action.equals("add")){
                        System.out.println(action);
                    }
                }
        
                
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        Vector<User> allUsersVect = userDAO.getAllUsers();
        System.out.println("This far");
        request.setAttribute(IConstants.REQUEST_KEY_ALL_USERS, allUsersVect);

        RequestDispatcher rd = request.getRequestDispatcher("/userManagement.jsp");
        rd.forward(request, response);
  }
    
    private void addInitUsers(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/addUser.jsp");
        rd.forward(request, response);
  }
    
     private void listProducts(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        Vector<Product> allproductsVect = productDAO.getAllProductsinVect();
        request.setAttribute(IConstants.REQUEST_KEY_ALL_PRODUCTS, allproductsVect);

        RequestDispatcher rd = request.getRequestDispatcher("/productsManagement.jsp");
        rd.forward(request, response);
  }
     
     private void listOrders(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAO();
        Vector<Order> allOrdersVect = orderDAO.getAllOrdersinVect();
        request.setAttribute(IConstants.REQUEST_KEY_ALL_ORDERS, allOrdersVect);

        RequestDispatcher rd = request.getRequestDispatcher("/orderManagement.jsp");
        rd.forward(request, response);
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
