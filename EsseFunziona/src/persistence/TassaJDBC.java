package persistence;

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
		// TODO Auto-generated method stub

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
