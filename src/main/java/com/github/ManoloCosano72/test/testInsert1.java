package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.dao.ReserveDAO;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Reserve;

import java.sql.Date;
import java.util.ArrayList;

public class testInsert1 {
    public static void main(String[] args) {
        Client c = new Client("123456789A", "Manolo", "Cosano", "644553310", "manolo@manolo.com");
        ClientDAO cDAO = new ClientDAO();
        cDAO.save(c);
    }
}
