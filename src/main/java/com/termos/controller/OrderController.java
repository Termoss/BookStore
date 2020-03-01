package com.termos.controller;

import com.termos.TimeUtils;
import com.termos.model.Book;
import com.termos.repository.DatabaseManager;
import com.termos.model.Order;
import com.termos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private OrderRepository orderRepository;

    // FindAll
    @GetMapping("/orders")
    List<Order> findAll() {
        return orderRepository.findAll();
    }

    //findAll OK
    @GetMapping("/orders/{id}")
    Order findA(@PathVariable String id) {
        return orderRepository.findA(id);
    }

    //create OK
    @PostMapping("/orders")
    public Order createOrders(@RequestBody Order order){
        return orderRepository.createOrders(order);
    }

   //update
    @PutMapping("/orders/{id}")
    Order updateOrder(@PathVariable String id,@RequestBody Order order){
        return orderRepository.updateOrder(id,order);
    }

    //delete
    @DeleteMapping("/order/{id}")
    public Order deleteOrders(@PathVariable String id){
        return orderRepository.deleteOrder(id);
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
