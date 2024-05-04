package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO implements DAO<Client, String> {
    private final static String FINDBYDNI = "SELECT Dni FROM Client WHERE Dni =?";
    private final static String FINDBYNAME = "SELECT Name FROM Client WHERE Name=?";
    private final static String DELETE = "DELETE FROM Client WHERE Dni=?";
    private final static String UPDATE = "UPDATE Client SET name=?, surnames=?, phone=?, mail=? WHERE Dni=? ";
    private final static String INSERT = "INSERT INTO Client (Dni,Name,Surnames,Phone,Mail) VALUES (?,?,?,?,?)";

    @Override
    public Client save(Client entity) {
        Client result = entity;
        if (entity == null) return result;
        if (entity != null) {
            String Dni = entity.getDni();
            if (Dni !=null) {
                Client isInDataBase = findByDni(Dni);
                if (isInDataBase != null) {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
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
            }
        }
        return result;
    }

    @Override
    public Client delete(Client entity) throws SQLException {
        Client result = entity;
        if (entity == null || entity.getDni() == null) return result;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setString(1, entity.getDni());
            pst.executeUpdate();
        }
        return entity;
    }

    public Client findByDni(String dni) {
        Client result = new Client();
        if (dni == null) return null;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYDNI)) {
            pst.setString(1, dni);
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

    public Client findByName(String name) {
        Client result = new Client();
        if (name == null) return null;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYNAME)) {
            pst.setString(1, name);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setName(res.getString("Name"));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Client update(Client entity){
        Client result = entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getSurnames());
            pst.setString(3, entity.getPhone());
            pst.setString(4, entity.getMail());
            pst.setString(5, entity.getDni());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws IOException {

    }
}

