package com.termos.controller;

import com.termos.repository.DatabaseManager;
import com.termos.model.Book;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class BookController {


    @GetMapping("/books")
    List<Book> findAll()  {
        List<Book> list = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            ResultSet rs = connection.prepareStatement("select * from books").executeQuery();
            while (rs.next()) {
                list.add(mapBook(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    @GetMapping("/books/{id}")
    Book findA(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            ResultSet rs = connection.prepareStatement("select * from books where book_id='"+id+"'").executeQuery();
            rs.next();
            return mapBook(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @PostMapping("/books")
    public Book createUser(@RequestBody Book book) {

        Connection connection = null;

        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = "INSERT INTO books(book_id, title, author,  price, description, rdate) VALUES(?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getDescription());
            preparedStatement.setString(6, book.getrDate());
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
    @PutMapping("/books/{id}")
    Book updateBook(@PathVariable String id,@RequestBody Book book) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql =  "update  books set title=?, author=?,  price=?, description=?, rdate=? where book_id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, book.getTitle());
            preparedStatement1.setString(2, book.getAuthor());
            preparedStatement1.setDouble(3, book.getPrice());
            preparedStatement1.setString(4, book.getDescription());
            preparedStatement1.setString(5, book.getrDate());
            preparedStatement1.setString(6, id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @DeleteMapping("/books/{id}")
    Book deleteBook(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "DELETE from books where book_id=?";
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement(sql);
            preparedStatement1.setString(1, id);
            int rowsAffected = preparedStatement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private Book mapBook(ResultSet rslt) throws SQLException {
        return new Book(rslt.getString("book_id"),
                rslt.getString("title"),
                rslt.getString("author"),
                rslt.getInt("price"),
                rslt.getString("description"),
                rslt.getString("rdate"));
    }

}




