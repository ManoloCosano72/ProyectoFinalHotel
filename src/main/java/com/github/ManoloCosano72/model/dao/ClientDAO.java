package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class ClientDAO implements DAO<Client, String> {
    private final static String FINDBYDNI = "SELECT c.Dni FROM Client AS c WHERE c.Dni =?";
    private final static String FINDBYNAME = "SELECT c.Name FROM Client AS c WHERE c.Name=?";
    private final static String DELETE = "DELETE FROM Client AS c WHERE c.Dni=?";
    private final static String UPDATE = "UPDATE Client SET name=?, surnames=?, phone=?, mail=? WHERE c.Dni=? ";
    private final static String INSERT = "INSERT INTO Client (Name,Surnames,Phone,Mail) VALUES (?,?,?,?)";
    private Connection conn;

    public ClientDAO() {
        conn = ConnectionMariaDB.getConnection();
    }

    @Override
    public Client save(Client entity) {
        Client result = entity;
        if (entity == null) return result;
        if (entity.getDni()==0) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, entity.getName());
                pst.setString(2, entity.getSurnames());
                pst.setString(3, entity.getPhone());
                pst.setString(4, entity.getMail());
                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
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
        Client result = entity;
        if (entity == null || entity.getDni() == 0) return result;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setInt(1, entity.getDni());
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
                result.setDni(res.getInt("Dni"));
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
                result.setDni(res.getInt("Name"));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Client update(Client entity) {
        return null;
    }

    @Override
    public void close() throws IOException {
        if (conn != null) {
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

