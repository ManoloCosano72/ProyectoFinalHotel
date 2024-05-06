package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.entity.enums.TypeR;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RoomDAO implements DAO<Room, String> {
    private final static String FINDBYCODROOM = "SELECT r.codRoom FROM Room AS r WHERE r.codRoom=? ";
    private final static String FINDBYTYPE= "SELECT TypeR FROM Room WHERE typeR=?";
    private final static String DELETE = "DELETE from Room WHERE CodRoom=?";
    private final static String UPDATE = "UPDATE Room SET Beds=? ,Windows=?,TypeR=?, Price=? WHERE CodRoom=?";
    private final static String INSERT = "INSERT INTO Room (codRoom,Beds, Windows,TypeR,Price) VALUES (?,?,?,?,?)";


    @Override
    public Room save(Room entity) {
        Room result = entity;
        if (entity == null) return result;
        if (entity != null) {
            String codRoom = entity.getCodRoom();
            if (codRoom != null) {
                Room isInDataBase = findByCodRoom(codRoom);
                if (isInDataBase != null) {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                        pst.setString(1, entity.getCodRoom());
                        pst.setInt(2, entity.getBeds());
                        pst.setInt(3, entity.getWindows());
                        pst.setString(4, String.valueOf(entity.getTypeR()));
                        pst.setInt(5, entity.getPrice());
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
    public Room delete(Room entity) throws SQLException {
        if (entity == null || entity.getCodRoom() == null) return entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setString(1, entity.getCodRoom());
            pst.executeUpdate();
        }
        return entity;
    }

    public Room findByCodRoom(String cR) {
        Room result = new Room();
        if (cR == null) return result;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYCODROOM)) {
            pst.setString(1, cR);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setCodRoom(res.getString("CodRoom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Room findByType(Room typeR){
        Room result = new Room();
        if (typeR == null) return result;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYTYPE)) {
            pst.setString(1, typeR.getTypeR().name());
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                String string = res.getString("TypeR");
                TypeR typeR1 = TypeR.valueOf(string.toUpperCase());
                result.setTypeR(typeR1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Room update(Room entity) {
        Room result = entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
            pst.setInt(1, entity.getBeds());
            pst.setInt(2, entity.getWindows());
            pst.setString(3, String.valueOf(entity.getTypeR()));
            pst.setInt(4, entity.getPrice());
            pst.setString(5, entity.getCodRoom());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static RoomDAO build(){
        return new RoomDAO();
    }


    @Override
    public void close() throws IOException {

    }

}
