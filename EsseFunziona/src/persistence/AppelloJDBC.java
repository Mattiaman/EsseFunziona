package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Appello;
import model.Corso;
import model.Professore;
import model.Studente;
import model.Tassa;
import persistence.dao.AppelloDAO;
import persistence.dao.CorsoDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;
import persistence.dao.TassaDAO;

public class AppelloJDBC implements AppelloDAO {

	private DatabaseData databaseData;
	
	public AppelloJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}
	
	@Override
	public void save(Appello appello) {
		Connection connection=this.databaseData.getConnection();
		
		String insert="insert into appello(id, dataAppello, nomeUtenteProfessore, corsoId) values (?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(insert);
			Long id=IdGenerator.getId(connection);
			appello.setId(id);
			statement.setLong(1, id);
			statement.setDate(2, new Date(appello.getData().getTime()));
			statement.setString(3, appello.getProfessore().getNomeUtente());
			statement.setLong(4, appello.getCorso().getId());
			
			statement.executeUpdate();
			
			if(appello.getStudentiIscritti()!=null)
				if(!(appello.getStudentiIscritti().isEmpty()))
					this.mappaStudenti(appello, connection);
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
	public Appello findByPrimaryKey(long id) {
		Connection connection=this.databaseData.getConnection();
		Appello appello=null;
		try {
			PreparedStatement statement;
			String query="SELECT * FROM appello WHERE id=?";
			statement=connection.prepareStatement(query);
			statement.setLong(1,id);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				appello=new Appello();
				appello.setId(result.getLong("id"));
				appello.setData(result.getDate("dataAppello"));
				CorsoDAO corsoDAO=new CorsoJDBC(this.databaseData);
				appello.setCorso(corsoDAO.findByPrimaryKey(result.getLong("corsoId")));
				ProfessoreDAO professoreDAO=new ProfessoreJDBC(this.databaseData);
				appello.setProfessore(professoreDAO.findByPrimaryKey(result.getString("nomeUtenteProfessore")));
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
		return appello;
	}
	
	@Override
	public Appello findByPrimaryKeyProxy(long id) {
		Connection connection=this.databaseData.getConnection();
		Appello appello=null;
		try {
			PreparedStatement statement;
			String query="SELECT * FROM appello WHERE id=?";
			statement=connection.prepareStatement(query);
			statement.setLong(1,id);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				appello=new AppelloProxy(databaseData);
				appello.setId(result.getLong("id"));
				appello.setData(result.getDate("dataAppello"));
				CorsoDAO corsoDAO=new CorsoJDBC(this.databaseData);
				appello.setCorso(corsoDAO.findByPrimaryKey(result.getLong("corsoId")));
				ProfessoreDAO professoreDAO=new ProfessoreJDBC(this.databaseData);
				appello.setProfessore(professoreDAO.findByPrimaryKey(result.getString("nomeUtenteProfessore")));
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
		return appello;
	}

	@Override
	public List<Appello> findAll() {
		Connection connection=this.databaseData.getConnection();
		List<Appello> appelli=new ArrayList<>();
		try {
			Appello appello;
			PreparedStatement statement;
			String query="SELECT * FROM appello";
			statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				appello=findByPrimaryKey(result.getLong("id"));
				appelli.add(appello);
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
		return appelli;
	}
	
	@Override
	public List<Appello> findAllProxy() {
		Connection connection=this.databaseData.getConnection();
		List<Appello> appelli=new ArrayList<>();
		try {
			Appello appello;
			PreparedStatement statement;
			String query="SELECT * FROM appello";
			statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				appello=findByPrimaryKeyProxy(result.getLong("id"));
				appelli.add(appello);
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
		return appelli;
	}

	@Override
	public void update(Appello appello) {
		Connection connection=this.databaseData.getConnection();
		try {	
			String update="UPDATE appello SET dataAppello=?, nomeUtenteProfessore=?, corsoId=? WHERE id=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setDate(1,  new Date(appello.getData().getTime()));
			statement.setString(2, appello.getProfessore().getNomeUtente());
			statement.setLong(3, appello.getCorso().getId());
			statement.setLong(4, appello.getId());
			statement.executeUpdate();
				
			if(appello.getStudentiIscritti()!=null)
				if(!(appello.getStudentiIscritti().isEmpty()))
					this.mappaStudenti(appello, connection);
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

	@Override
	public void delete(Appello appello) {
		Connection connection=this.databaseData.getConnection();
		try {
			String delete="DELETE FROM appello WHERE id=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setLong(1, appello.getId());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			this.removeForeignKeyFromStudenti(appello, connection);
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


	private void removeForeignKeyFromStudenti(Appello appello, Connection connection) throws SQLException {
			String update="update prenota SET idAppello=NULL WHERE idAppello=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setLong(1, appello.getId());
			statement.executeUpdate();
	}

	private void mappaStudenti(Appello appello, Connection connection) throws SQLException {
	
		StudenteDAO studenteDAO=new StudenteJDBC(databaseData);
		for(Studente studente: appello.getStudentiIscritti()) {
			if(studenteDAO.findByPrimaryKey(studente.getMatricola())==null) {
				studenteDAO.save(studente);
			}
			String prenota="select id from prenota where idAppello=? AND matricolaStudente=?";
			PreparedStatement statementPrenota=connection.prepareStatement(prenota);
			statementPrenota.setLong(1, appello.getId());
			statementPrenota.setString(2, studente.getMatricola());
			ResultSet result=statementPrenota.executeQuery();
			if(result.next()) {
				String update="update prenota SET idAppello=? WHERE id=?";
				PreparedStatement statement=connection.prepareStatement(update);		
				statement.setLong(1, appello.getId());
				statement.setLong(2, result.getLong("id"));
				statement.executeUpdate();
			}
			else {
				String aggiungi="insert into prenota(id, idAppello, matricolaStudente) values(?,?,?)";
				Long id=IdGenerator.getId(connection);
				PreparedStatement statementAggiungi=connection.prepareStatement(aggiungi);
				statementAggiungi.setLong(1, id);
				statementAggiungi.setLong(2, appello.getId());
				statementAggiungi.setString(3, studente.getMatricola());
				statementAggiungi.executeUpdate();
			}
		}
		
	}
	
	
	@Override
	public boolean controllaPrenotazione(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM prenota";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						return true;	
					}
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
		return false;
		
		
	}
	
	
	@Override
	public void aggiungiPrenotazione(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String insert="insert into prenota(id, idAppello, matricolaStudente, voto) values (?,?,?,NULL)";
			try {
				Long id=IdGenerator.getId(connection);
				PreparedStatement statement = connection.prepareStatement(insert);
				statement.setLong(1, id);
				statement.setLong(2, idAppello);
				statement.setString(3, matricola);
				statement.executeUpdate();
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
	
	
	@Override
	public void aggiungiVoto(String matricola, long idAppello, long voto) {
		Connection connection=this.databaseData.getConnection();
		String insert="insert into esame(id, idAppello, matricolaStudente, voto) values (?,?,?,?)";
		try {
			Long id=IdGenerator.getId(connection);
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			statement.setLong(2, idAppello);
			statement.setString(3, matricola);
			statement.setLong(4, voto);
			statement.executeUpdate();
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

	@Override
	public void cancellaPrenotazione(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM prenota";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						String delete="DELETE FROM prenota WHERE id=?";
						PreparedStatement statementdelete=connection.prepareStatement(delete);
						statementdelete.setLong(1, result.getLong("id"));
						connection.setAutoCommit(false);
						statementdelete.executeUpdate();
						
					}
			}
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
	
	
	@Override
	public void rifiuta(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM esame";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						String delete="DELETE FROM esame WHERE id=?";
						PreparedStatement statementdelete=connection.prepareStatement(delete);
						statementdelete.setLong(1, result.getLong("id"));
						connection.setAutoCommit(false);
						statementdelete.executeUpdate();
						
					}
			}
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
	
	
	@Override
	public void accetta(String matricola, long idAppello) {
		
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM esame";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						
						
						String delete="DELETE FROM esame WHERE id=?";
						PreparedStatement statementdelete=connection.prepareStatement(delete);
						statementdelete.setLong(1, result.getLong("id"));
						connection.setAutoCommit(false);
						statementdelete.executeUpdate();
						
						String insert="insert into libretto(id, idAppello, matricolaStudente, voto) values (?,?,?,?)";
						PreparedStatement statement1 = connection.prepareStatement(insert);
						Long id=IdGenerator.getId(connection);
						statement1.setLong(1, id);
						statement1.setLong(2, idAppello);
						statement1.setString(3, matricola);
						statement1.setLong(4, result.getLong("voto"));
						statement1.executeUpdate();
						
					}
			}
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

	@Override
	public long trovaVotoEsito(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM esame";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						return result.getLong("voto");	
					}
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
		return 0;
	}
	
	@Override
	public long trovaVotoLibretto(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM libretto";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						return result.getLong("voto");	
					}
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
		return 0;
	}
		
	
	@Override
	public boolean controllaEsame(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM esame";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						return true;	
					}
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
		return false;
		
		
	}
	
	
	@Override
	public boolean controllaLibretto(String matricola, long idAppello) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM libretto";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getLong("idAppello") == idAppello) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						return true;	
					}
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
		return false;
		
		
	}
	
}
