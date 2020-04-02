package com.termos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Order{
    @JsonProperty("orderid")
    private String orderID;
    @JsonProperty("orderdate")
    private Timestamp orderDate;
    private int quantity;
    private double  price;
    private String status;
    private String invoice;
    private String bookId;
    private String userId;

    public Order(String orderID, Timestamp orderDate, int quantity, double price, String status, String invoice, String bookId, String userId) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.invoice = invoice;
        this.bookId = bookId;
        this.userId = userId;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }

 //this.orderID = orderID;
    //     this.orderDate = orderDate;
      //   this.quantity = quantity;
        // this.price = price;
         //this.status = status;
        // this.invoice = invoice;
         //this.bookId = bookId;
         //this.userId = userId;
         }