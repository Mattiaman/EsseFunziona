package persistence;

import persistence.dao.AdminDAO;
import persistence.dao.AppelloDAO;
import persistence.dao.BandoDAO;
import persistence.dao.CorsoDAO;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.MaterialeDAO;
import persistence.dao.PianoDiStudiDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;
import persistence.dao.TassaDAO;

public interface DAOFactory {
	
	public abstract AdminDAO getAdminDAO();

	public abstract AppelloDAO getAppelloDAO();

	public abstract MaterialeDAO getMaterialeDAO();
	
	public abstract BandoDAO getBandoDAO();
	
	public abstract PianoDiStudiDAO getPianoDiStudiDAO();

	public abstract ProfessoreDAO getProfessoreDAO();
	
	public abstract TassaDAO getTassaDAO();

	public abstract StudenteDAO getStudenteDAO();
		
	public abstract CorsoDAO getCorsoDAO();
	
	public abstract CorsoDiLaureaDAO getCorsoDiLaureaDAO();
	
	public abstract UtilityJDBC getUtilityJDBC();

	
}
