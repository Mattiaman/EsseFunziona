package persistence.dao;

import java.util.List;

import model.Appello;

public interface AppelloDAO {

	public void save(Appello appello);
	public Appello findByPrimaryKey(long id);
	public List<Appello> findAll();       
	public void update(Appello appello);
	public void delete(Appello appello);	

}
