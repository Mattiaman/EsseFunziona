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

public class CorsoJDBC implements CorsoDAO {

	private DatabaseData databaseData;
	
	public CorsoJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}
	
	@Override
	public void save(Corso corso) {

		Connection connection = this.databaseData.getConnection();
		try {
			Long id = IdGenerator.getId(connection);
			corso.setId(id); 
			String insert = "insert into corso(id, nome) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, corso.getId());
			statement.setString(2, corso.getNome());

			statement.executeUpdate();
			//connection.commit();
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
	public Corso findByPrimaryKey(long id) {
		Connection connection = this.databaseData.getConnection();
		Corso corso = null;
		try {
			PreparedStatement statement;
			String query = "select * from corso where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				corso = new Corso();
				corso.setId(result.getLong("id"));				
				corso.setNome(result.getString("nome"));
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
		return corso;
	}

	@Override
	public List<Corso> findAll() {
		Connection connection = this.databaseData.getConnection();
		List<Corso> corsi = new ArrayList<>();
		try {			
			Corso corso;
			PreparedStatement statement;
			String query = "select * from corso";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				corso = findByPrimaryKey(result.getLong("id"));
				corsi.add(corso);
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
		return corsi;
	}

	@Override
	public void update(Corso corso) {
		Connection connection = this.databaseData.getConnection();
		try {
			String update = "update corso SET nome = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, corso.getNome());
			statement.setLong(2, corso.getId());
			statement.executeUpdate();
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
	public void delete(Corso corso) {
		Connection connection = this.databaseData.getConnection();
		try {
			String delete = "delete FROM corso WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, corso.getId());

			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			removeForeignKeyFromAppartieneA(corso, connection);
			removeForeignKeyFromContiene(corso, connection);
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

	private void removeForeignKeyFromAppartieneA(Corso corso, Connection connection) throws SQLException {
			String update = "update appartieneA SET idCorso = NULL WHERE idCorso = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, corso.getId());
			statement.executeUpdate();	
	}
	
	private void removeForeignKeyFromContiene(Corso corso, Connection connection) throws SQLException {
		String update = "update contiene SET idCorso = NULL WHERE idCorso = ?";
		PreparedStatement statement = connection.prepareStatement(update);
		statement.setLong(1, corso.getId());
		statement.executeUpdate();	
	}
}
