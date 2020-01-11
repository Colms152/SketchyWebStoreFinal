/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.servlets;

import com.bsapp.dao.ProductDAO;
import com.bsapp.model.Product;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Colm
 */
public class TestAjaxServlet extends HttpServlet {

    private ServletContext context;
    private ProductDAO prodDataDAO = new ProductDAO();
    private HashMap products = prodDataDAO.getAllProductsinHM();
    
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
        this.context = config.getServletContext();
        
    }
    
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
        
        
        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        System.out.println(targetId);

        
        //Below is from ajax example
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;
        
        if (action.equals("complete")) {
            
        
            // check if user sent empty string
            if (!targetId.equals("")) {

                Iterator it = products.keySet().iterator();
                
                while (it.hasNext()) {
                    
                    String id = (String) it.next();
                    System.out.println("BP");
                    Product product = (Product) products.get(id);
                    System.out.println(product.getProdName());
                    if ( // targetId matches first name
                         product.getProdName().toLowerCase().startsWith(targetId) ||
                         // targetId matches last name - Type
                         product.getProdType().toLowerCase().startsWith(targetId)
                         ) {

                        sb.append("<product>");
                        sb.append("<id>" + product.getId() + "</id>");
                        sb.append("<Name>" + product.getProdName() + "</Name>");
                        sb.append("<Type>" + product.getProdType() + "</Type>");
                        sb.append("<Description>" + product.getProdDescription() + "</Description>");
                        sb.append("<CODE>" + product.getCODE() + "</CODE>");
                        sb.append("</product>");
                        namesAdded = true;
                    }
                }
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<products>" + sb.toString() + "</products>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        
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
