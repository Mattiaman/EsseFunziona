package persistence.dao;

import java.util.List;

import model.CorsoDiLaurea;

public interface CorsoDiLaureaDAO {

	public void save(CorsoDiLaurea corsoDiLaurea);
	public CorsoDiLaurea findByPrimaryKey(long id);
	public List<CorsoDiLaurea> findAll();       
	public void update(CorsoDiLaurea corsoDiLaurea);
	public void delete(CorsoDiLaurea corsoDiLaurea);	

}
