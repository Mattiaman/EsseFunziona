package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.PianoDiStudi;
import model.Studente;
import model.Tassa;
import persistence.dao.PianoDiStudiDAO;
import persistence.dao.TassaDAO;

public class DatiStudente extends Studente {
	private DatabaseData databaseData;

	public DatiStudente(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}
	
	public String getPassword(){						
		Connection connection = this.databaseData.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from studente where matricola = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getMatricola());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return result.getString("password");
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
		return null;
	}
	
	public PianoDiStudi getPianoDiStudi(){						
		Connection connection = this.databaseData.getConnection();
		PianoDiStudiDAO pdsDAO=DatabaseManager.getInstance().getDaoFactory().getPianoDiStudiDAO();
		PianoDiStudi pds=null;
		try {
			PreparedStatement statement;
			String query = "select * from studente where matricola = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getMatricola());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				pds=pdsDAO.findByPrimaryKeyProxy(result.getLong("pianoDiStudiId"));

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
		super.setPianoDiStudi(pds);
		return pds;
	}

	@Override
	public Set<Tassa> getTasse() {
		Connection connection=databaseData.getConnection();
		Set<Tassa> tasse=new HashSet<Tassa>();
		TassaDAO tassaDAO=DatabaseManager.getInstance().getDaoFactory().getTassaDAO();
		try {
			String query="select * from devePagare where matricolaStudente=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, this.getMatricola());
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				tasse.add(tassaDAO.findByPrimaryKey(result.getLong("idTassa")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.setTasse(tasse);
		return tasse;
	}
	
}
