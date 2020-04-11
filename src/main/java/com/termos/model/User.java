package com.termos.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.termos.config.PasswordMatches;
import com.termos.config.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Timestamp;

public class User {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("city")
    private String city;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("sur_name")
    private String surName;
    @JsonProperty("user_tel")
    private int userTel;
    @JsonProperty("reg_date")
    private Timestamp regDate;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
    @JsonProperty("email")
    private String email;
    @JsonProperty("authorities")
    private String authorities;

    public User() {
    }

    public User(String userId, String city, String firstName, String surName, int userTel, Timestamp regDate, String login, String password, String email, String authorities) {
        this.userId = userId;
        this.city = city;
        this.firstName = firstName;
        this.surName = surName;
        this.userTel = userTel;
        this.regDate = regDate;
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", authorities='" + authorities + '\'' +
                '}';
    }


}