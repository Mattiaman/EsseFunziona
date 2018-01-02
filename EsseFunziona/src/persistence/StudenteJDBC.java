package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Studente;
import model.Tassa;
import persistence.dao.StudenteDAO;
import persistence.dao.TassaDAO;

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
				statement.setString(5, studente.getEmail());
				statement.setDate(4, new Date(studente.getDataDiNascita().getTime()));
				statement.setLong(6, studente.getCorsoDiLaurea().getId());
				statement.setLong(7, studente.getPianoDiStudi().getId());
				
				statement.executeUpdate();
				
				if(studente.getTasse()!=null)
					if(!(studente.getTasse().isEmpty()))
						this.mappaTasse(studente, connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	@Override
	public Studente findByPrimaryKey(String matricola) {
		Connection connection=this.databaseData.getConnection();
		Studente studente=null;
		try {
			PreparedStatement statement;
			String query="SELECT * FROM studente WHERE matricola=?";
			statement=connection.prepareStatement(query);
			statement.setString(1,matricola);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				studente=new Studente();
				studente.setMatricola(result.getString("matricola"));
				studente.setNome(result.getString("nome"));
				studente.setCognome(result.getString("cognome"));
				studente.setEmail(result.getString("email"));
				studente.setDataDiNascita(result.getDate("dataDiNascita"));
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
		return studente;
	}

	@Override
	public List<Studente> findAll() {
		Connection connection=this.databaseData.getConnection();
		List<Studente> studenti=new ArrayList<>();
		try {
			Studente studente;
			PreparedStatement statement;
			String query="SELECT * FROM studente";
			statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				studente=findByPrimaryKey(result.getString("matricola"));
				studenti.add(studente);
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
		return studenti;
	}

	@Override
	public void update(Studente studente) {
		Connection connection=this.databaseData.getConnection();
		try {	
			String update="UPDATE studente SET nome=?, cognome=?, email=?, dataDiNascita=? WHERE matricola=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setString(1, studente.getNome());
			statement.setString(2, studente.getCognome());
			statement.setString(3, studente.getEmail());
			statement.setDate(4, new Date(studente.getDataDiNascita().getTime()));
			statement.setString(5, studente.getMatricola());
			statement.executeUpdate();
			
			if(studente.getTasse()!=null)
				if(!(studente.getTasse().isEmpty()))
					this.mappaTasse(studente, connection);
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					e.printStackTrace();
				}
			} 
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(Studente studente) {
		Connection connection=this.databaseData.getConnection();
		try {
			String delete="DELETE FROM studente WHERE matricola=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setString(1, studente.getMatricola());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			this.removeForeignKeyFromDevePagare(studente, connection);
			this.removeForeignKeyFromPrenota(studente, connection);
			statement.executeUpdate();
			connection.commit();
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
	}
	
	private void removeForeignKeyFromDevePagare(Studente studente, Connection connection) throws SQLException {
			String update="update devePagare SET matricolaStudente=NULL WHERE matricolaStudente=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setString(1, studente.getMatricola());
			statement.executeUpdate();
	}

	private void removeForeignKeyFromPrenota(Studente studente, Connection connection) throws SQLException {
		String update="update prenota SET matricolaStudente=NULL WHERE matricolaStudente=?";
		PreparedStatement statement=connection.prepareStatement(update);
		statement.setString(1, studente.getMatricola());
		statement.executeUpdate();
}

	@Override
	public void setPassword(Studente studente, String password) {
		// TODO Auto-generated method stub
		Connection connection = this.databaseData.getConnection();
		try {
			String update = "update studente SET password = ? WHERE matricola=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, studente.getMatricola());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
	}

	private void mappaTasse(Studente studente, Connection connection) throws SQLException {
		TassaDAO tassaDAO=new TassaJDBC(databaseData);
		for(Tassa tassa:studente.getTasse()) {
			if(tassaDAO.findByPrimaryKey(tassa.getId())==null) {
				tassaDAO.save(tassa);
			}
			String devePagare="select id from devePagare where matricolaStudente=? AND idTassa=?";
			PreparedStatement statementDevePagare=connection.prepareStatement(devePagare);
			statementDevePagare.setString(1, studente.getMatricola());
			statementDevePagare.setLong(2, tassa.getId());
			ResultSet result=statementDevePagare.executeQuery();
			if(result.next()) {
				String update="update devePagare SET matricolaStudente=? WHERE id=?";
				PreparedStatement statement=connection.prepareStatement(update);
				statement.setString(1, studente.getMatricola());
				statement.setLong(2, result.getLong("id"));
				statement.executeUpdate();
			}
			else {
				String aggiungi="insert into afferisce(id, idTassa, matricolaStudente) values(?,?,?)";
				Long id=IdGenerator.getId(connection);
				PreparedStatement statementAggiungi=connection.prepareStatement(aggiungi);
				statementAggiungi.setLong(1, id);
				statementAggiungi.setLong(2, tassa.getId());
				statementAggiungi.setString(3, studente.getMatricola());
				statementAggiungi.executeUpdate();
			}
		}
	}

}
