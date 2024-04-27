package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.*;

public class ClientDAO implements DAO<Client, String> {
    private final static String FINDBYDNI = "SELECT c.Dni FROM Client AS c WHERE c.Dni =?";
    private final static String FINDBYNAME="SELECT c.Name FROM Client";
    private final static String DELETE = "DELETE FROM Client AS c WHERE c.Dni=?";
    private final static String UPDATE = "UPDATE Client SET name=?, surnames=?, phone=?, mail=? WHERE c.Dni=? ";
    private final static String INSERT = "INSERT INTO Client (Dni,Name,Surnames,Phone,Mail) VALUES (?,?,?,?,?)";
    private Connection conn;

    public ClientDAO() {
        conn= ConnectionMariaDB.getConnection();
    }

    @Override
    public Client save(Client entity) {
        Client result = entity;
        if (entity == null || entity.getDni() == null) return result;
        Client c = findByDni(entity.getDni());
        if (c.getDni() == null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, entity.getDni());
                pst.setString(2, entity.getName());
                pst.setString(3, entity.getSurnames());
                pst.setString(4, entity.getPhone());
                pst.setString(5, entity.getMail());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
                pst.setString(1, entity.getDni());
                pst.setString(2, entity.getName());
                pst.setString(3, entity.getSurnames());
                pst.setString(4, entity.getPhone());
                pst.setString(5, entity.getMail());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Client delete(Client entity) throws SQLException {
        if (entity == null || entity.getDni() == null) return entity;
        try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setString(1,entity.getDni());
            pst.executeUpdate();
        }
        return entity;
    }

    @Override
    public Client findByDni(String key) {
        Client result = new Client();
        if (key == null) return null;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYDNI)) {
            pst.setString(1, key);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setDni(res.getString("Dni"));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void close() throws IOException {
        if(conn!=null){
            try{
                close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

