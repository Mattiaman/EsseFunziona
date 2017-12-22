package persistence.dao;

import java.util.List;

import model.PianoDiStudi;

public interface PianoDiStudiDAO {

	public void save(PianoDiStudi pianoDiStudi);
	public PianoDiStudi findByPrimaryKey(long id);
	public List<PianoDiStudi> findAll();       
	public void update(PianoDiStudi pianoDiStudi);
	public void delete(PianoDiStudi pianoDiStudi);	

}
