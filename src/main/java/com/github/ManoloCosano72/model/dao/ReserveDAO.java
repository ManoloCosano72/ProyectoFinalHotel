package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.github.ManoloCosano72.model.dao.RoomDAO.build;

public class ReserveDAO implements DAO<Reserve, String> {
    private final static String FINDBYCODRESERVE = "SELECT r.codReserve FROM Reserve AS r WHERE r.codReserve=?";
    private final static String FINDBYROOM = "SELECT r.codRoom FROM Reserve AS r WHERE r.codRoom=?";
    private final static String FINDRESERVESBYCLIENT = "SELECT Dni, CodReserve FROM Reserve WHERE Dni=?";
    private final static String DELETE = "DELETE FROM Reserve WHERE CodReserve=? ";
    private final static String UPDATE = "UPDATE Reserve SET date=?, codRoom=? WHERE codReserve=?";
    private final static String INSERT = "INSERT INTO Reserve (codReserve,Date,CodRoom) VALUES (?,?,?)";
    private final static String INSERTDOR = "INSERT INTO Dor (Dni,CodReserve) VALUES (?,?)";


    @Override
    public Reserve save(Reserve entity) {
        Reserve result = entity;
        if (entity != null) {
            String codReserve = entity.getCodReserve();
            if (codReserve != null) {
                Reserve isInDataBase = findByCodReserve(codReserve);
                if (isInDataBase != null) {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                        pst.setString(1, entity.getCodReserve());
                        pst.setDate(2, (Date) entity.getDate());
                        pst.setString(3, entity.getRoom().getCodRoom());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    saveClientR(entity);
                }
            }
        }
        return result;
    }

    public Reserve saveClientR(Reserve reserve) {
        if (reserve != null && reserve.getCodReserve() != null) {
            if (reserve.getClients() != null) {
                try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERTDOR)) {
                    for (Client client : reserve.getClients()){
                        while(client != null && client.getDni() !=null){
                            pst.setString(1, client.getDni());
                            pst.setString(2, reserve.getCodReserve());
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return reserve;
    }

    @Override
    public Reserve delete(Reserve entity) throws SQLException {
        if (entity == null || entity.getCodReserve() == null) return entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
            pst.setString(1, entity.getCodReserve());
            pst.executeUpdate();
        }
        return entity;
    }


    public Reserve findByCodReserve(String codRe) {
        Reserve result = new Reserve();
        if (codRe == null) return result;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYCODRESERVE)) {
            pst.setString(1, codRe);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setCodReserve(res.getString("CodReserve"));
                result.setDate(res.getDate("Date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public Reserve findByCodRoom(String codRo) {
        Reserve result = new Reserve();
        if (codRo == null) return result;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYROOM)) {
            pst.setString(1, codRo);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setCodReserve(res.getString("CodReserve"));
                result.setDate(res.getDate("Date"));
                //Eager
                result.setRoom(build().findByCodRoom((res.getString("Room"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Reserve> findByReservesByClient(String key) {
        List<Reserve> reserves = new ArrayList<>();
        if (key != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDRESERVESBYCLIENT)) {
                pst.setString(1, key);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    Reserve reserve;
                    reserve = findByCodReserve(res.getString("CodReserve"));
                    reserves.add(reserve);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reserves;
    }

    public Reserve update(Reserve entity) {
        Reserve result = entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
            pst.setDate(1, (Date) entity.getDate());
            pst.setString(2, entity.getRoom().getCodRoom());
            pst.setString(3, entity.getCodReserve());
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
