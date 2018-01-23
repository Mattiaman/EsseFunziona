package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Appello;
import model.Corso;
import model.CorsoDiLaurea;
import persistence.dao.CorsoDAO;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.ProfessoreDAO;

public class CorsoDiLaureaJDBC implements CorsoDiLaureaDAO {

	private DatabaseData databaseData;
	
	public CorsoDiLaureaJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(CorsoDiLaurea corsoDiLaurea) {

		Connection connection = this.databaseData.getConnection();
		
		try {
			Long id = IdGenerator.getId(connection);
			corsoDiLaurea.setId(id);
			String insert="insert into corsoDiLaurea(id, nome,facebook) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, corsoDiLaurea.getId());
			statement.setString(2, corsoDiLaurea.getNome());
			statement.setString(3, corsoDiLaurea.getFacebook());
			statement.executeUpdate();
			
			if(corsoDiLaurea.getCorsi()!=null)
				if(!(corsoDiLaurea.getCorsi().isEmpty()))
					this.mappaCorsi(corsoDiLaurea, connection);
			
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
	public CorsoDiLaurea findByPrimaryKey(long id) {

		Connection connection = this.databaseData.getConnection();
		CorsoDiLaurea corsoDiLaurea = null;
		try {
			PreparedStatement statement;
			String query = "select * from corsoDiLaurea where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				corsoDiLaurea = new CorsoDiLaurea();
				corsoDiLaurea.setId(resultSet.getLong("id"));
				corsoDiLaurea.setNome(resultSet.getString("nome"));
				corsoDiLaurea.setFacebook(resultSet.getString("facebook"));
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
		return corsoDiLaurea;
	}
	
	
	@Override
	public CorsoDiLaurea findByPrimaryKeyProxy(long id) {
		Connection connection=this.databaseData.getConnection();
		CorsoDiLaurea cdl=null;
		try {
			PreparedStatement statement;
			String query="SELECT * FROM corsoDiLaurea WHERE id=?";
			statement=connection.prepareStatement(query);
			statement.setLong(1,id);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				cdl=new CorsoDiLaureaProxy(databaseData);
				cdl.setId(result.getLong("id"));
				cdl.setNome(result.getString("nome"));
				cdl.setFacebook(result.getString("facebook"));
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
		return cdl;
	}
	

	@Override
	public List<CorsoDiLaurea> findAll() {
		
		Connection connection = this.databaseData.getConnection();
		List<CorsoDiLaurea> corsidilaurea = new ArrayList<>();
		try {			
			CorsoDiLaurea corsoDiLaurea;
			PreparedStatement statement;
			String query = "select * from corsoDiLaurea";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				corsoDiLaurea = findByPrimaryKey(result.getLong("id"));
				corsidilaurea.add(corsoDiLaurea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return corsidilaurea;
	}

	@Override
	public void update(CorsoDiLaurea corsoDiLaurea) {

		Connection connection = this.databaseData.getConnection();
		try {
			String update = "update corsoDiLaurea SET nome = ? AND facebook = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, corsoDiLaurea.getNome());
			statement.setString(2, corsoDiLaurea.getFacebook());
			statement.setLong(3, corsoDiLaurea.getId());

			statement.executeUpdate();
			
			if(corsoDiLaurea.getCorsi()!=null)
					this.mappaCorsi(corsoDiLaurea, connection);
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					e.printStackTrace();
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(CorsoDiLaurea corsoDiLaurea) {

		Connection connection = this.databaseData.getConnection();
		try {
			String delete = "delete FROM corsoDiLaurea WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, corsoDiLaurea.getId());

			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			this.removeForeignKeyFromCorso(corsoDiLaurea, connection);
			this.removeForeignKeyFromPianoDiStudi(corsoDiLaurea, connection);
			this.removeForeignKeyFromStudente(corsoDiLaurea, connection);
			this.removeForeignKeyFromAppartieneA(corsoDiLaurea, connection);
			
			statement.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}


	private void removeForeignKeyFromCorso(CorsoDiLaurea corsodilaurea, Connection connection) throws SQLException {
		String update = "update appartieneA SET idCorsodilaurea = NULL WHERE idCorso = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setLong(1, corsodilaurea.getId());
		statement.executeUpdate();	
	}
	
	private void removeForeignKeyFromPianoDiStudi(CorsoDiLaurea corsodilaurea, Connection connection) throws SQLException {
		String update = "update pianoDiStudi SET corsoDiLaureaId = NULL WHERE corsoDiLaureaId = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setLong(1, corsodilaurea.getId());
		statement.executeUpdate();	
	}

	private void removeForeignKeyFromStudente(CorsoDiLaurea corsodilaurea, Connection connection) throws SQLException {
		String update = "update studente SET corsoDiLaureaId = NULL WHERE corsoDiLaureaId = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setLong(1, corsodilaurea.getId());
		statement.executeUpdate();	
	}
	
	private void removeForeignKeyFromAppartieneA(CorsoDiLaurea corsodilaurea, Connection connection) throws SQLException {
		String update = "update appartieneA SET idCorsoDiLaurea = NULL WHERE idCorsoDiLaurea = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setLong(1, corsodilaurea.getId());
		statement.executeUpdate();	
	}


	private void mappaCorsi(CorsoDiLaurea corsodilaurea, Connection connection) throws SQLException {
		CorsoDAO corsodao = new CorsoJDBC(databaseData);
		
		String del="delete from appartieneA where idCorsoDiLaurea=?";
		PreparedStatement stat=connection.prepareStatement(del);
		stat.setLong(1, corsodilaurea.getId());
		stat.executeUpdate();
		for (Corso corso : corsodilaurea.getCorsi()) {
			if (corsodao.findByPrimaryKey(corso.getId()) == null){
				corsodao.save(corso);
			}
			String afferisce = "select id from appartieneA where idCorso=? AND idCorsodilaurea=?";
			PreparedStatement statementAfferisce = connection.prepareStatement(afferisce);
			statementAfferisce.setLong(1, corso.getId());
			statementAfferisce.setLong(2, corsodilaurea.getId());
			ResultSet result = statementAfferisce.executeQuery();
			if(result.next()){
				String update = "update appartieneA SET idCorsodilaurea = ? WHERE id = ?";
				PreparedStatement statement = connection.prepareStatement(update);
				statement.setLong(1, corsodilaurea.getId());
				statement.setLong(2, result.getLong("id"));
				statement.executeUpdate();
			}else{			
				String iscrivi = "insert into appartieneA(id, idCorso, idCorsodilaurea) values (?,?,?)";
				PreparedStatement statementIscrivi = connection.prepareStatement(iscrivi);
				Long id = IdGenerator.getId(connection);
				statementIscrivi.setLong(1, id);
				statementIscrivi.setLong(2, corso.getId());
				statementIscrivi.setLong(3, corsodilaurea.getId());
				statementIscrivi.executeUpdate();
			}
		}
	}
	
	
	
}
