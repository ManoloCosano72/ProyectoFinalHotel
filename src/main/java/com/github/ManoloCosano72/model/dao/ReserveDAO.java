package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReserveDAO implements DAO<Reserve, String> {
    private final static String FINDBYCOD = "SELECT r.codReserve FROM Reserve AS r WHERE r.codReserve=?";
    private final static String FINDBYROOM = "SELECT r.codRoom FROM Reserve AS r WHERE r.codRoom=?";
    private final static String DELETE = "DELETE FROM Reserve WHERE codReserve=? ";
    private final static String UPDATE = "UPDATE Reserve SET date=?, codRoom=? WHERE codReserve=?";
    private final static String INSERT = "INSERT INTO Reserve (codReserve,Date,codRoom) VALUES (?,?,?)";

    private Connection conn;

    public ReserveDAO() {
        conn = ConnectionMariaDB.getConnection();
    }

    @Override
    public Reserve save(Reserve entity) {
        Reserve result = entity;
        if (entity != null) {
            String codReserve = entity.getCodReserve();
            if (codReserve != null) {
                Reserve isInDataBase = findByDni(codReserve);
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
        return result;
    }

    @Override
    public Reserve delete(Reserve entity) throws SQLException {
        if (entity == null || entity.getCodReserve() == null) return entity;
        try(PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setString(1,entity.getCodReserve());
            pst.executeUpdate();
        }
        return entity;
    }

    @Override
    public Reserve findByDni(String key) {
        return null;
    }

    @Override
    public void close() throws IOException {
        if (conn!=null){
            try{
               close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
