package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.entity.enums.TypeR;

import java.sql.SQLException;


public class InsertRoom {
    public static void main(String[] args) throws SQLException {
        Room r = new Room();
        r.setCodRoom("AAA11");
        r.setBeds(4);
        r.setWindows(6);
        r.setTypeR(TypeR.BIGGER);
        r.setPrice(800);
        RoomDAO roDAO = new RoomDAO();
        roDAO.save(r);
    }

}
