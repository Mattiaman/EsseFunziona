package persistence;

import model.Professore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.Appello;
import model.Studente;
import persistence.dao.StudenteDAO;

public class ProfessoreProxy extends Professore{
	private DatabaseData databaseData;
	
	public ProfessoreProxy(DatabaseData databaseData) {
		this.databaseData=databaseData;
	}
	
	public Set<Studente> getStudentiRicevimento() { 
		Set<Studente> studenti = new HashSet<>();
		Connection connection = this.databaseData.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from riceve where nomeUtenteProfessore = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getNomeUtente());
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
		this.setStudentiRicevimento(studenti);
		return super.getStudentiRicevimento(); 
	}
}
