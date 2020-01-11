/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.dao;

import com.bsapp.model.Order;

import com.bsapp.utils.DBManager;
import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;

/**
 *
 * @author Colm
 */
public class OrderDAO {
    
    
    public void insertORDER(Order newOrder){
        String stmtNewUser = "INSERT INTO USERDATA(ORDER_ID,CUSTOMER_ID,SHIPPING_ID,PRODUCT_ID,QUANTITY,3RDPARTYPAYMENT_ID)\n" +
        "VALUES('" + newOrder.getORDER_ID() + "', '" + newOrder.getCUSTOMER_ID() + "', '" + newOrder.getSHIPPING_ID() + "', '" + newOrder.getPRODUCT_ID() + "','" + newOrder.getQUANTITY() + "', '" + newOrder.getEXTERNALPAYMENT_ID() + "')";
  
        
        String stmtNewORDER = " INSERT INTO TORDER (ORDER_ID,CUSTOMER_ID,PRODUCT_ID,QUANTITY ) "
                + "VALUES( " + newOrder.getORDER_ID() + "," + newOrder.getCUSTOMER_ID() + ", " + newOrder.getPRODUCT_ID() + ", " + newOrder.getQUANTITY() + ")";
        
        DBManager dmbgr = new DBManager();
        Statement currentStatement = null;
        Connection con = dmbgr.getConnection();
        try {
            // Execute statement
            currentStatement = con.createStatement();
            currentStatement.execute(stmtNewORDER);
        } catch (SQLException sqlExcept) {
            logger.log(Level.SEVERE, null, sqlExcept);
        }
    }
    
    public Vector<Order> getAllOrdersinVect() {

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int recordid = 0;
        int orderId = 0;
        int customerId = 0;
        int ShippingId = 0;
        int productId = 0;
        int quantity = 0;
        int payID = 0;
        String test;
        Vector<Order> orderData = new Vector();

        String query = "SELECT * FROM TORDER";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                recordid = (rs.getInt(1));
                
                orderId = (rs.getInt(2));
                
                customerId = (rs.getInt(3));
                
                ShippingId = (rs.getInt(4));
                
                productId = (rs.getInt(5));
                
                quantity = (rs.getInt(6));
                
                payID = (rs.getInt(7));
                
                Order tempOrder = new Order();
                
                tempOrder.setRECORD_ID(recordid);
                tempOrder.setORDER_ID(orderId);
                tempOrder.setCUSTOMER_ID(customerId);
                tempOrder.setSHIPPING_ID(ShippingId);
                tempOrder.setPRODUCT_ID(productId);
                tempOrder.setQUANTITY(quantity);
                tempOrder.setEXTERNALPAYMENT_ID(payID);
                orderData.add(tempOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return orderData;

    }
    
    public int getMaxOrderNo() {

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int orderId = 0;
        

        String query = "SELECT MAX(ORDER_ID) FROM TORDER";
        System.out.print(query);
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orderId = (rs.getInt(1));
                System.out.print(orderId);
                return orderId;
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderId;
    }
    
    public void updateOrder(Order newOrder){
        String stmtUpdateUser = "UPDATE TORDER "
                + "SET CUSTOMER_ID = " + newOrder.getCUSTOMER_ID() + ", SHIPPING_ID = " + newOrder.getSHIPPING_ID() + ", PRODUCT_ID= " + newOrder.getPRODUCT_ID() + ", QUANTITY= " + newOrder.getQUANTITY() + ", EXTERNELPAY=" + newOrder.getEXTERNALPAYMENT_ID() + " "
                + "WHERE RECORD_ID= "+ newOrder.getRECORD_ID()+"";
        
        DBManager dmbgr = new DBManager();
        Statement currentStatement = null;
        Connection con = dmbgr.getConnection();
        try {
            // Execute statement
            currentStatement = con.createStatement();
            currentStatement.execute(stmtUpdateUser);
        } catch (SQLException sqlExcept) {
            logger.log(Level.SEVERE, null, sqlExcept);
        }
    }
    
    public void updateOrderedProductsStock(Order newOrder){
        String stmtone = "select STOCK from PRODUCT where PRODUCT_ID = " + newOrder.getPRODUCT_ID();
        /*" + newOrder.getQUANTITY() + " */
        
        System.out.println(stmtone);
        DBManager dmbgr = new DBManager();
        Statement currentStatement = null;
        Connection con = dmbgr.getConnection();
        int stockVolume = 0;
        try {
            PreparedStatement stmt = con.prepareStatement(stmtone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stockVolume = (rs.getInt(1));
                System.out.print("Stock volume before order =" + stockVolume); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stockVolume = stockVolume-newOrder.getQUANTITY();
        System.out.print("Stock volume after order =" + stockVolume);
        
        String stmtUpdate = "UPDATE PRODUCT "
                + "SET STOCK=" + stockVolume + " "
                + "WHERE PRODUCT_ID= "+ newOrder.getPRODUCT_ID()+"";
        
        try {
            // Execute statement
            currentStatement = con.createStatement();
            currentStatement.execute(stmtUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
         
    }
     
    public void deleteOrder(Order newOrder){
        String stmtUpdateUser = "Delete from TORDER WHERE RECORD_ID= "+ newOrder.getRECORD_ID();
        
        DBManager dmbgr = new DBManager();
        Statement currentStatement = null;
        Connection con = dmbgr.getConnection();
        try {
            // Execute statement
            currentStatement = con.createStatement();
            currentStatement.execute(stmtUpdateUser);
        } catch (SQLException sqlExcept) {
            logger.log(Level.SEVERE, null, sqlExcept);
        }
    }
    
}
