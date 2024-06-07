package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.entity.Client;

public class InsertClient {
    public static void main(String[] args) {
      Client c = new Client("CCC90","Juan","Mariano","644112299","juan@gmail.com","Holas000-",7);
      ClientDAO cDAO = new ClientDAO();
      cDAO.save(c);
    }
    //Holas000-
}
