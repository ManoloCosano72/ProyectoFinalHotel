package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.entity.Room;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RoomDAO implements DAO<Room, String> {
    private final static String FINDBYDNI = "";
    private final static String DELETE = "DELETE from Room WHERE CodRoom=?";
    private final static String UPDATE = "UPDATE Room SET bed=? ,windows=?, price=? WHERE CodRoom=?";
    private final static String INSERT = "INSERT INTO Room (CodRoom,bed, windows,price) VALUES (?,?,?,?";

    private Connection conn;

    public RoomDAO() {
        conn = ConnectionMariaDB.getConnection();
    }

    @Override
    public Room save(Room entity) {
        Room result = entity;
        if (entity != null) {
            String codRoom = entity.getCodRoom();
            if (codRoom != null) {
                Room isInDataBase = findByDni(codRoom);
                if (isInDataBase == null) {
                    try (PreparedStatement pst = conn.prepareStatement(INSERT)) {
                        pst.setString(1, entity.getCodRoom());
                        pst.setInt(2, entity.getBed());
                        pst.setInt(3, entity.getWindows());
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
        try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setString(1,entity.getCodRoom());
            pst.executeUpdate();
        }
        return entity;
    }

    @Override
    public Room findByDni(String key) {
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
