package com.github.ManoloCosano72.test;

import com.github.ManoloCosano72.model.dao.ClientDAO;
import com.github.ManoloCosano72.model.entity.Client;

public class InsertClient {
    public static void main(String[] args) {
        Client c = new Client("111AA","pepe","uihdhwoi","644553310","lolo72@gmail.com");
        ClientDAO cDAO = new ClientDAO();
        cDAO.update(c);
    }
}
