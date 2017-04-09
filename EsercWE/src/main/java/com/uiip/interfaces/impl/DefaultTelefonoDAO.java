package com.uiip.interfaces.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.uiip.interfaces.TelefonoDAO;
import com.uiip.model.TelefonoModel;

public class DefaultTelefonoDAO implements TelefonoDAO{

	public TelefonoModel getTelefonoInfo(String modello) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "SELECT modello, size, weight, marca FROM Telefono WHERE modello = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, modello);
            ResultSet res = stmt.executeQuery();
            if (res.first()) {
            	return new TelefonoModel(res.getString("modello"), res.getString("size"), res.getInt("weight"), res.getString("marca"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return null;
	}

	public boolean insertTelefono(TelefonoModel telefono) {
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO Telefono (modello, size, weight, marca) VALUE (?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, telefono.getModello());
            stmt.setString(2, telefono.getSize());
            stmt.setInt(3, telefono.getWeight());
            stmt.setString(4, telefono.getMarca());
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
	}

}
