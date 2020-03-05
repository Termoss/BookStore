package com.termos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Order{
    private String orderId;
    @JsonProperty("bookid")
    private String bookId;
    @JsonProperty("userid")
    private String userId;
    @JsonProperty("orderdate")
    private Timestamp orderDate;
    private int quantity;
    private double  price;
    private String status;
    private String invoice;

    public Order(String orderId, String bookId, String userId, Timestamp orderDate, int quantity, double price, String status, String invoice) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.invoice = invoice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}
