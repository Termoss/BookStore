package com.termos.controller;

import com.termos.TimeUtils;
import com.termos.model.Book;
import com.termos.repository.BookRepository;
import com.termos.repository.DatabaseManager;
import com.termos.model.User;
import com.termos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Find
    @GetMapping("/users")
    List<User> findAllUsers()  {
        return userRepository.findAllUsers();
    }
    @GetMapping("/user/{id}")
    User findUser(@PathVariable String id) {
        return userRepository.findUser(id);
    }
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.createUser(user);
    }
    @PutMapping("/user/{id}")
    User updateUser(@PathVariable String id, @RequestBody User user) {
        return userRepository.updateUser(id,user);
    }
    @DeleteMapping("/user/{id}")
    User deleteUser(@PathVariable String id) {
        return userRepository.deleteUser(id);

    }
}
