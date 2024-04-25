package com.github.ManoloCosano72.model.entity;

import java.util.Objects;

public class User {
    private String name;
    private String username;
    private String mail;
    private String password;

    public User(String name, String username, String mail, String password) {
        this.name = name;
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj){
            isEquals =  true;
        }
        else if (obj == null || getClass() != obj.getClass()){
            isEquals = false;
        }else{
            User user = (User) obj;
            return Objects.equals(username, user.username);
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,password);
    }

    @Override
    public String toString() {
        return "User[" +
                "name = " + name +
                ", username = " + username +
                ", mail = " + mail +
                ", password = " + password +
                ']';
    }
}
