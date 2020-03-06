package com.termos.controller;

import com.termos.TimeUtils;
import com.termos.model.Book;
import com.termos.model.Order;
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


    // FindAll
    @GetMapping("/users")
    List<User> findAll() {
        return userRepository.findAllUsers();
    }

    //findbyId
    @GetMapping("/users/{id}")
    User findUser(@PathVariable String id) {
        return userRepository.findUser(id);
    }

    //create
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.createUser(user);
    }

    //update
    @PutMapping("/user/{id}")
    User updateUser(@PathVariable String id,@RequestBody User user){
        return userRepository.updateUser(id,user);
    }


    //delete
    @DeleteMapping("/user/{id}")
    Book deleteBook(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "DELETE from user where id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getString("id"),
                rs.getString("city"),
                rs.getString("fname"),
                rs.getString("sname"),
                rs.getInt("user_tel"),
                rs.getTimestamp("date_add"),
                rs.getString("login"),
                rs.getString("pass"),
                rs.getString("email"),
                rs.getString("authorities"));
    }

}
