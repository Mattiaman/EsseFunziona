package persistence.dao;

import java.util.List;

import model.Professore;

public interface ProfessoreDAO {

	public void save(Professore Professore);
	public Professore findByPrimaryKey(String nomeUtente);
	public List<Professore> findAll();       
	public void update(Professore Professore);
	public void delete(Professore Professore);
	public void setPassword(Professore prof, String password);	

}
