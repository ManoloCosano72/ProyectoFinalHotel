package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.RoomDAO;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.entity.enums.TypeR;

public class testInsert3 {
    public static void main(String[] args) {
        Room r = new Room("12345ABCDE67890",2,2,233, TypeR.DELUXE,null);
        RoomDAO roDAO = new RoomDAO();
        roDAO.save(r);
    }

}
