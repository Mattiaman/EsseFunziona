package persistence.dao;

import java.util.Date;
import java.util.List;

import model.Professore;
import persistence.DatiProfessore;

public interface ProfessoreDAO {

	public void save(Professore Professore);
	public Professore findByPrimaryKey(String nomeUtente);
	public List<Professore> findAll();       
	public void update(Professore Professore);
	public void delete(Professore Professore);
	public DatiProfessore findByPrimaryKeyData(String nomeUtente);
	
	public void setPassword(Professore prof, String password);	
	public void cancellaRicevimento(String matricola, String nomeUtente);
	public void creaRicevimento(String matricola, String nomeUtenteProf);
	public boolean controllaRicevimento(String matricola, String nomeUtente);
	public void aggiungiData(String matricola, String nomeUtente, Date date);

}
