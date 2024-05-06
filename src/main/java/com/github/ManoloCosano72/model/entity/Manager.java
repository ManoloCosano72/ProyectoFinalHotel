package com.github.ManoloCosano72.model.entity;

public class Manager extends User{
    public Manager(String dni, String name, String surnames, String phone, String mail, String password, int admin) {
        super(dni, name, surnames, phone, mail, password, admin);
    }

    public Manager() {
    }
}
