package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Professore;
import model.Studente;

public class DatiProfessore extends Professore {
	private DatabaseData databaseData;

	public DatiProfessore(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}
	
	public String getPassword(){						
		Connection connection = this.databaseData.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from professore where \"nomeUtente\" = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getNomeUtente());
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
}
