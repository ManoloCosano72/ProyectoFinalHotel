package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.*;

public class ReserveDAO implements DAO<Reserve, String> {
    private final static String FINDBYCODRESERVE = "SELECT r.codReserve FROM Reserve AS r WHERE r.codReserve=?";
    private final static String FINDBYROOM = "SELECT r.codRoom FROM Reserve AS r WHERE r.codRoom=?";
    private final static String DELETE = "DELETE FROM Reserve WHERE CodReserve=? ";
    private final static String UPDATE = "UPDATE Reserve SET date=?, codRoom=? WHERE codReserve=?";
    private final static String INSERT = "INSERT INTO Reserve (Date,CodRoom) VALUES (?,?)";



    private Connection conn;

    public ReserveDAO() {
        conn = ConnectionMariaDB.getConnection();
    }

    @Override
    public Reserve save(Reserve entity) {
        Reserve result = entity;
        if (entity != null) {
            int codReserve = entity.getCodReserve();
            if (codReserve != 0) {
                Reserve isInDataBase = findByCodReserve(codReserve);
                if (isInDataBase == null) {
                    try (PreparedStatement pst = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                        pst.setDate(1, (Date) entity.getDate());
                        pst.setInt(2, entity.getCodRoom());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } else {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
                        pst.setString(1, String.valueOf(entity.getDate()));
                        pst.setInt(2, entity.getCodRoom());
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
    public Reserve delete (Reserve entity) throws SQLException {
        if (entity == null || entity.getCodReserve() == null) return entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setString(1, entity.getCodReserve());
            pst.executeUpdate();
        }
        return entity;
    }


    public Reserve findByCodReserve(String codRe) {

        return null;
    }

    public Reserve findByCodRoom(String codRo) {
        return null;
    }

    public Reserve update(Reserve entity) {
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
