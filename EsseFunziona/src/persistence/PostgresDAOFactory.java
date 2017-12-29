package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

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

	private static DatabaseData databaseData;
	
	static {
		try {
			//da mettere in un file
			Class.forName("org.postgresql.Driver").newInstance();
			databaseData=new DatabaseData("jdbc:postgresql://localhost:5432/Segreteria","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}


	@Override
	public AdminDAO getAdminDAO() {
		return new AdminJDBC(databaseData);
	}

	@Override
	public AppelloDAO getAppelloDAO() {
		return new AppelloJDBC(databaseData);
	}

	@Override
	public MaterialeDAO getMaterialeDAO() {
		return new MaterialeJDBC(databaseData);
	}

	@Override
	public PianoDiStudiDAO getPianoDiStudiDAO() {
		return new PianoDiStudiJDBC(databaseData);
	}

	@Override
	public ProfessoreDAO getProfessoreDAO() {
		return new ProfessoreJDBC(databaseData);
	}

	@Override
	public TassaDAO getTassaDAO() {
		return new TassaJDBC(databaseData);
	}

	@Override
	public StudenteDAO getStudenteDAO() {
		return new StudenteJDBC(databaseData);
	}

	@Override
	public CorsoDAO getCorsoDAO() {
		return new CorsoJDBC(databaseData);
	}

	@Override
	public CorsoDiLaureaDAO getCorsoDiLaureaDAO() {
		return new CorsoDiLaureaJDBC(databaseData);
	}

	@Override
	public UtilityJDBC getUtilityJDBC() {
		return new UtilityJDBC(databaseData);
	}

}