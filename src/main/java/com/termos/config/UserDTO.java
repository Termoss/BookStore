package com.termos.config;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Timestamp;

public class UserDTO {

    @NotNull
    @NotEmpty
    private String userId;


    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String surName;

    @NotNull
    @NotEmpty
    private int userTel;

    @NotNull
    @NotEmpty
    private Timestamp regDate;

    @NotNull
    @NotEmpty
    private String login;

    @PasswordValidator
    @NotNull
    @NotEmpty
    private String pass;
    private String matchingPassword;

    //matching password nie ma w zadnej innej klasie ani w postgresie!!!

    @EmailValidation
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String authorities;

    public String getUserId() {
        return userId;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
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
}
