package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.Appello;
import model.Studente;
import persistence.dao.StudenteDAO;

public class AppelloProxy extends Appello{
	private DatabaseData databaseData;
	
	public AppelloProxy(DatabaseData databaseData) {
		this.databaseData=databaseData;
	}
	
	public Set<Studente> getStudentiIscritti() { 
		Set<Studente> studenti = new HashSet<>();
		Connection connection = this.databaseData.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from prenota where idAppello = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, this.getId());
			ResultSet result = statement.executeQuery();
			StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			while (result.next()) {
				Studente studente =studenteDAO.findByPrimaryKey(result.getString("matricolaStudente"));
				studenti.add(studente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		this.setStudentiIscritti(studenti);
		return super.getStudentiIscritti(); 
	}
	
	public Set<Studente> getStudentiIscrittiEsiti() { 
		Set<Studente> studenti = new HashSet<>();
		Connection connection = this.databaseData.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from esame where idAppello = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, this.getId());
			ResultSet result = statement.executeQuery();
			StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			while (result.next()) {
				Studente studente =studenteDAO.findByPrimaryKey(result.getString("matricolaStudente"));
				studenti.add(studente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		this.setStudentiIscritti(studenti);
		return super.getStudentiIscrittiEsiti(); 
	}
	
	
	public Set<Studente> getStudentiIscrittiEsame() { 
		Set<Studente> studenti = new HashSet<>();
		Connection connection = this.databaseData.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from libretto where idAppello = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, this.getId());
			ResultSet result = statement.executeQuery();
			StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			while (result.next()) {
				Studente studente =studenteDAO.findByPrimaryKey(result.getString("matricolaStudente"));
				studenti.add(studente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		this.setStudentiIscritti(studenti);
		return super.getStudentiIscrittiEsame(); 
	}
	
}
