package com.github.ManoloCosano72.model.entity;

public class Manager extends User{
    private String CodManager;

    public Manager(String name, String username, String password, String mail) {
        super(name, username, password, mail);
    }

    public Manager(String name, String username, String password, String mail, String codManager) {
        super(name, username, password, mail);
        this.CodManager = codManager;
    }
}
