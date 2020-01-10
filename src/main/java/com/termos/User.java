package com.termos;


import java.sql.Date;

public class User {

    private int id;
    private String name;
    private String surName;
    private String sex;
    private int age;

    public User(int id, String name, String surName, String sex, int age, Date date_add, String login, String pass, String email) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
