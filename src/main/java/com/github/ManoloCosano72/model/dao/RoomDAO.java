package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.entity.enums.TypeR;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RoomDAO implements DAO<Room, String> {
    private final static String FINDBYCODROOM = "SELECT r.codRoom FROM Room AS r WHERE r.codRoom=? ";
    private final static String DELETE = "DELETE from Room WHERE CodRoom=?";
    private final static String UPDATE = "UPDATE Room SET Beds=? ,Windows=?,TypeR=?, Price=? WHERE CodRoom=?";
    private final static String INSERT = "INSERT INTO Room (Beds, Windows,TypeR,Price) VALUES (?,?,?,?)";

    //private final static 📳📳📳📳📳;

    private Connection conn;



    @Override
    public Room save(Room entity) {
        Room result = entity;
        if (entity != null) {
            int codRoom = entity.getCodRoom();
            if (codRoom != 0) {
                Room isInDataBase = findByCodRoom(codRoom);
                if (isInDataBase == null) {
                    try (PreparedStatement pst = conn.prepareStatement(INSERT)) {
                        pst.setInt(1, entity.getBeds());
                        pst.setInt(2, entity.getWindows());
                        pst.setString(3, String.valueOf(entity.getTypeR()));
                        pst.setInt(4, (int) entity.getPrice());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } if (entity.getCodRoom() != 0){
                        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
                            pst.setInt(1, entity.getBeds());
                            pst.setInt(2, entity.getWindows());
                            pst.setString(3, String.valueOf(entity.getTypeR()));
                            pst.setInt(4, (int) entity.getPrice());
                            pst.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Room delete(Room entity) throws SQLException {
        if (entity == null || entity.getCodRoom() == 0) return entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            //pst.setString(1,entity.getCodRoom());
            pst.executeUpdate();
        }
        return entity;
    }

    public Room findByCodRoom(int cR) {
        return null;
    }

    public Room update(Room entity) {
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
