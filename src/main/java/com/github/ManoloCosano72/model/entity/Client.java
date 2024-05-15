package com.github.ManoloCosano72.model.entity;

import java.util.List;

public class Client extends User{
    private List<Reserve> reserves;
    public Client(String dni, String name, String surnames, String phone, String mail, String password, int admin) {
        super(dni, name, surnames, phone, mail, password, admin);
    }

    public Client(List<Reserve> reserves) {
        this.reserves = reserves;
    }

    public Client() {
    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }


    public int getAdmin() {
        return admin;
    }
}
