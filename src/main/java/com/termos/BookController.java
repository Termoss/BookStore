package com.termos;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;

@RestController
public class BookController {

    // Find
    // Find
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

            String sql = String.format("INSERT INTO books(book_id, title, author,  price, description, rdate) VALUES('%s','%s','%s','%d','%s','%s');",
                    UUID.randomUUID().toString(),book.getTitle(),book.getAuthor(),book.getPrice(),book.getDescription(),book.getRdate());
            connection.prepareStatement(sql).execute();
            System.out.println(sql);
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




