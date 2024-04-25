package com.github.ManoloCosano72.model.entity;

public class ClientUser extends User{
    private String codCUser;

    public ClientUser(String name, String username, String mail, String password, String codCUser) {
        super(name, username, mail, password);
        this.codCUser = codCUser;
    }

    public ClientUser(String codCUser) {
        this.codCUser = codCUser;
    }

    public ClientUser() {
    }

    public String getCodCUser() {
        return codCUser;
    }

    public void setCodCUser(String codCUser) {
        this.codCUser = codCUser;
    }
}
