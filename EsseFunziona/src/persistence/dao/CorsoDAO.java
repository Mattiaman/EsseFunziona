package persistence.dao;

import java.util.List;

import model.Corso;

public interface CorsoDAO {

	public void save(Corso corso);
	public Corso findByPrimaryKey(long id);
	public List<Corso> findAll();       
	public void update(Corso corso);
	public void delete(Corso corso);	

}
