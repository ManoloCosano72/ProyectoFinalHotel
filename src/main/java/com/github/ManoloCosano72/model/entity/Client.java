package com.github.ManoloCosano72.model.entity;


import java.util.List;
import java.util.Objects;

public class Client{
    private String dni;
    private String name;
    private String surnames;
    private String phone;
    private String mail;


    public Client(String dni, String name, String surnames, String phone, String mail) {
        this.dni = dni;
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.mail = mail;

    }

    public Client() {
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj){
            isEquals = true;
        }
       else if (obj == null || getClass() != obj.getClass()){
            isEquals =  false;
        }else{
            Client client = (Client) obj;
            return Objects.equals(dni, client.dni);
        }
       return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Client[" +
                "dni = " + dni +
                ", name = " + name +
                ", surnames = " + surnames +
                ", phone = " + phone +
                ", mail = " + mail +
                ']';
    }
}
