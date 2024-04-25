package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Client;
import com.github.ManoloCosano72.model.entity.Reserve;
import com.github.ManoloCosano72.model.interfaces.DAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private final static String FINDBYDNI = "SELECT c.Dni c.name FROM Client AS c WHERE c.Dni =?";
    private final static String DELETE = "DELETE FROM Client AS c WHERE c.Dni=?";
    private final static String UPDATE = "UPDATE Client SET name=?, surnames=?, phone=?, mail=? WHERE c.Dni=? ";
    private final static String INSERT = "INSERT INTO Client (Dni,name,surnames,phone,mail) VALUES (?,?,?,?,?)";


}
