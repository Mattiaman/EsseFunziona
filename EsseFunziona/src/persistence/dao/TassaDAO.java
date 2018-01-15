package persistence.dao;

import java.util.List;

import model.Studente;
import model.Tassa;

public interface TassaDAO {

	public void save(Tassa tassa);
	public Tassa findByPrimaryKey(long id);
	public List<Tassa> findAll();       
	public void update(Tassa tassa);
	public void delete(Tassa tassa);
	public void inoltraTassa(Tassa tassa, Studente studente);
	public boolean getStatoTassa(Tassa tassa, Studente studente);	

}
