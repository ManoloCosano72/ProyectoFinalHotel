package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.entity.Client;

public class InsertClient {
    public static void main(String[] args) {
      Client c = new Client("111AA","Juan","Mariano","644553310","lolo72@gmail.com","12345678",1);
      ClientDAO cDAO = new ClientDAO();
      cDAO.update(c);
    }
}
