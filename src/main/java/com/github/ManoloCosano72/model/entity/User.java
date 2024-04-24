package com.github.ManoloCosano72.model.entity;

public class User {
    protected String name;
    protected String username;
    protected String password;
    protected String mail;

    public User(String name, String username, String password, String mail) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public User() {
    }
}
