package com.github.ManoloCosano72.model.entity;

import java.util.Date;
import java.util.Objects;

public class Reserve {
    private String codReserve;
    private Date date;
    private String codRoom;
    private Client clients;

    public Reserve(String codReserve, Date date, String codRoom, Client clients) {
        this.codReserve = codReserve;
        this.date = date;
        this.codRoom = codRoom;
        this.clients = clients;
    }

    public Reserve() {
    }

    public String getCodReserve() {
        return codReserve;
    }

    public void setCodReserve(String codReserve) {
        this.codReserve = codReserve;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCodRoom() {
        return codRoom;
    }

    public void setCodRoom(String codRoom) {
        this.codRoom = codRoom;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            isEquals = false;
        } else {
            Reserve reserve = (Reserve) obj;
            return Objects.equals(codReserve, reserve.codReserve);
        }
        return isEquals;

    }

    @Override
    public int hashCode() {
        return Objects.hash(codReserve);
    }

    @Override
    public String toString() {
        return "Reserve[" +
                "codReserve = " + codReserve +
                "date = " + date +
                "codRoom = " + codRoom +
                "clients = " + clients +
                ']';
    }
}
