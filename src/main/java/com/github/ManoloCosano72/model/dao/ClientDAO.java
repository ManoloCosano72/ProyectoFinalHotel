package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClientDAO implements DAO<Client,String>{
    private final static String FINDBYDNI = "SELECT c.Dni, c.Name FROM Client AS c WHERE c.Dni =?";
    private final static String DELETE = "DELETE FROM Client AS c WHERE c.Dni=?";
    private final static String UPDATE = "UPDATE Client SET name=?, surnames=?, phone=?, mail=? WHERE c.Dni=? ";
    private final static String INSERT = "INSERT INTO Client (Dni,Name,Surnames,Phone,Mail) VALUES (?,?,?,?,?)";


    @Override
    public Client save(Client entity) {
        Client result = entity;
        if(entity ==null || entity.getDni()==null) return result;
        Client c = findByDni(entity.getDni());
        if(c.getDni()==null){
            try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS)){
                pst.setString(1,entity.getDni());
                pst.setString(2,entity.getName());
                pst.setString(3,entity.getSurnames());
                pst.setString(4,entity.getPhone());
                pst.setString(5,entity.getMail());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Client delete(Client entity) throws SQLException {
        return null;
    }

    @Override
    public Client findByDni(String key) {
        Client result = new Client();
        if(key==null) return null;
        try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYDNI)) {
            pst.setString(1, key);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setDni(res.getString("Dni"));
                result.setName(res.getString("Name"));
            }
            res.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws IOException {

    }
}
