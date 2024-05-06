package com.github.ManoloCosano72.model.entity;

import java.util.Objects;

public class User {
    private String dni;
    private String name;
    private String surnames;
    private String phone;
    private String mail;
    private String password;
    private int admin;

    public User(String dni, String name, String surnames, String phone, String mail, String password, int admin) {
        this.dni = dni;
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.mail = mail;
        this.password = password;
        this.admin = admin;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
    public int Admin(){
        return 1;
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
            User user = (User) obj;
            return Objects.equals(dni, user.dni)&& Objects.equals(mail, user.mail);
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, name, surnames, phone, mail, password, admin);
    }

    @Override
    public String toString() {
        return "User[" +
                "dni = " + dni +
                ", name = " + name +
                ", surnames = " + surnames +
                ", phone = " + phone +
                ", mail = " + mail +
                ", password = " + password +
                ", isAdmin = " + admin +
                ']';
    }
}


