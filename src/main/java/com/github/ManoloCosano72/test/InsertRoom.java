package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.entity.enums.TypeR;


public class InsertRoom {
    public static void main(String[] args) {
        Room r = new Room();
        r.setCodRoom("12345");
        r.setBeds(8);
        r.setWindows(5);
        r.setTypeR(TypeR.SUITE);
        r.setPrice(1200);
        RoomDAO roDAO = new RoomDAO();
        roDAO.findByType(r);
    }

}
