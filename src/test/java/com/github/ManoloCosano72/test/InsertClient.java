package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.entity.Client;

import java.sql.SQLException;

public class InsertClient {
    public static void main(String[] args) throws SQLException {
      Client c = new Client("111BB","Manolo","CP","644553342","manolo@gmail.com","987654321",1);
      ClientDAO cDAO = new ClientDAO();
      cDAO.save(c);
    }
}
