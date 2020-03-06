package com.termos.controller;

import com.termos.TimeUtils;
import com.termos.model.Book;
import com.termos.repository.BookRepository;
import com.termos.repository.DatabaseManager;
import com.termos.model.Order;
import com.termos.repository.OrderRepository;
import com.termos.repository.UserRepository;
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
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    // FindAll
    @GetMapping("/orders")
    List<Order> findAll() {
        return orderRepository.findAll();
    }

    //findAll OK
    @GetMapping("/order/{id}")
    Order findA(@PathVariable String id) {
        return orderRepository.findA(id);
    }

    //create OK
    @PostMapping("/order")
    public Order createOrders(@RequestBody Order order) {
        return orderRepository.createOrders(order);
    }

    //update
    @PutMapping("/order/{id}")
    Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderRepository.updateOrder(id, order);
    }

    //delete
    @DeleteMapping("/order/{id}")
    public Order deleteOrders(@PathVariable String id) {
        return orderRepository.deleteOrder(id);
    }


}
