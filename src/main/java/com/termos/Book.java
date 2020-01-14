package com.termos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

    public class Book {

        private long id;
        private String title;
        private String author;
        private String description;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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

        public Date getReleaseday() {
            return releaseday;
        }

        public void setReleaseday(Date releaseday) {
            this.releaseday = releaseday;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private Date releaseday;
        private double price;

        public Book(long id, String title, String author, Date releaseday, double price, String description) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.releaseday = releaseday;
            this.price = price;
            this.description = description;
        }



        @Override
public String toString() {
        return "Book{" +
                "id = " + id +
                "title = " + title +
                ", author = " + author +'\'' +
                ", release day = "+ releaseday + '\'' +
                ", price = " + price +
                ", description = " + description + '}';

    }


}
