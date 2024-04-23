package com.github.ManoloCosano72.model.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Reserve {
    private String codReserve;
    private Date date;
    private String codRoom;
    private List<Client> clients;

    public Reserve(String codReserve, Date date, String codRoom) {
        this.codReserve = codReserve;
        this.date = date;
        this.codRoom = codRoom;
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

    @Override
    public boolean equals(Object o) {
        boolean isEquals;
        if (this == o) {
            isEquals = true;
        } else if (o == null || getClass() != o.getClass()) {
            isEquals = false;
        } else {
            Reserve reserve = (Reserve) o;
            return Objects.equals(codReserve, reserve.codReserve);
        }
        return isEquals;

    }

    @Override
    public int hashCode() {
        return Objects.hash(codReserve, date,codRoom);
    }

    @Override
    public String toString() {
        return "Reserve[" +
                "codReserve = " + codReserve +
                "date = " + date +
                "codRoom = " + codRoom +
                ']';
    }
}
