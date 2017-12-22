package persistence.dao;

import java.util.List;

import model.Tassa;

public interface TassaDAO {

	public void save(Tassa tassa);
	public Tassa findByPrimaryKey(long id);
	public List<Tassa> findAll();       
	public void update(Tassa tassa);
	public void delete(Tassa tassa);	

}
