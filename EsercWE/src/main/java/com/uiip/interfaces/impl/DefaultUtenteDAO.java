package com.uiip.interfaces.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.uiip.interfaces.UtenteDAO;
import com.uiip.model.TelefonoModel;
import com.uiip.model.UtenteModel;

public class DefaultUtenteDAO implements UtenteDAO{

	public UtenteModel getUtenteInfo(String numTel) {
		UtenteModel personModel = new UtenteModel();
        TelefonoModel telefonoModel = new TelefonoModel();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "SELECT p.nome, p.cognome, p.email, p.indirizzo, p.telefono, t.modello FROM Utente p INNER JOIN Telefono t ON (p.idUt = t.id) WHERE p.telefono = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, numTel);
            ResultSet res = stmt.executeQuery();
            if (res.first()) {            	
                personModel.setNome(res.getString("nome"));
                personModel.setCognome(res.getString("cognome"));
                personModel.setEmail(res.getString("email"));
                personModel.setIndirizzo(res.getString("indirizzo"));
                personModel.setTelefono(res.getString("telefono"));
                telefonoModel.setModello(res.getString("modello"));
                personModel.setTelefonoModel(telefonoModel);
            } else {
                personModel = null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return personModel;
	}

	public boolean updateUtenteInfo(String numTel, String indirizzo) {
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "UPDATE Utente SET indirizzo = ? WHERE telefono = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, indirizzo);
            stmt.setString(2, numTel);
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

	public boolean insertUtente(UtenteModel utenteModel, String modello) {
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO persona (nome, cognome, indirizzo, telefono, email, idTel) VALUE "
                    + "(?, ?, ?, ?, ?);";
            int id;
            String sql2 = "SELECT id FROM Telefono WHERE name = ? ;";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, modello);
            ResultSet res = stmt2.executeQuery();
            if (res.first()) {
                id = res.getInt("id");
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, utenteModel.getNome());
                stmt.setString(2, utenteModel.getCognome());
                stmt.setString(3, utenteModel.getIndirizzo());
                stmt.setString(4, utenteModel.getTelefono());
                stmt.setString(5, utenteModel.getEmail());
                stmt.setInt(6, id);
                if (stmt.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return false;
	}

	public boolean deleteUtente(String numTel) {
		MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rubrica");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "DELETE FROM Utente WHERE telefono = ? ;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, numTel);
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
