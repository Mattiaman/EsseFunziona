package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.Corso;
import model.PianoDiStudi;
import persistence.dao.CorsoDAO;

public class PianoDiStudiProxy extends PianoDiStudi {
	private DatabaseData databaseData;
	
	public PianoDiStudiProxy(DatabaseData databaseData) {
		this.databaseData=databaseData;
	}
	
	public Set<Corso> getCorsi() { 
		Set<Corso> corsi = new HashSet<>();
		Connection connection = this.databaseData.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from contiene where idPianoDiStudi = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, this.getId());
			ResultSet result = statement.executeQuery();
			CorsoDAO corsoDAO=DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
			while (result.next()) {
				Corso corso =corsoDAO.findByPrimaryKey(result.getLong("idCorso"));
				corsi.add(corso);
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
		this.setCorsi(corsi);;
		return super.getCorsi(); 
	}
}
