package com.github.ManoloCosano72.model.entity;

import com.github.ManoloCosano72.model.entity.enums.Rank;

import java.util.Objects;

public class Manager extends User{
    private String CodManager;

    public Manager(String name, String username, String password, String mail, Rank rank, String codManager) {
        super(name, username, password, mail, rank);
    }

    public Manager(String codManager) {
        CodManager = codManager;
    }

    public Manager() {
    }

    public String getCodManager() {
        return CodManager;
    }

    public void setCodManager(String codManager) {
        CodManager = codManager;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            isEquals = true;
        }
        else if (!super.equals(obj)){
            isEquals = false;
        }else{
            Manager manager = (Manager) obj;
            return Objects.equals(CodManager, manager.CodManager);
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.username, super.password, CodManager);
    }

    @Override
    public String toString() {
        return "Manager[" +
                "CodManager = " + CodManager +
                ']';
    }
}
