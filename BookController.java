package com.termos;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Find
        @GetMapping("/books")
        List<Book> findAll() {
            List<Book> list = List.of();
            try {
                Connection connection = DatabaseManager.connectToDatabase();
                ResultSet rslt = connection.prepareStatement("select * from books").executeQuery();
                while (rslt.next()) {
                    list.add(mapBook(rslt));

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return list;
        }

        //find by name
        @GetMapping("books/{name}")
       public List<Book> getBookByTitle(@PathVariable String bookname){
        return bookRepository.findByName(bookname);
    }

        //post book
        @PostMapping("/books")
        public Book createBook(@RequestBody Book book) {
            Connection connection = null;
            try {
                connection = DatabaseManager.connectToDatabase();

                String sql = String.format("INSERT INTO books(id, name, author, book release day , price ) VALUES('123', 'LOTR', 'JRR Tolkien', '1954', 'Fantasy', '101');",
                        book.getId(),book.getTitle(),book.getAuthor(),book.getReleaseday(),book.getDescription(),book.getPrice());

                connection.prepareStatement(sql).execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }



        //buy a book
        //public Book buyBook(@RequestBody Book book){
        //        return orderRepository.save(book);
        //        }
        //        }
        private Book mapBook(ResultSet rslt) throws SQLException {
            return new Book(rslt.getInt("id"),
                    rslt.getString("name"),
                    rslt.getString("author"),
                    rslt.getData("releaseday"),
                    rslt.getInt("price"),
                    rslt.getString("description"));
        }

    }

}
