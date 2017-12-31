package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Corso;
import model.CorsoDiLaurea;
import persistence.dao.CorsoDAO;
import persistence.dao.CorsoDiLaureaDAO;

public class CorsoDiLaureaJDBC implements CorsoDiLaureaDAO {

	private DatabaseData databaseData;
	
	public CorsoDiLaureaJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(CorsoDiLaurea corsoDiLaurea) {

		if ( (corsoDiLaurea.getCorsi() == null) 
				|| corsoDiLaurea.getCorsi().isEmpty()){
			try {
				throw new SQLException("Corso di laurea non memorizzato: un corso di laurea deve avere almeno un corso");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Connection connection = this.databaseData.getConnection();
		
		try {
			Long id = IdGenerator.getId(connection);
			corsoDiLaurea.setId(id);
			String insert="insert into corsoDiLaurea(id, nome) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, corsoDiLaurea.getId());
			statement.setString(2, corsoDiLaurea.getName());
			statement.executeUpdate();
			
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
				corsoDiLaurea.setName(resultSet.getString("nome"));
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
			String update = "update corso SET nome = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, corsoDiLaurea.getName());
			statement.setLong(2, corsoDiLaurea.getId());

			statement.executeUpdate();
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
			statement.setLong(2, corsoDiLaurea.getId());

			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			this.removeForeignKeyFromCorso(corsoDiLaurea, connection);
			
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
		for (Corso corso : corsodilaurea.getCorsi()) {
			String update = "update appartieneA SET idCorsodilaurea = NULL WHERE idCorso = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, corso.getId());
			statement.executeUpdate();
		}	
	}
	
	private void mappaCorsi(CorsoDiLaurea corsodilaurea, Connection connection) throws SQLException {
		CorsoDAO corsodao = new CorsoJDBC(databaseData);
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
