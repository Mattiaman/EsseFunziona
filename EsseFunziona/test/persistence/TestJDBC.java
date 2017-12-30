package persistence;

import persistence.dao.*;

import java.util.HashSet;
import java.util.Set;

import model.*;

public class TestJDBC {
	public static void main(String[] args) {
		DAOFactory factory= new PostgresDAOFactory();
		
		UtilityJDBC utility=factory.getUtilityJDBC();
		utility.dropDatabase();
		utility.createDatabase();
		
		StudenteDAO studenteDAO=factory.getStudenteDAO();
		ProfessoreDAO professoreDAO=factory.getProfessoreDAO();
		AdminDAO adminDAO=factory.getAdminDAO();
		CorsoDiLaureaDAO corsoDiLaureaDAO=factory.getCorsoDiLaureaDAO();
		PianoDiStudiDAO pianoDiStudiDAO=factory.getPianoDiStudiDAO();
		CorsoDAO corsoDAO=factory.getCorsoDAO();
		MaterialeDAO materialeDAO=factory.getMaterialeDAO();
		AppelloDAO appelloDAO=factory.getAppelloDAO();
		
		//creazione Corsi
		Corso fondamentiDiInformatica=new Corso("Fondamenti di Informatica");
		Corso programmazioneAdOggetti=new Corso("Programmazione ad Oggetti");
		Corso storiaRomana=new Corso("Storia Romana");
		Corso inglese=new Corso("Inglese");
		
		//creazione Corsi Di Laurea
		Set<Corso> inf=new HashSet<Corso>();
		inf.add(fondamentiDiInformatica);
		inf.add(programmazioneAdOggetti);
		inf.add(inglese);
		CorsoDiLaurea cdlInformatica=new CorsoDiLaurea("Corso di Laurea in Informatica", inf);
		CorsoDiLaurea cdlStoria=new CorsoDiLaurea("Corso di Laurea in Storia");
		cdlStoria.addCorso(storiaRomana);
		cdlStoria.addCorso(inglese);
	}
}
