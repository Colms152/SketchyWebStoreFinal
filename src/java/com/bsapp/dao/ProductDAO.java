/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.dao;

import com.bsapp.model.Product;
import com.bsapp.utils.DBManager;
import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author Colm Sheehan
 */
public class ProductDAO {


   
    
    public Product getProductById(String ID) {

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int productId = 0;
        String name = null;
        String type = null;
        String Description = null;
        String CODE = null;
        Product tempProduct = new Product();

        String query = "SELECT * FROM PRODUCT WHERE PRODUCT_ID=" + ID;
        System.out.print(query);
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productId = (rs.getInt(1));
                name = (rs.getString(2));
                type = (rs.getString(3));
                Description = (rs.getString(4));
                CODE = (rs.getString(5));
                System.out.print(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        tempProduct.setId(productId);
        
        tempProduct.setId(productId);
        tempProduct.setProdName(name);
        tempProduct.setProdType(type);
        tempProduct.setProdDescription(Description);
        tempProduct.setCODE(CODE);
        System.out.print(name+CODE);
        return tempProduct;
    }
    
    public Vector<Product> getProductByIdinVect(String ID) {
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int productId = 0;
        String name = null;
        String type = null;
        String Description = null;
        String CODE = null;
        Vector<Product> productData = new Vector();

        String query = "SELECT * FROM PRODUCT WHERE PRODUCT_ID=" + ID;
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productId = (rs.getInt(1));
                name = (rs.getString(2));
                type = (rs.getString(3));
                Description = (rs.getString(4));
                CODE = (rs.getString(5));
                
                Product tempProduct = new Product();
                
                tempProduct.setId(productId);
                tempProduct.setProdName(name);
                tempProduct.setProdType(type);
                tempProduct.setProdDescription(Description);
                tempProduct.setCODE(CODE);
                System.out.println(productId + name + type+ CODE);
                productData.add(tempProduct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productData;
    }
    
    public Vector<Product> getSearchedProductsinVect(String key) {
        System.out.println(key);
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int productId = 0;
        String name = null;
        String type = null;
        String Description = null;
        String CODE = null;
        Vector<Product> productData = new Vector();

        String query = "SELECT * FROM PRODUCT WHERE NAME LIKE '%" + key +"%'";
        
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productId = (rs.getInt(1));
                name = (rs.getString(2));
                type = (rs.getString(3));
                Description = (rs.getString(4));
                CODE = (rs.getString(5));
                
                Product tempProduct = new Product();
                
                tempProduct.setId(productId);
                tempProduct.setProdName(name);
                tempProduct.setProdType(type);
                tempProduct.setProdDescription(Description);
                tempProduct.setCODE(CODE);
                System.out.println(productId + name + type+ CODE);
                productData.add(tempProduct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productData;
    }
    
    public Vector<Product> getAllProductsinVect() {

        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int productId = 0;
        String name = null;
        String type = null;
        String Description = null;
        String CODE = null;
        int Stock = 0;
        Vector<Product> productData = new Vector();

        String query = "SELECT * FROM PRODUCT";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productId = (rs.getInt(1));
                name = (rs.getString(2));
                type = (rs.getString(3));
                Description = (rs.getString(4));
                CODE = (rs.getString(5));
                Stock = (rs.getInt(6));
                
                Product tempProduct = new Product();
                
                tempProduct.setId(productId);
                tempProduct.setProdName(name);
                tempProduct.setProdType(type);
                tempProduct.setProdDescription(Description);
                tempProduct.setCODE(CODE);
                tempProduct.setStock(Stock);
                System.out.println(productId + name + type+ CODE + Stock);
                productData.add(tempProduct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return productData;

    }
    
    public HashMap getAllProductsinHM() {
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int productId = 0;
        String name = null;
        String type = null;
        String Description = null;
        String CODE = null;
        HashMap<String, Product> products = new HashMap();
    
        String query = "SELECT * FROM PRODUCT";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            int i = 1;
            while (rs.next()) {
                productId = (rs.getInt(1));
                name = (rs.getString(2));
                type = (rs.getString(3));
                Description = (rs.getString(4));
                CODE = (rs.getString(5));
                System.out.println(productId + name);
                
                Product tempProduct = new Product();                
                tempProduct.setId(productId);
                tempProduct.setProdName(name);
                tempProduct.setProdType(type);
                tempProduct.setProdDescription(Description);
                tempProduct.setCODE(CODE);
  
                
                String num = String.valueOf(i);
                i++;
                products.put (num,tempProduct);
                System.out.println(num + tempProduct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        
        
        return products;
    }
    
    public void updateProduct(Product newProduct){
        String stmtUpdateUser = "UPDATE PRODUCT "
                + "SET NAME = '" + newProduct.getProdName() + "', TYPE = '" + newProduct.getProdType() + "', LONG_DESCRIPTION= '" + newProduct.getProdDescription() + "', CODE= '" + newProduct.getCODE() + "', STOCK=" + newProduct.getStock() + " "
                + "WHERE PRODUCT_ID= "+ newProduct.getId()+"";
        
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
    
    public void deleteProduct(Product newProduct){
        String stmtUpdateUser = "Delete from PRODUCT WHERE PRODUCT_ID= "+ newProduct.getId();
        
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
    
 
    
    public void insertProduct(Product newProduct){
        String stmtNewUser = "INSERT INTO PRODUCT(NAME,TYPE,LONG_DESCRIPTION,CODE,STOCK)" +
        "VALUES('" + newProduct.getProdName() + "', '" + newProduct.getProdType() + "', '" + newProduct.getProdDescription() + "', '" + newProduct.getCODE() + "'," + newProduct.getStock() + ")";
  
    //String stmtNewUser = "INSERT INTO USERDATA(EMAIL,PASSWORD,FNAME,LNAME,USERTYPE, EIRCODE)\n VALUES('" + newUser.getEmail() + "', '" + newUser.getPassword() + "', '" + newUser.getFirstName() + "', '" + newUser.getLastName() + "','" + newUser.getUserType() + ",'" + newUser.getEirCode() + "')";
        DBManager dmbgr = new DBManager();
        Statement currentStatement = null;
        Connection con = dmbgr.getConnection();
        try {
            // Execute statement
            currentStatement = con.createStatement();
            currentStatement.execute(stmtNewUser);
        } catch (SQLException sqlExcept) {
            logger.log(Level.SEVERE, null, sqlExcept);
        }
    }
    
}
