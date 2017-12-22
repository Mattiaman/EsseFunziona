package persistence.dao;

import java.util.List;

import model.Materiale;

public interface MaterialeDAO {

	public void save(Materiale materiale);
	public Materiale findByPrimaryKey(long id);
	public List<Materiale> findAll();       
	public void update(Materiale materiale);
	public void delete(Materiale materiale);

}
