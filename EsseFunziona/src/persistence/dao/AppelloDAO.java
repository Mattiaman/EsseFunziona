package persistence.dao;

import java.util.List;

import model.Appello;

public interface AppelloDAO {

	public void save(Appello appello);
	public Appello findByPrimaryKey(long id);
	public List<Appello> findAll();       
	public void update(Appello appello);
	public void delete(Appello appello);
	Appello findByPrimaryKeyProxy(long id);
	List<Appello> findAllProxy();
	void aggiungiPrenotazione(String matricola, long idAppello);
	void aggiungiVoto(String matricola, long idAppello, long voto);
	public boolean controllaPrenotazione(String matricola, long idAppello);
	public void cancellaPrenotazione(String matricola, long idAppello);
	public void rifiuta(String matricola, long idAppello);
	public void accetta(String matricola, long idAppello);
	public long trovaVotoLibretto(String matricola, long idAppello);
	public long trovaVotoEsito(String matricola, long idAppello);	

}
