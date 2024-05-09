package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ReserveDAO;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.entity.Room;

import java.sql.Date;


public class InsertReserve {
    public static void main(String[] args) {
        Date date = new Date(1200,12,3);
        Room room = new Room();
        room.setCodRoom("12345");
        Reserve r = new Reserve("333MN",date,room);
        ReserveDAO rRAO = new ReserveDAO();
        rRAO.update(r);
    }
}
