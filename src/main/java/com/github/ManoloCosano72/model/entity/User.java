package com.github.ManoloCosano72.model.entity;

import com.github.ManoloCosano72.model.entity.enums.Rank;

import java.util.Objects;

public class User {
    protected String name;
    protected String username;
    protected String password;
    protected String mail;
    protected Rank rank;

    public User(String name, String username, String password, String mail, Rank rank) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.rank = rank;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
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
            return Objects.equals(username, user.username);
        }
        return isEquals;
    }


    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name +
                ", username='" + username +
                ", password='" + password +
                ", mail='" + mail +
                ", rank=" + rank +
                '}';
    }
}
