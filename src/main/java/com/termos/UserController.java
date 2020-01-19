package com.termos;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    //komentarz 1
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        Connection connection = null;

        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = String.format("INSERT INTO users(id, city, fname, sname, user_tel, date_add, login, pass, email) VALUES('%s','%s' ,'%s','%s',%d, '%s', '%s', '%s', '%s');",
                    UUID.randomUUID().toString(),user.getCity(),user.getFname(),user.getSname(),user.getUser_tel(),user.getDate_add(),user.getLogin(),user.getPass(),user.getEmail());
            System.out.println(sql);
            connection.prepareStatement(sql).execute();
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
                rs.getString("date_add"),
                rs.getString("login"),
                rs.getString("pass"),
                rs.getString("email"));
    }

}
