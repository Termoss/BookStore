package com.termos;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    // Find
    @GetMapping("/orders")
    List<Order> findAll()  {
        List<Order> list = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            ResultSet rs = connection.prepareStatement("select * from orders").executeQuery();
            while (rs.next()) {
                list.add(mapOrder(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    @GetMapping("/orders/{id}")
    Order findA(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            ResultSet rs = connection.prepareStatement("select * from orders where order_id='"+id+"'").executeQuery();
            rs.next();
            return mapOrder(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @PostMapping("/orders")
    public Order createOrders(@RequestBody Order orders) {
        Connection connection = null;
        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = String.format("INSERT INTO orders(order_id, order_date, quantity, price, status, invoice) VALUES(%s,'%s',%d, '%d', '%s', '%s');",
                    UUID.randomUUID().toString() ,orders.getOrderDate(),orders.getQuantity(),orders.getPrice(),orders.getStatus(),orders.getInvoice());

            connection.prepareStatement(sql).execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    private Order mapOrder(ResultSet rst) throws SQLException {
        return new Order(rst.getString("order_id"),
                rst.getString("order_date"),
                rst.getInt("quantity"),
                rst.getInt("price"),
                rst.getString("status"),
                rst.getString("invoice"));
    }

}
