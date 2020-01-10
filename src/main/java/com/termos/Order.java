package com.termos;

import java.time.LocalDate;

public class Order {
    private int orderid;
    private LocalDate orderdate;
    private char status;
    private double  price;
    private boolean invoice;


    public Order(int orderid, LocalDate orderdate, char status, double price, boolean invoice) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.status = status;
        this.price = price;
        this.invoice = invoice;
    }


    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInvoice() {
        return invoice;
    }

    public void setInvoice(boolean invoice) {
        this.invoice = invoice;
    }
}
