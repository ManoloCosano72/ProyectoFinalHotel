package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReserveDAO implements DAO<Reserve, String> {
    private final static String FINDBYCODRESERVE = "SELECT r.codReserve,r.date,r.codRoom FROM Reserve AS r WHERE r.codReserve=?";
    private final static String DELETE = "DELETE FROM Reserve WHERE codReserve=? ";
    private final static String UPDATE = "UPDATE Reserve SET date=?, codRoom=? WHERE codReserve=?";
    private final static String INSERT = "INSERT INTO Reserve (codReserve,Date,codRoom) VALUES (?,?,?)";

    private Connection conn;

    public ReserveDAO() {
        conn = ConnectionMariaDB.getConnection();
    }

    @Override
    public Reserve save(Reserve entity) {
        /*Reserve result = entity;
        if (entity != null) {
            String isbn = entity.getCodReserve();
            if (isbn != null) {
                Reserve isInDataBase = ();
                if (isInDataBase == null) {
                    try (PreparedStatement pst = conn.prepareStatement(INSERT)) {
                        pst.setString(1, entity.getCodReserve());
                        pst.setString(2, entity.getCodRoom());
                        pst.setString(3, String.valueOf(entity.getDate()));
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        */
        return null;
    }

    @Override
    public Reserve delete(Reserve entity) throws SQLException {
        return null;
    }

    @Override
    public Reserve findByDni(String key) {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
