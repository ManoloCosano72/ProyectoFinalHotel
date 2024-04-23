package com.github.ManoloCosano72.model.entity;

public class User {
    private String name;
    private String username;
    private String password;
    private String mail;

    public User(String name, String username, String password, String mail) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }
}
