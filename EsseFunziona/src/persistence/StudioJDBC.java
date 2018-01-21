package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Studio;
import model.CorsoDiLaurea;
import model.Studio;
import persistence.dao.CorsoDAO;

public class StudioJDBC implements StudioDAO {

	private DatabaseData databaseData;
	
	public StudioJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(Studio studio) {

		Connection connection = this.databaseData.getConnection();
		try {
			Long id = IdGenerator.getId(connection);
			studio.setId(id); 
			String insert = "insert into studio(id, cubo, pano, lat, lon) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, studio.getId());
			statement.setString(2, studio.getCubo());
			statement.setString(3, studio.getPiano());
			statement.setLong(4, studio.getLatitudine());
			statement.setLong(5, studio.getLongitudine());

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
	public Studio findByPrimaryKey(long id) {
		Connection connection = this.databaseData.getConnection();
		Studio studio = null;
		try {
			PreparedStatement statement;
			String query = "select * from studio where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				studio = new Studio();
				studio.setId(result.getLong("id"));				
				studio.setCubo(result.getString("cubo"));
				studio.setPiano(result.getString("piano"));
				studio.setLatitudine(result.getLong("lat"));
				studio.setLongitudine(result.getLong("lon"));
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
		return studio;
	}

	@Override
	public List<Studio> findAll() {
		Connection connection = this.databaseData.getConnection();
		List<Studio> studi = new ArrayList<>();
		try {			
			Studio studio;
			PreparedStatement statement;
			String query = "select * from studio";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				studio = findByPrimaryKey(result.getLong("id"));
				studi.add(studio);
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
		return studi;
	}

	@Override
	public void update(Studio studio) {
		Connection connection = this.databaseData.getConnection();
		try {
			String update = "update studio SET cubo = ?, piano=?, lat=?, lon=? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, studio.getCubo());
			statement.setString(2, studio.getPiano());
			statement.setLong(3, studio.getLatitudine());
			statement.setLong(4, studio.getLongitudine());
			statement.setLong(5, studio.getId());
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
	public void delete(Studio studio) {
		Connection connection = this.databaseData.getConnection();
		try {
			String delete = "delete FROM studio WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, studio.getId());

			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			removeForeignKeyFromProfessore(studio, connection);

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

	private void removeForeignKeyFromProfessore(Studio studio, Connection connection) throws SQLException {
			String update = "update professore SET studioId = NULL WHERE studioId = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, studio.getId());
			statement.executeUpdate();	
	}
	
}
