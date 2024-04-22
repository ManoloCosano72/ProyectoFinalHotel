package com.github.ManoloCosano72.model.entity;

import java.util.Date;
import java.util.Objects;

public class Reserve {
    private String codReserve;
    private Date date;

    public Reserve(String codReserve, Date date) {
        this.codReserve = codReserve;
        this.date = date;
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
        return Objects.hash(codReserve, date);
    }

    @Override
    public String toString() {
        return "Reserve[" +
                "codReserve = " + codReserve +
                "date = " + date +
                ']';
    }
}
