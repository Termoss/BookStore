package com.termos.controller;

import com.termos.repository.BookRepository;
import com.termos.model.Order;
import com.termos.repository.OrderRepository;
import com.termos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/orders/{id}")
    Order findA(@PathVariable String id) {
        return orderRepository.findA(id);
    }

    //create OK
    @PostMapping("/orders")
    public Order createOrders(@RequestBody Order order) {
        return orderRepository.createOrders(order);
    }

    //update
    @PutMapping("/orders/{id}")
    Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderRepository.updateOrder(id, order);
    }

    //delete
    @DeleteMapping("/orders/{id}")
    public Order deleteOrders(@PathVariable String id) {
        return orderRepository.deleteOrder(id);
    }


}
