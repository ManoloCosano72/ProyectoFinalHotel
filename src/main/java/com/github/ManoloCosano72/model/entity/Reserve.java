package com.github.ManoloCosano72.model.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Reserve {
    private int codReserve;
    private Date date;
    private Room codRoom;
    private List<Client> clients;

    public Reserve(Date date, Room codRoom, List<Client> clients) {
        this.date = date;
        this.codRoom = codRoom;
        this.clients = clients;
    }

    public Reserve() {
    }

    public int getCodReserve() {
        return codReserve;
    }

    public void setCodReserve(int codReserve) {
        this.codReserve = codReserve;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getCodRoom() {
        return codRoom;
    }

    public void setCodRoom(Room codRoom) {
        this.codRoom = codRoom;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
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
        return Objects.hash(codReserve,date,codRoom, clients);
    }

    @Override
    public String toString() {
        return "Reserve[" +
                "codReserve = " + codReserve +
                ", date = " + date +
                ", codRoom = " + codRoom +
                ", clients = " + clients +
                ']';
    }
}
