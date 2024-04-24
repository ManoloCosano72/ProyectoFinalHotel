package com.github.ManoloCosano72.model.entity;

import java.util.List;
import java.util.Objects;

public class Client extends User{
    private String Dni;
    private String surnames;
    private String phone;
    private List<Reserve> reserves;


    public Client(String name, String username, String password, String mail) {
        super(name, username, password, mail);
    }

    public Client() {
    }

    public Client(String dni, String surnames, String phone, List<Reserve> reserves) {
        Dni = dni;
        this.surnames = surnames;
        this.phone = phone;
        this.reserves = reserves;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }

    @Override
    public boolean equals(Object o) {
        boolean isEquals;
        if (this == o){
            isEquals = true;
        }
        else if (o == null || getClass() != o.getClass()){
            isEquals = false;
        }else{
            Client client = (Client) o;
            return Objects.equals(Dni, client.Dni);
        }
        return isEquals;
    }


    @Override
    public int hashCode() {
        return Objects.hash(Dni, surnames, phone, reserves);
    }

    @Override
    public String toString() {
        return "Client[" +
                "Dni = " + Dni +
                ", surnames = " + surnames +
                ", phone = " + phone +
                ", reserves = " + reserves +
                ", name = " + name +
                ", username = " + username +
                ", password = " + password +
                ", mail = " + mail +
                ']';
    }
}
