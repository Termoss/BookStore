package com.termos.controller;

import com.termos.repository.BookRepository;
import com.termos.repository.DatabaseManager;
import com.termos.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
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
@Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    List<Book> findBooks()  {
        return bookRepository.findBooks();

    }
    @GetMapping("/books/{id}")
    Book findBook(@PathVariable String id) {
        return  bookRepository.findBook(id);
    }
    @PostMapping("/books")
    public Book createUser(@RequestBody Book book) {
        return bookRepository.createBook(book);
    }
    @PutMapping("/books/{id}")
    Book updateBook(@PathVariable String id,@RequestBody Book book) {
        return bookRepository.updateBook(id,book);
    }
    @DeleteMapping("/books/{id}")
    Book deleteBook(@PathVariable String id) {
        return bookRepository.deleteBook(id);
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




