package persistence.dao;

import java.util.List;

import model.PianoDiStudi;
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
	public void sendRichiestaModificaPds(Studente studente, PianoDiStudi pianoNuovo);
	public PianoDiStudi getRichiestaModificaPds(Studente studente);
	public List<Studente> findAllRichiedentiModifica();
	public void setPianoDiStudi(Studente studente, PianoDiStudi pds);

}
