package com.termos;


import javax.persistence.Id;
import java.sql.Date;

public class User {
    @Id
    private int user_id;
    private String name;
    private String surN;
    private String city;
    private int user_tel;
    private String date_add;
    private String login;
    private String pass;
    private String email;

    public User(int user_id, String name, String surN, String city, int user_tel, String date_add, String login, String pass, String email) {
        this.user_id = user_id;
        this.name = name;
        this.surN = surN;
        this.city = city;
        this.user_tel = user_tel;
        this.date_add = date_add;
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurN() {
        return surN;
    }

    public void setSurN(String surN) {
        this.surN = surN;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(int user_tel) {
        this.user_tel = user_tel;
    }

    public String getDate_add() {
        return date_add;
    }

    public void setDate_add(String date_add) {
        this.date_add = date_add;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", surN='" + surN + '\'' +
                ", city='" + city + '\'' +
                ", user_tel=" + user_tel +
                ", date_add='" + date_add + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}