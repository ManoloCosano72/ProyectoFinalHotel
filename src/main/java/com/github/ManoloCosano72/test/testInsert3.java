package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.entity.enums.TypeR;

import static com.github.ManoloCosano72.model.entity.enums.TypeR.DELUXE;


public class testInsert3 {
    public static void main(String[] args) {
       Room r = new Room();
       r.setBeds(3);
       r.setWindows(2);
       r.setTypeR(TypeR.BIGGER);
       r.setPrice(333);
       RoomDAO roDAO = new RoomDAO();
       roDAO.save(r);
    }

}
