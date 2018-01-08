package persistence.dao;

import java.util.List;

import model.Studente;
import persistence.DatiStudente;

public interface StudenteDAO {

	public void save(Studente studente);
	public Studente findByPrimaryKey(String matricola);
	public List<Studente> findAll();       
	public void update(Studente studente);
	public void delete(Studente studente);	
	public DatiStudente findByPrimaryKeyData(String matricola);
	
	public void setPassword(Studente studente, String password);

}
