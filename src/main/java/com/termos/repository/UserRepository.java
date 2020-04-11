package com.termos.repository;

import com.termos.TimeUtils;
import com.termos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserRepository {


    private DataSource dataSource;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepository(DataSource dataSource,PasswordEncoder passwordEncoder) {
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    //exists
    private boolean exists(String login,String email) {
        try {
            Connection connection = dataSource.getConnection();
            String sql =  "SELECT users from users where login=? AND email=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, login);
            preparedStatement1.setString(2, email);
            ResultSet rs= preparedStatement1.executeQuery();
            return rs.next();

            } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //findAll
    public List<User> findAllUsers()  {
        List<User> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            ResultSet rs = connection.prepareStatement("select * from users").executeQuery();
            while (rs.next()) {
                list.add(mapUser(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    //findbyID
    public User findUser(@PathVariable String id) {
        try {
            Connection connection = dataSource.getConnection();
            String sql="select * from users where user_id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //create
    public User createUser(@RequestBody User user) {
        Connection connection = null;
       if (exists(user.getLogin(),user.getEmail())) {
           return null;
        }
        try {
            connection = dataSource.getConnection();
            String sql = "INSERT INTO users(user_id, city, first_name, sur_name, user_tel, reg_date, login, password, email,authorities) VALUES(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(UUID.randomUUID()));
            preparedStatement.setString(2, user.getCity());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSurName());
            preparedStatement.setInt(5, user.getUserTel());
            preparedStatement.setTimestamp(6, TimeUtils.NowTimeStamp());
            preparedStatement.setString(7, user.getLogin());
            preparedStatement.setString(8, passwordEncoder.encode(user.getPassword()));
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setString(10, user.getAuthorities());

            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        user.setPassword("");
        return user;
    }


    //update

    public User updateUser(@PathVariable String id, @RequestBody User user) {
        if (exists(user.getLogin(),user.getEmail())) {
            return null;
       }
        try {
            Connection connection = dataSource.getConnection();
            String sql =  "update user set city=?, first_name=?, sur_name=?, user_tel=?, reg_date=?, login=?, password=?, email=?,authorities=? where user_id=?";
            //user id czy id
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, user.getCity());
            preparedStatement1.setString(2, user.getFirstName());
            preparedStatement1.setString(3, user.getSurName());
            preparedStatement1.setInt(4, user.getUserTel());
            preparedStatement1.setTimestamp(5, TimeUtils.NowTimeStamp());
            preparedStatement1.setString(6, user.getLogin());
            preparedStatement1.setString(7, user.getPassword());
            preparedStatement1.setString(8, user.getEmail());
            preparedStatement1.setString(9, user.getAuthorities());
            preparedStatement1.setString(10,id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    //find by email
    public User findByEmail(@PathVariable String email, @RequestBody User user) {
        try {
            Connection connection = dataSource.getConnection();
            String sql="select * from users where email=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, email);
            int rowsAffected = preparedStatement1.executeUpdate();

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
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("authorities"));
    }
}

