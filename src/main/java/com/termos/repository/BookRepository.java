package com.termos.repository;

import com.termos.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class BookRepository {

    public List<Book> findBooks()  {
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


    public Book findBook(@PathVariable String id) {
        Book book = null;
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "select * from books where book_id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            book= mapBook(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  book;
    }


    public Book createBook(@RequestBody Book book) {

        Connection connection = null;

        try {
            connection = DatabaseManager.connectToDatabase();

            String sql = "INSERT INTO books(book_id, title, author,  price, description, release_date) VALUES(?,?,?,?,?,?);";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getDescription());
            preparedStatement.setDate(6, book.getReleaseDate());
            int resultSet = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return null;
    }


    public Book updateBook(@PathVariable String id,@RequestBody Book book) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql =  "update  books set title=?, author=?,  price=?, description=?, release_date=? where book_id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setString(4, book.getDescription());
            preparedStatement.setDate(5,  book.getReleaseDate());
            preparedStatement.setString(6, id);
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public @DeleteMapping("/books/{id}")
    Book deleteBook(@PathVariable String id) {
        try {
            Connection connection = DatabaseManager.connectToDatabase();
            String sql = "DELETE from books where book_id=?";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

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
                rslt.getDate("release_date"));
    }
}
