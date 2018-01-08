package persistence.dao;

import java.util.List;

import model.Admin;
import model.Studente;
import persistence.DatiAdmin;
import persistence.DatiStudente;

public interface AdminDAO {

	public void save(Admin admin);
	public Admin findByPrimaryKey(String nomeUtente);
	public List<Admin> findAll();       
	public void update(Admin admin);
	public void delete(Admin admin);	
	public DatiAdmin findByPrimaryKeyData(String nomeUtente);

	public void setPassword(Admin admin, String password);
}
