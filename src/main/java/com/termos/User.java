package com.termos;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {
    private String userId;
    private String city;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("surnname")
    private String surnName;
    @JsonProperty("usertel")
    private int userTel;
    @JsonProperty("addDate")
    private Timestamp regDate;
    private String login;
    private String pass;
    private String email;

    public User(String userId, String city, String firstName, String surnName, int userTel, Timestamp regDate, String login, String pass, String email) {
        this.userId = userId;
        this.city = city;
        this.firstName = firstName;
        this.surnName = surnName;
        this.userTel = userTel;
        this.regDate = regDate;
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurnName() {
        return surnName;
    }

    public void setSurnName(String surnName) {
        this.surnName = surnName;
    }

    public int getUserTel() {
        return userTel;
    }

    public void setUserTel(int userTel) {
        this.userTel = userTel;
    }

    public Timestamp getRegDate() {
        LocalDateTime ldt = LocalDateTime.now();
        Timestamp t = Timestamp.valueOf(ldt);
        return t;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
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
                "userId='" + userId + '\'' +
                ", city='" + city + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surnName='" + surnName + '\'' +
                ", userTel=" + userTel +
                ", regDate=" + regDate +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}