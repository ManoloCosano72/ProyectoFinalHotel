package com.github.ManoloCosano72.model.entity;

import java.util.List;

public class Client extends User{
    private String Dni;
    private String surnames;
    private String phone;
    private List<Reserve> reserves;


    public Client(String name, String username, String password, String mail) {
        super(name, username, password, mail);
    }
}
