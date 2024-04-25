package com.github.ManoloCosano72.model.entity;

import com.github.ManoloCosano72.model.entity.enums.Rank;

import java.util.List;
import java.util.Objects;

public class Client extends User{
    private String Dni;
    private String surnames;
    private String phone;
    private List<Reserve> reserves;


    public Client(String name, String username, String password, String mail, Rank rank, String dni, String surnames, String phone, List<Reserve> reserves) {
        super(name, username, password, mail, rank);
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
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj){
            isEquals = true;
        }
        else if (obj == null || getClass() != obj.getClass()){
            isEquals = false;
        }else{
            Client client = (Client) obj;
            return Objects.equals(Dni, client.Dni);
        }
        return isEquals;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.username, super.password, Dni);
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
