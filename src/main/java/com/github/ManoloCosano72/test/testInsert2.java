package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ReserveDAO;
import com.github.ManoloCosano72.model.entity.Reserve;

import java.util.Date;

public class testInsert2 {
    public static void main(String[] args) {
        Reserve r = new Reserve("12344578AB",new Date(),"",null);
        ReserveDAO rRAO = new ReserveDAO();
        rRAO.save(r);
    }
}
