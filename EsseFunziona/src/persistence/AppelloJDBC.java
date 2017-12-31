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
	public void update(Appello appello) {
		Connection connection=this.databaseData.getConnection();
		try {	
			String update="UPDATE appello SET data=? nomeUtenteProfessore=?, corsoId=? WHERE id=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setLong(1, appello.getId());
			statement.setDate(2,  new Date(appello.getData().getTime()));
			statement.setString(3, appello.getProfessore().getNomeUtente());
			statement.setLong(4, appello.getCorso().getId());
			statement.executeQuery();
				
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
			//this.removeForeignKeyFromProfessore(appello, connection);
			//this.removeForeignKeyFromCorso(appello, connection);
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

	/*
	private void removeForeignKeyFromProfessore(Appello appello, Connection connection) throws SQLException {
		Professore professore = appello.getProfessore();
		String update="update pubblica SET idAppello=NULL WHERE nomeUtenteProfessore=?";
		PreparedStatement statement=connection.prepareStatement(update);
		statement.setString(1, professore.getNomeUtente());
		statement.executeUpdate();
		
	}
	
	private void removeForeignKeyFromCorso(Appello appello, Connection connection) throws SQLException {
		Corso corso = appello.getCorso();
		String update="update relativoA SET idAppello=NULL WHERE idCorso=?";
		PreparedStatement statement=connection.prepareStatement(update);
		statement.setLong(1, corso.getId());
		statement.executeUpdate();
		
	}	
*/
	private void removeForeignKeyFromStudenti(Appello appello, Connection connection) throws SQLException {
		for(Studente studente: appello.getStudentiIscritti()) {
			String update="update prenota SET idAppello=NULL WHERE matricolaStudente=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setString(1, studente.getMatricola());
			statement.executeUpdate();
		}
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
				statementPrenota.setLong(1, appello.getId());
				statementPrenota.setLong(2, result.getLong("id"));
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
	
	
}
