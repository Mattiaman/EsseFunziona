package persistence.dao;

import java.util.List;

import model.Bando;

public interface BandoDAO {

	public void save(Bando bando);
	public Bando findByPrimaryKey(long id);
	public List<Bando> findAll();       
	public void update(Bando bando);
	public void delete(Bando bando);

}
