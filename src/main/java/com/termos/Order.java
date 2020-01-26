package com.termos;

import java.time.LocalDate;

public class Order{
    private String orderID;
    private String orderDate;
    private int quantity;
    private int  price;
    private String status;
    private String invoice;

    public Order(String orderID, String orderDate, int quantity, int price, String status, String invoice) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.invoice = invoice;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
                "orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}
