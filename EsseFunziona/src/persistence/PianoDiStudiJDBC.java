package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Corso;
import model.PianoDiStudi;
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
			String insert="insert into pianoDiStudi(id, nome) values(?,?)";
			pianoDiStudi.setId(IdGenerator.getId(connection));
			PreparedStatement statement=connection.prepareStatement(insert);
			statement.setLong(1, pianoDiStudi.getId());
			statement.setString(1, pianoDiStudi.getNome());
			statement.executeUpdate();
			
			this.mappaCorsi(pianoDiStudi, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public PianoDiStudi findByPrimaryKey(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PianoDiStudi> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PianoDiStudi pianoDiStudi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PianoDiStudi pianoDiStudi) {
		// TODO Auto-generated method stub

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






