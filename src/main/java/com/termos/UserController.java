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

            String sql = String.format("INSERT INTO users(id, imie, nazwisko, mail ) VALUES('123', '%s', '%s', 'dawidos@wp.pl');",
                    user.getName(), user.getSurName());

            connection.prepareStatement(sql).execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"),
                rs.getString("imie"),
                rs.getString("nazwisko"),
                rs.getString("sex"),
                rs.getInt("age"));
    }

}
