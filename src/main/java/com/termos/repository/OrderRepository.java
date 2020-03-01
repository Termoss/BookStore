package com.termos.repository;

import com.termos.TimeUtils;
import com.termos.model.Book;
import com.termos.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class OrderRepository {

    //findAll
     public List<Order> findAll() {
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




        //findA
        public Order findA(@PathVariable String id) {
            try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "select * from order where order_id=?";
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet rst = preparedStatement.executeQuery();
            rst.next();
            return mapOrder(rst);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

      //create
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
    public Order updateOrder(@PathVariable String id, @RequestBody Order orders) {
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

     public Order deleteOrder(@PathVariable String id) {
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















    private Order mapOrder(ResultSet rst) throws SQLException {//metoda zwraca order ktora wyciegnela z wnetrza rstset
        return new Order(rst.getString("order_id"),
                rst.getTimestamp("order_date"),
                rst.getInt("quantity"),
                rst.getDouble("price"),
                rst.getString("status"),
                rst.getString("invoice"));
    }
}



