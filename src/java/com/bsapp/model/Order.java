/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.model;

/**
 *
 * @author Colm
 */
public class Order {
    private long RECORD_ID;

    public long getRECORD_ID() {
        return RECORD_ID;
    }

    public void setRECORD_ID(long RECORD_ID) {
        this.RECORD_ID = RECORD_ID;
    }
    private long ORDER_ID;

    public long getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(long ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public long getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(long CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }
    private long CUSTOMER_ID;
    private int SHIPPING_ID;
    private long PRODUCT_ID;

    public long getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(long PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }
    private int QUANTITY;
    private int EXTERNALPAYMENT_ID;



    public void setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }



    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getSHIPPING_ID() {
        return SHIPPING_ID;
    }

    public void setSHIPPING_ID(int SHIPPING_ID) {
        this.SHIPPING_ID = SHIPPING_ID;
    }

   

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public int getEXTERNALPAYMENT_ID() {
        return EXTERNALPAYMENT_ID;
    }

    public void setEXTERNALPAYMENT_ID(int EXTERNALPAYMENT_ID) {
        this.EXTERNALPAYMENT_ID = EXTERNALPAYMENT_ID;
    }
    
    
    
}
