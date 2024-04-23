package com.github.ManoloCosano72.model.entity;

import java.util.Objects;

public class Hotel {
    private String CodHotel;
    private String name;
    private String address;
    private String phone;
    public Hotel(String codHotel, String name, String address, String phone) {
        CodHotel = codHotel;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Hotel() {
    }

    private enum rate{
        FIVE,
        FOUR,
        THREE,
        TWO,
        ONE
    }

    public String getCodHotel() {
        return CodHotel;
    }

    public void setCodHotel(String codHotel) {
        CodHotel = codHotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        }
        else if (obj == null || getClass() != obj.getClass()){
            isEquals = false;
        }else{
            Hotel hotel = (Hotel) obj;
            return Objects.equals(CodHotel, hotel.CodHotel);
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CodHotel, name, address, phone);
    }

    @Override
    public String toString() {
        return "Hotel[" +
                "CodHotel = " + CodHotel +
                ", name = " + name +
                ", address = " + address  +
                ", phone = " + phone  +
                ']';
    }
}
