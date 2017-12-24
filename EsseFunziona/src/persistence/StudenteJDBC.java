package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Studente;
import persistence.dao.StudenteDAO;

public class StudenteJDBC implements StudenteDAO {

	private DatabaseData databaseData;

	public StudenteJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(Studente studente) {
		Connection connection=this.databaseData.getConnection();
		
			String insert="insert into studente(matricola, nome, cognome, dataDiNascita, email, corsoDiLaureaId, pianoDiStudiId) values (?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(insert);
				statement.setString(1, studente.getMatricola());
				statement.setString(2, studente.getNome());
				statement.setString(3, studente.getCognome());
				statement.setDate(4, new Date(studente.getDataDiNascita().getTime()));
				statement.setLong(6, studente.getCorsoDiLaurea().getId());
				statement.setLong(7, studente.getPianoDiStudi().getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public Studente findByPrimaryKey(String matricola) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Studente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Studente studente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Studente studente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPassword(Studente studente, String password) {
		// TODO Auto-generated method stub

	}

}
