package com.termos.controller;

import com.termos.TimeUtils;
import com.termos.repository.DatabaseManager;
import com.termos.model.User;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {


    // Find
    @GetMapping("/users")
    List<User> findAll()  {
        List<User> list = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            ResultSet rs = connection.prepareStatement("select * from users").executeQuery();
            while (rs.next()) {
                list.add(mapUser(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    @GetMapping("/users/{id}")
    User findA(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            ResultSet rs = connection.prepareStatement("select * from users where id='"+id+"'").executeQuery();
            rs.next();
            return mapUser(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //create
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        Connection connection = null;

        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = "INSERT INTO users(id, city, fname, sname, user_tel, date_add, login, pass, email,authorities) VALUES(?,?,?,?,?,?,?,?,?,?);";
                    PreparedStatement preparedStatement =
                            connection.prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, user.getCity());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSurnName());
            preparedStatement.setInt(5, user.getUserTel());
            preparedStatement.setTimestamp(6, TimeUtils.NowTimeStamp());
            preparedStatement.setString(7, user.getLogin());
            preparedStatement.setString(8, user.getPass());
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setString(10, user.getAuthorities());

            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
    //update
    @PutMapping("/user/{id}")
    User updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql =  "update  user set city=?, fname=?, sname=?, user_tel=?, date_add=?, login=?, pass=?, email=?,authorities=? where id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, user.getCity());
            preparedStatement1.setString(2, user.getFirstName());
            preparedStatement1.setString(3, user.getSurnName());
            preparedStatement1.setInt(4, user.getUserTel());
            preparedStatement1.setTimestamp(5, TimeUtils.NowTimeStamp());
            preparedStatement1.setString(6, user.getLogin());
            preparedStatement1.setString(7, user.getPass());
            preparedStatement1.setString(8, user.getEmail());
            preparedStatement1.setString(9, user.getAuthorities());
            preparedStatement1.setString(10,id);
            int rowsAffected = preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //delete
    @DeleteMapping("/user/{id}")
    User deleteUser(@PathVariable String id) {
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
