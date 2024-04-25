package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.SQLException;

public class ClientDAO implements DAO<Client,String> {
    private final static String FINDBYDNI ="SELECT c.Dni c.name FROM Client AS c WHERE c.Dni =?";
    private final static String DELETE="DELETE FROM Client AS c WHERE c.Dni=?";
    private final static String UPDATE="UPDATE Client SET name=?, surnames=?, phone=?, mail=? WHERE c.Dni=? ";
    private final static String INSERT="INSERT INTO Client (Dni,name,surnames,phone,mail) VALUES (?,?,?,?,?)";


    @Override
    public Client save(Client entity) {
        return null;
    }

    @Override
    public Client delete(Client entity) throws SQLException {
        return null;
    }

    @Override
    public Client findByDni(String key) {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
