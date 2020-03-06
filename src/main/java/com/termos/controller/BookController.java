package com.termos.controller;

import com.termos.repository.BookRepository;
import com.termos.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {
@Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    List<Book> findBooks()  {
        return bookRepository.findBooks();

    }
    @GetMapping("/book/{id}")
    Book findBook(@PathVariable String id) {
        return  bookRepository.findBook(id);
    }
    @PostMapping("/book")
    public Book createUser(@RequestBody Book book) {
        return bookRepository.createBook(book);
    }
    @PutMapping("/book/{id}")
    Book updateBook(@PathVariable String id,@RequestBody Book book) {
        return bookRepository.updateBook(id,book);
    }
    @DeleteMapping("/book/{id}")
    Book deleteBook(@PathVariable String id) {
        return bookRepository.deleteBook(id);
    }



}


