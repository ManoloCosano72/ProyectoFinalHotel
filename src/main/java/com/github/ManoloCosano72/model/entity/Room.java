package com.github.ManoloCosano72.model.entity;

import com.github.ManoloCosano72.model.entity.enums.TypeR;

import java.util.Objects;

public class Room {
    private String codRoom;
    private int bed;
    private int windows;
    private float price;
    private TypeR typeR;
    private Hotel codHotel;

    public Room(String codRoom, int bed, int windows, float price, TypeR typeR, Hotel codHotel) {
        this.codRoom = codRoom;
        this.bed = bed;
        this.windows = windows;
        this.price = price;
        this.typeR = typeR;
        this.codHotel = codHotel;
    }

    public Room() {
    }

    public String getCodRoom() {
        return codRoom;
    }

    public void setCodRoom(String codRoom) {
        this.codRoom = codRoom;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public TypeR getTypeR() {
        return typeR;
    }

    public void setTypeR(TypeR typeR) {
        this.typeR = typeR;
    }

    public Hotel getCodHotel() {
        return codHotel;
    }

    public void setCodHotel(Hotel codHotel) {
        this.codHotel = codHotel;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            isEquals = false;
        } else {
            Room room = (Room) obj;
            return Objects.equals(codRoom, room.codRoom);
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codRoom, bed, windows, price);
    }

    @Override
    public String toString() {
        return "Room[" +
                "codRoom=  " + codRoom +
                ", bed = " + bed +
                ", windows = " + windows +
                ", price = " + price +
                ", typeR ="  + typeR +
                ", codHotel = " + codHotel +
                ']';
    }
}
