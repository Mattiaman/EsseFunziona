package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Corso;
import model.PianoDiStudi;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.PianoDiStudiDAO;

public class PianoDiStudiJDBC implements PianoDiStudiDAO {

	private DatabaseData databaseData;
	
	public PianoDiStudiJDBC(DatabaseData databaseData) {
		super();
		this.databaseData = databaseData;
	}

	@Override
	public void save(PianoDiStudi pianoDiStudi) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {
			String insert="insert into pianoDiStudi(id, nome, corsoDiLaureaId) values(?,?,?)";
			pianoDiStudi.setId(IdGenerator.getId(connection));
			PreparedStatement statement=connection.prepareStatement(insert);
			statement.setLong(1, pianoDiStudi.getId());
			statement.setString(2, pianoDiStudi.getNome());
			statement.setLong(3, pianoDiStudi.getCorsoDiLaurea().getId());
			statement.executeUpdate();
			
			this.mappaCorsi(pianoDiStudi, connection);
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
	public PianoDiStudi findByPrimaryKey(long id) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		PianoDiStudi pianoDiStudi=null;
		try {
			String query="select * from pianoDiStudi where id=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet resultSet=statement.executeQuery();
			if(resultSet.next()) {
				pianoDiStudi=new PianoDiStudi();
				pianoDiStudi.setId(resultSet.getLong("id"));
				pianoDiStudi.setNome(resultSet.getString("nome"));
				CorsoDiLaureaDAO cdlDAO=new CorsoDiLaureaJDBC(this.databaseData);
				pianoDiStudi.setCorsoDiLaurea(cdlDAO.findByPrimaryKey(resultSet.getLong("corsoDiLaureaId")));
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
		return pianoDiStudi;
	}

	@Override
	public List<PianoDiStudi> findAll() {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		List<PianoDiStudi> piani=new ArrayList<PianoDiStudi>();
		PianoDiStudi pds;
		try {
			String query="select * from pianoDiStudi";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				pds=findByPrimaryKey(result.getLong("id"));
				piani.add(pds);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		
		return piani;
	}

	@Override
	public void update(PianoDiStudi pianoDiStudi) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {
			String update="update pianoDiStudi SET nome=?, corsoDiLaureaId=? where id=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setString(1, pianoDiStudi.getNome());
			statement.setLong(2, pianoDiStudi.getCorsoDiLaurea().getId());
			statement.setLong(3, pianoDiStudi.getId());
			statement.executeUpdate();
			this.mappaCorsi(pianoDiStudi, connection);
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
	public void delete(PianoDiStudi pianoDiStudi) {
		// TODO Auto-generated method stub
		Connection connection= this.databaseData.getConnection();
		try {
			String delete="delete FROM pianoDiStudi where id=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setLong(1, pianoDiStudi.getId());
			
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			this.removeForeignKeyFromCorso(pianoDiStudi, connection);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void removeForeignKeyFromCorso(PianoDiStudi pianoDiStudi, Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		for (Corso corso : pianoDiStudi.getCorsi()) {
			String update = "update contiene SET idPianoDiStudi = NULL WHERE idCorso = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, corso.getId());
			statement.executeUpdate();
		}	
	}

	private void mappaCorsi(PianoDiStudi pianoDiStudi, Connection connection) throws SQLException {

		CorsoJDBC corsoJDBC=new CorsoJDBC(databaseData);
		for(Corso corso:pianoDiStudi.getCorsi()) {
			if(corsoJDBC.findByPrimaryKey(corso.getId())==null) {
				corsoJDBC.save(corso);
			}
			String contiene="select id from contiene where idCorso=? AND idPianoDiStudi=?";
			PreparedStatement statementContiene=connection.prepareStatement(contiene);
			statementContiene.setLong(1, corso.getId());
			statementContiene.setLong(2, pianoDiStudi.getId());
			ResultSet result=statementContiene.executeQuery();
			if(result.next()) {
				String update="update contiene SET idPianoDiStudi=? where id=?";
				PreparedStatement statement=connection.prepareStatement(update);
				statement.setLong(1, pianoDiStudi.getId());
				statement.setLong(2, result.getLong("id"));
				statement.executeUpdate();
			}else {
				String aggiungi="insert into contiene(id, idCorso, idPianoDiStudi) values(?,?,?)";
				PreparedStatement addStatement=connection.prepareStatement(aggiungi);
				addStatement.setLong(1, IdGenerator.getId(connection));
				addStatement.setLong(2, corso.getId());
				addStatement.setLong(3, pianoDiStudi.getId());
				addStatement.executeUpdate();
			}
		}
	}
}






