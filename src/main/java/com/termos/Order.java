package com.termos;

import java.time.LocalDate;

public class Order{
    private String order_id;
    private String order_date;
    private int quantity;
    private int  price;
    private String status;
    private String invoice;

    public Order(String order_id, String order_date, int quantity, int price, String status, String invoice) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.invoice = invoice;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
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
                "order_id='" + order_id + '\'' +
                ", order_date='" + order_date + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}
