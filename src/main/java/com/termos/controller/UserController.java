package com.termos.controller;

import com.termos.config.UserDTO;
import com.termos.model.User;
import com.termos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@RestController
public class UserController {

    private DataSource dataSource;
    private UserRepository userRepository;

    @Autowired
    public UserController(DataSource dataSource, UserRepository userRepository) {
        this.dataSource = dataSource;
        this.userRepository = userRepository;
    }

    // FindAll
    @GetMapping("/users")
    ResponseEntity <List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAllUsers());
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
    @PutMapping("/users/{id}")
    User updateUser(@PathVariable String id,@RequestBody User user){
        return userRepository.updateUser(id,user);
    }


    //delete
    @DeleteMapping("/users/{id}")
    User deleteUser(@PathVariable String id) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "DELETE from users where user_id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //register
    @GetMapping("users/registration")
    String registrationForm(WebRequest webRequest, Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user",userDTO);
        return "registration";
    }

    private User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getString("id"),
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
