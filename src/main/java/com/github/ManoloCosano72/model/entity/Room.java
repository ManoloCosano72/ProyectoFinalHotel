package com.github.ManoloCosano72.model.entity;

import com.github.ManoloCosano72.model.entity.enums.TypeR;

import java.util.Objects;

public class Room {
    private int codRoom;
    private int beds;
    private int windows;
    private float price;
    private TypeR typeR;

    public Room(int codRoom, int beds, int windows, float price, TypeR typeR) {
        this.codRoom = codRoom;
        this.beds = beds;
        this.windows = windows;
        this.price = price;
        this.typeR= typeR;
    }

    public Room() {
    }


    public int getCodRoom() {
        return codRoom;
    }

    public void setCodRoom(int codRoom) {
        this.codRoom = codRoom;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
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
        return Objects.hash(codRoom, beds, windows,typeR,price);
    }

    @Override
    public String toString() {
        return "Room[" +
                "codRoom=  " + codRoom +
                ", bed = " + beds +
                ", windows = " + windows +
                ", typeR ="  + typeR +
                ", price = " + price +
                ']';
    }
}
