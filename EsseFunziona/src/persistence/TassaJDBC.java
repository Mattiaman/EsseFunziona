package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Tassa;
import persistence.dao.TassaDAO;

public class TassaJDBC implements TassaDAO {

	private DatabaseData databaseData;
	
	public TassaJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(Tassa tassa) {
		Connection connection=this.databaseData.getConnection();
		try {
			String insert="insert into tassa(id, importo, nome, descrizione, nomeUtenteAdmin) values(?,?,?,?,?)";
			
			PreparedStatement statement=connection.prepareStatement(insert);
			statement.setLong(1, IdGenerator.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Tassa findByPrimaryKey(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tassa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tassa tassa) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Tassa tassa) {
		// TODO Auto-generated method stub

	}

}
