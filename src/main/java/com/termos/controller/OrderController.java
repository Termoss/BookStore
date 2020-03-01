package com.termos.controller;

import com.termos.TimeUtils;
import com.termos.model.Book;
import com.termos.repository.DatabaseManager;
import com.termos.model.Order;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    // Find
    @GetMapping("/orders")
    List<Order> findAll() {
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
    //findAll
    @GetMapping("/orders/{id}")
    Order findA(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            ResultSet rs = connection.prepareStatement("select * from orders where order_id='" + id + "'").executeQuery();
            rs.next();
            return mapOrder(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    //create
    @PostMapping("/orders")
    public Order createOrders(@RequestBody Order orders) {
        Connection connection = null;
        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = "INSERT INTO orders(order_id, order_date, quantity, price, status, invoice) VALUES(?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setTimestamp(2, TimeUtils.NowTimeStamp());
            preparedStatement.setInt(3, orders.getQuantity());
            preparedStatement.setDouble(4, orders.getPrice());
            preparedStatement.setString(5, orders.getStatus());
            preparedStatement.setString(6, orders.getInvoice());

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

   //update
    @PutMapping("/orders/{id}")
    Book updateOrder(@PathVariable String id, @RequestBody Order orders) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "update  order set  quantity=?, price=?, status=?, invoice=? where id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setInt(1, orders.getQuantity());
            preparedStatement1.setDouble(2, orders.getPrice());
            preparedStatement1.setString(3, orders.getStatus());
            preparedStatement1.setString(4, orders.getInvoice());
            preparedStatement1.setString(5,id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //delete
    @DeleteMapping("/order/{id}")
    Book deleteBook(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "DELETE from order where id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


        private Order mapOrder(ResultSet rst) throws SQLException {
        return new Order(rst.getString("order_id"),
                rst.getTimestamp("order_date"),
                rst.getInt("quantity"),
                rst.getDouble("price"),
                rst.getString("status"),
                rst.getString("invoice"));
    }

}
