package com.github.ManoloCosano72.model.entity;

public class Manager extends User{
    private String CodManager;

    public Manager(String name, String username, String password, String mail) {
        super(name, username, password, mail);
    }

    public Manager(String name, String username, String password, String mail, String codManager) {
        super(name, username, password, mail);
    }

    public Manager(String codManager) {
        CodManager = codManager;
    }

    public Manager() {
    }

    public String getCodManager() {
        return CodManager;
    }

    public void setCodManager(String codManager) {
        CodManager = codManager;
    }

    @Override
    public String toString() {
        return "Manager[" +
                "CodManager = " + CodManager +
                ", name = " + name +
                ", username = " + username +
                ", password = " + password +
                ", mail = " + mail +
                ']';
    }
}
