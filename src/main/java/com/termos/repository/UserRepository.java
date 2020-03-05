package com.termos.repository;

import com.termos.TimeUtils;
import com.termos.model.Book;
import com.termos.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserRepository {

    public List<User> findAllUsers()  {
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
   public User findUser(@PathVariable String id) {
        User user = null;
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql="select * from users where user_id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = mapUser(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }



    public User createUser(@RequestBody User user) {
        Connection connection = null;

        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = "INSERT INTO users(user_id, city, first_name, sur_name, user_tel, reg_date, login, pass, email,authorities) VALUES(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, user.getCity());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSurName());
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
     public User updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql =  "update user set city=?, first_name=?, sur_name=?, user_tel=?, reg_date=?, login=?, pass=?, email=?,authorities=? where id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getCity());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getSurName());
            preparedStatement.setInt(4, user.getUserTel());
            preparedStatement.setTimestamp(5, TimeUtils.NowTimeStamp());
            preparedStatement.setString(6, user.getLogin());
            preparedStatement.setString(7, user.getPass());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setString(9, user.getAuthorities());
            preparedStatement.setString(10,id);
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User deleteUser(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "DELETE from user where id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getString("user_id"),
                rs.getString("city"),
                rs.getString("first_name"),
                rs.getString("sur_name"),
                rs.getInt("user_tel"),
                rs.getTimestamp("reg_date"),
                rs.getString("login"),
                rs.getString("pass"),
                rs.getString("email"),
                rs.getString("authorities"));
    }
}
