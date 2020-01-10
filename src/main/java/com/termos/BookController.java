package com.termos;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;

@RestController
public class BookController {

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


        //post book
        @PostMapping("/books")
        public Book createBook(@RequestBody Book book) {
            Connection connection = null;
            try {
                connection = DatabaseManager.connectToDatabase();

                String sql = String.format("INSERT INTO books(id, name, author,releaseday , price ) VALUES('123', 'LOTR', 'JRR Tolkien', '1954', 'Fantasy', '101');",
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
                    rslt.getDate("releaseday"),
                    rslt.getInt("price"),
                    rslt.getString("description"));
        }

    }


