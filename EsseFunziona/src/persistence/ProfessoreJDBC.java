package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Corso;
import model.CorsoDiLaurea;
import model.Professore;
import model.Studente;
import persistence.dao.CorsoDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;

public class ProfessoreJDBC implements ProfessoreDAO {
	
	private DatabaseData databaseData;

	public ProfessoreJDBC(DatabaseData databaseData) {
		this.databaseData=databaseData;
	}

	@Override
	public void save(Professore professore) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {		
			String insert="insert into professore(\"nomeUtente\", nome, cognome, dataDiNascita, email, corsoDiLaureaId, studioId) values (?,?,?,?,?,?,?)";
			PreparedStatement statement=connection.prepareStatement(insert);
			statement.setString(1, professore.getNomeUtente());
			statement.setString(2, professore.getNome());
			statement.setString(3, professore.getCognome());
			statement.setDate(4, new Date(professore.getDataDiNascita().getTime()));
			statement.setString(5, professore.getEmail());
			statement.setLong(6, professore.getCorsoDiLaurea().getId());
			statement.setLong(7, professore.getStudio().getId());
			statement.executeUpdate();
			
			
			if(professore.getStudentiRicevimento()!=null)
				if(!professore.getStudentiRicevimento().isEmpty()) 
					this.mappaStudenti(professore, connection);
			if(professore.getCorsiInsegnati()!=null)
				if(!professore.getCorsiInsegnati().isEmpty()) 
					this.mappaCorsi(professore, connection);
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
	public Professore findByPrimaryKey(String nomeUtente) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		Professore professore=null;
		try {
			String query="select * from professore where \"nomeUtente\"=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, nomeUtente);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				professore=new Professore();
				professore.setNomeUtente(result.getString("nomeUtente"));
				professore.setNome(result.getString("nome"));
				professore.setCognome(result.getString("cognome"));
				professore.setDataDiNascita(new java.util.Date(result.getDate("dataDiNascita").getTime()));
				professore.setEmail(result.getString("email"));
				StudioJDBC studioJDBC=new StudioJDBC(databaseData);
				professore.setStudio(studioJDBC.findByPrimaryKey(result.getLong("studioId")));
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
		
		return professore;
	}

	@Override
	public List<Professore> findAll() {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		List<Professore> professori=new ArrayList<Professore>();
		Professore professore;
		try {
			String query="select * from professore";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				professore=findByPrimaryKey(result.getString("nomeUtente"));
				professori.add(professore);
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
		
		return professori;
	}
	
	@Override
	public Professore findByPrimaryKeyProxy(String nomeUtente) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		Professore professore=null;
		try {
			String query="select * from professore where \"nomeUtente\"=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, nomeUtente);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				professore=new ProfessoreProxy(databaseData);
				professore.setNomeUtente(result.getString("nomeUtente"));
				professore.setNome(result.getString("nome"));
				professore.setCognome(result.getString("cognome"));
				professore.setDataDiNascita(new java.util.Date(result.getDate("dataDiNascita").getTime()));
				professore.setEmail(result.getString("email"));
				StudioJDBC studioJDBC=new StudioJDBC(databaseData);
				professore.setStudio(studioJDBC.findByPrimaryKey(result.getLong("studioId")));
	
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
		
		return professore;
	}
	
	@Override
	public List<Professore> findAllProxy() {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		List<Professore> professori=new ArrayList<Professore>();
		Professore professore;
		try {
			String query="select * from professore";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				professore=findByPrimaryKeyProxy(result.getString("nomeUtente"));
				professori.add(professore);
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
		
		return professori;
	}

	@Override
	public void update(Professore professore) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		
		try {
			String update="update professore SET nome=?, cognome=?, dataDiNascita=?, email=? where \"nomeUtente\"=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setString(1, professore.getNome());
			statement.setString(2, professore.getCognome());
			statement.setDate(3, new Date(professore.getDataDiNascita().getTime()));
			statement.setString(4, professore.getEmail());
			statement.setString(5, professore.getNomeUtente());
			statement.executeUpdate();
			
			if(professore.getStudentiRicevimento()!=null)
				if(!professore.getStudentiRicevimento().isEmpty()) 
					this.mappaStudenti(professore, connection);
			if(professore.getCorsiInsegnati()!=null)
					this.mappaCorsi(professore, connection);
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
	public void delete(Professore professore) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {
			String delete="delete from professore where \"nomeUtente\"=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setString(1, professore.getNomeUtente());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			this.removeForeignKeyFromMateriale(professore, connection);
			this.removeForeignKeyFromAppello(professore, connection);
			this.removeForeignKeyFromInsegna(professore, connection);
			this.removeForeignKeyFromCorso(professore, connection);
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
	
	private void removeForeignKeyFromAppello(Professore professore, Connection connection) throws SQLException {
		String update = "update appello SET nomeUtenteProfessore = NULL WHERE nomeUtenteProfessore = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setString(1, professore.getNomeUtente());
		statement.executeUpdate();	
	}

	private void removeForeignKeyFromMateriale(Professore professore, Connection connection) throws SQLException {
		String update = "update materiale SET nomeUtenteProfessore = NULL WHERE nomeUtenteProfessore = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setString(1, professore.getNomeUtente());
		statement.executeUpdate();	
	}
	
	private void removeForeignKeyFromInsegna(Professore professore, Connection connection) throws SQLException {
		String update = "update insegna SET nomeUtenteProfessore = NULL WHERE nomeUtenteProfessore = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setString(1,professore.getNomeUtente());
		statement.executeUpdate();	
	}
	
	private void removeForeignKeyFromCorso(Professore professore, Connection connection) throws SQLException {
		String update = "update insegna SET nomeUtenteProfessore = NULL WHERE nomeUtenteProfessore = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setString(1,professore.getNomeUtente());
		statement.executeUpdate();	
	}
	
	public void setPassword(Professore professore, String password) {
		Connection connection = this.databaseData.getConnection();
		try {
			String update = "update professore SET password = ? WHERE \"nomeUtente\"=?";
			PreparedStatement statement;
			statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, professore.getNomeUtente());
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
	
	private void mappaStudenti(Professore professore, Connection connection) throws SQLException {
		
		StudenteDAO studenteDAO=new StudenteJDBC(databaseData);
		for(Studente studente: professore.getStudentiRicevimento()) {
			if(studenteDAO.findByPrimaryKey(studente.getMatricola())==null) {
				studenteDAO.save(studente);
			}
			String riceve="select id from riceve where nomeUtenteProfessore=? AND matricolaStudente=?";
			PreparedStatement statementRiceve=connection.prepareStatement(riceve);
			statementRiceve.setString(1,professore.getNomeUtente());
			statementRiceve.setString(2, studente.getMatricola());
			ResultSet result=statementRiceve.executeQuery();
			if(result.next()) {
				String update="update riceve SET nomeUtenteProfessore=? WHERE id=?";
				PreparedStatement statement=connection.prepareStatement(update);				
				statement.setString(1, professore.getNomeUtente());;
				statement.setLong(2, result.getLong("id"));
				statement.executeUpdate();
			}
			else {
				String aggiungi="insert into riceve(id, matricolaStudente, nomeUtenteProfessore, dataRicevimento, accettato) values(?,?,?,NULL,FALSE)";
				Long id=IdGenerator.getId(connection);
				PreparedStatement statementAggiungi=connection.prepareStatement(aggiungi);
				statementAggiungi.setLong(1, id);
				statementAggiungi.setString(2, studente.getMatricola());
				statementAggiungi.setString(3, professore.getNomeUtente());
				statementAggiungi.executeUpdate();
			}
		}
		
	}

	private void mappaCorsi(Professore professore, Connection connection) throws SQLException {
		CorsoDAO corsodao = new CorsoJDBC(databaseData);
		String del="delete from insegna where nomeUtenteProfessore=?";
		PreparedStatement stat=connection.prepareStatement(del);
		stat.setString(1, professore.getNomeUtente());
		stat.executeUpdate();
		for (Corso corso : professore.getCorsiInsegnati()) {
			if (corsodao.findByPrimaryKey(corso.getId()) == null){
				corsodao.save(corso);
			}
			String insegna = "select id from insegna where idCorso=? AND nomeUtenteProfessore=?";
			PreparedStatement statementInsegna = connection.prepareStatement(insegna);
			statementInsegna.setLong(1, corso.getId());
			statementInsegna.setString(2, professore.getNomeUtente());
			ResultSet result = statementInsegna.executeQuery();
			if(result.next()){
				String update = "update insegna SET nomeUtenteProfessore = ? WHERE id = ?";
				PreparedStatement statement = connection.prepareStatement(update);
				statement.setString(1, professore.getNomeUtente());
				statement.setLong(2, result.getLong("id"));
				statement.executeUpdate();
			}else{		
				String aggiungi = "insert into insegna(id, idCorso, nomeUtenteProfessore) values (?,?,?)";
				PreparedStatement statementAggiungi = connection.prepareStatement(aggiungi);
				Long id = IdGenerator.getId(connection);
				statementAggiungi.setLong(1, id);
				statementAggiungi.setLong(2, corso.getId());
				statementAggiungi.setString(3, professore.getNomeUtente());
				statementAggiungi.executeUpdate();
			}
		}
	}
	
	
	@Override
	public DatiProfessore findByPrimaryKeyData(String nomeUtente) {
		// TODO Auto-generated method stub
		Professore s=findByPrimaryKey(nomeUtente);
		DatiProfessore data=new DatiProfessore(databaseData);
		if(s!=null) {
			data.setNome(s.getNome());
			data.setCognome(s.getCognome());
			data.setDataDiNascita(s.getDataDiNascita());
			data.setEmail(s.getEmail());
			data.setNomeUtente(s.getNomeUtente());
		}
		return data;
	}

	@Override
	public void aggiungiData(String matricola, String nomeUtente, java.util.Date date) {
		Connection connection=this.databaseData.getConnection();
		String insert="insert into riceve(id, matricolaStudente, nomeUtenteProfessore, dataRicevimento, accettato) values (?,?,?,?,?)";
		try {
			Long id=IdGenerator.getId(connection);
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			statement.setString(2, matricola);
			statement.setString(3, nomeUtente);
			statement.setDate(4, new Date(date.getTime()));
			statement.setBoolean(5, true);
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
	public void cancellaRicevimento(String matricola, String nomeUtente) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM riceve";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getString("nomeUtenteProfessore").equalsIgnoreCase(nomeUtente)) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						String delete="DELETE FROM riceve WHERE id=?";
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
	public boolean controllaRicevimento(String matricola, String nomeUtente) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM riceve";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getString("nomeUtenteProfessore").equalsIgnoreCase(nomeUtente)) 
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
	public Date trovaRicevimento(String matricola, String nomeUtente) {
		Connection connection=this.databaseData.getConnection();
		String search="SELECT * FROM riceve";
		try {
			PreparedStatement statement = connection.prepareStatement(search);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				if(result.getString("nomeUtenteProfessore").equalsIgnoreCase(nomeUtente)) 
					if (result.getString("matricolaStudente").equalsIgnoreCase(matricola)) {
						return result.getDate("dataRicevimento");	
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
		return null;
	}

	
	
}