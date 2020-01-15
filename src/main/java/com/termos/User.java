package com.termos;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class User {
    private String id;
    private String city;
    private String fname;
    private String sname;
    private int user_tel;
    private String date_add;
    private String login;
    private String pass;
    private String email;

    public User(String id, String city, String fname, String sname, int user_tel, String date_add, String login, String pass, String email) {
        this.id = id;
        this.city = city;
        this.fname = fname;
        this.sname = sname;
        this.user_tel = user_tel;
        this.date_add = date_add;
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", user_tel=" + user_tel +
                ", date_add='" + date_add + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}