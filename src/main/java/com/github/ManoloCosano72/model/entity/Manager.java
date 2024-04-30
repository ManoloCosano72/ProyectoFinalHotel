package com.github.ManoloCosano72.model.entity;

import java.util.Objects;

public class Manager extends User{
    private String codUser;

    public Manager(String name, String username, String mail, String password, String codUser) {
        super(name, username, mail, password);
        this.codUser = codUser;
    }

    public Manager(String codUser) {
        this.codUser = codUser;
    }

    public String getCodUser() {
        return codUser;
    }

    public void setCodUser(String codUser) {
        this.codUser = codUser;
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
            Manager manager = (Manager) obj;
            return Objects.equals(codUser, manager.codUser);
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUser);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "codUser='" + codUser + '\'' +
                '}';
    }
}
