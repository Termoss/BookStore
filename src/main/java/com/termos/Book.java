package com.termos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Book {
    private String bookid;
    private String title;
    private String author;
    private int price;
    private String description;
    private String rdate;

    public Book(String bookid, String title, String author, int price, String description, String rdate) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.rdate = rdate;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid='" + bookid + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", rdate='" + rdate + '\'' +
                '}';
    }
}
