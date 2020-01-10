package com.termos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    // Find
    @GetMapping("/users")
    List<User> findAll() {
        List<User> list = List.of();
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

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        Connection connection = null;
        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = String.format("INSERT INTO users(user_id, firstname, secondname, city, tel, date_add, login, pass, email ) VALUES('123', '%s', '%s', '');",
                    user.getName(), user.getSurName());

            connection.prepareStatement(sql).execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getInt("user_id"),
                rs.getString("firstname"),
                rs.getString("secondname"),
                rs.getString("city"),
                rs.getInt("tel"),
                rs.getDate("date_add"),
                rs.getString("login"),
                rs.getString("pass"),
                rs.getString("email"));
    }

}
