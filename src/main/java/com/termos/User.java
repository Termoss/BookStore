package com.termos;


import java.sql.Date;

public class User {

    private int user_id;
    private String firstName;
    private String surName;
    private String city;
    private int tel;
    private Date date_add;
    private String login;
    private String pass;
    private String email;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Date getDate_add() {
        return date_add;
    }

    public void setDate_add(Date date_add) {
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

    public User(int user_id, String firstName, String surName, String city, int tel, Date date_add, String login, String pass, String email) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.surName = surName;
        this.city = city;
        this.tel = tel;
        this.date_add = date_add;
        this.login = login;
        this.pass = pass;
        this.email = email;


    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", city='" + city + '\'' +
                ", tel=" + tel +
                ", date_add=" + date_add +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}