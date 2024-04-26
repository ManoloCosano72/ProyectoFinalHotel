package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ReserveDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Reserve;

import java.sql.Date;
import java.util.ArrayList;

public class testInsert1 {
    public static void main(String[] args) {
        Client c = new Client("123456789A", "Manolo", "Cosano", "644553310", "manolo@manolo.com", new ArrayList<>());
        Reserve r = new Reserve();
        r.setCodReserve("123456789ABCDEF");
        r.setCodRoom("FEDCBA987654321");
        r.setClients(c);
        Date date = new Date(2024-3-24);
        r.setDate(date);
        ReserveDAO rDAO = new ReserveDAO();

    }
}
