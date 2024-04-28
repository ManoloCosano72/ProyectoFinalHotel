package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.entity.enums.TypeR;


public class testInsert3 {
    public static void main(String[] args) {
        Room r = new Room();
        RoomDAO roDAO = new RoomDAO("1234567890ACBED",3,5, TypeR.DELUXE,187,"ABCD123456");
        roDAO.save(r);
    }

}
