package com.termos.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {
    private String userId;
    private String city;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("surname")
    private String surName;
    @JsonProperty("usertel")
    private int userTel;
    @JsonProperty("regdate")
    private Timestamp regDate;
    private String login;
    private String pass;
    private String email;
    private String authorities;

    public User(String userId, String city, String firstName, String surName, int userTel, Timestamp regDate, String login, String pass, String email, String authorities) {
        this.userId = userId;
        this.city = city;
        this.firstName = firstName;
        this.surName = surName;
        this.userTel = userTel;
        this.regDate = regDate;
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.authorities = authorities;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getUserTel() {
        return userTel;
    }

    public void setUserTel(int userTel) {
        this.userTel = userTel;
    }

    public Timestamp getRegDate() {
        return regDate;
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

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", city='" + city + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", userTel=" + userTel +
                ", regDate=" + regDate +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", authorities='" + authorities + '\'' +
                '}';
    }
}