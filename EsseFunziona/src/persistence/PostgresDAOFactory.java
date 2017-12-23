package persistence;

import persistence.dao.AdminDAO;
import persistence.dao.AppelloDAO;
import persistence.dao.CorsoDAO;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.MaterialeDAO;
import persistence.dao.PianoDiStudiDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;
import persistence.dao.TassaDAO;

public class PostgresDAOFactory implements DAOFactory {

	@Override
	public AdminDAO getAdminDAO() {
		return new AdminJDBC();
	}

	@Override
	public AppelloDAO getAppelloDAO() {
		return new AppelloJDBC();
	}

	@Override
	public MaterialeDAO getMaterialeDAO() {
		return new MaterialeJDBC();
	}

	@Override
	public PianoDiStudiDAO getPianoDiStudiDAO() {
		return new PianoDiStudiJDBC();
	}

	@Override
	public ProfessoreDAO getProfessoreDAO() {
		return new ProfessoreJDBC();
	}

	@Override
	public TassaDAO getTassaDAO() {
		return new TassaJDBC();
	}

	@Override
	public StudenteDAO getStudenteDAO() {
		return new StudenteJDBC();
	}

	@Override
	public CorsoDAO getCorsoDAO() {
		return new CorsoJDBC();
	}

	@Override
	public CorsoDiLaureaDAO getCorsoDiLaureaDAO() {
		return new CorsoDiLaureaJDBC();
	}

	@Override
	public UtilityDAO getUtilityDAO() {
		return new UtilityJDBC();
	}

}
