/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.servlets;

import com.bsapp.dao.OrderDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsapp.model.CartItem;
import com.bsapp.dao.ProductDAO;
import com.bsapp.model.User;
import javax.servlet.RequestDispatcher;




/**
 *
 * @author Colm
 */
public class CartServlet extends HttpServlet {

 private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}
        
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            OrderDAO oDAO = new OrderDAO();
            
            HttpSession session = request.getSession();
                        session.setAttribute("ONum", oDAO.getMaxOrderNo());
            if (session.getAttribute("SKUSER") != null){
            User user = (User) session.getAttribute("SKUSER");
            String User = user.getFirstName();
            
            if(User != null){
            
                String action = request.getParameter("action");
            
		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			} else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
		}
            }
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("ProductsServlet");
                rd.forward(request, response);
            }
        }
	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getRequestDispatcher("Cart.jsp").forward(request, response);
                response.sendRedirect("Cart.jsp");
	}

	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		int index = isExisting(request.getParameter("id"), cart);
		System.out.println(index);
                cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("Cart.jsp");
	}

	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
                ProductDAO productDAO = new ProductDAO();
		HttpSession session = request.getSession();
                
		if (session.getAttribute("cart") == null) {
			List<CartItem> cart = new ArrayList<>();
			cart.add(new CartItem(productDAO.getProductById(request.getParameter("id")),1));
			System.out.println("Here3");
                        
                        System.out.println(cart.get(0));
                        session.setAttribute("cart", cart);
		} else {
			List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
			int index = isExisting(request.getParameter("id"), cart);
			if (index == -1) {
				cart.add(new CartItem(productDAO.getProductById(request.getParameter("id")), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
                        System.out.println("Here1");
                        System.out.println(cart.get(0));
			session.setAttribute("cart", cart);
		}
                System.out.println("Here2");
                
		response.sendRedirect("Cart.jsp");
	}

	private int isExisting(String id, List<CartItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
		int cid = Integer.valueOf(id);	
                    if (cart.get(i).getProduct().getId()==(cid)) {				
                        return i;
			}
		}
		return -1;
	}
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    

