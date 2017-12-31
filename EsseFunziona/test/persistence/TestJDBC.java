package persistence;

import persistence.dao.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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
		TassaDAO tassaDAO=factory.getTassaDAO();
		
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
		
		//creazione piano di studi
		PianoDiStudi pianoDiStudi1=new PianoDiStudi("piano1");
		pianoDiStudi1.setCorsoDiLaurea(cdlInformatica);
		pianoDiStudi1.addCorso(programmazioneAdOggetti);
		pianoDiStudi1.addCorso(fondamentiDiInformatica);
		pianoDiStudi1.addCorso(inglese);
		pianoDiStudi1.setCorsoDiLaurea(cdlInformatica);
		PianoDiStudi pianoDiStudi=new PianoDiStudi("piano2", cdlStoria);
		pianoDiStudi.addCorso(inglese);
		pianoDiStudi.addCorso(storiaRomana);
		
		//Creazione Admin
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(1990, Calendar.APRIL, 1);
		Date date3 = calendar1.getTime();
		
		Admin admin1= new Admin ("Snoopy","pecorella",date3,"baubau@sonofigo.it","baubau");
		
	
		//Creazione Tasse	
		Tassa tassa1= new Tassa(500,"tassa1","tassaIscrizione1",admin1);
		Tassa tassa2= new Tassa(400,"tassa2","tassaIscrizione2",admin1);
		Tassa tassa3= new Tassa(300,"tassa3","tassaIscrizione3",admin1);
		
		//Creazione Professore
		Professore prof1= new Professore("francesco","ricca",date3,"ricca@unical.it","CiccioRicca");
		
		
		//Creazione studente
		Calendar calendar = Calendar.getInstance();
		calendar.set(1996, Calendar.APRIL, 13);
		Date date1 = calendar.getTime();

		Studente mettiuFigo=new Studente("000000","Mattia","Cava",date1,"robmat56@hotmail.it");
		mettiuFigo.setCorsoDiLaurea(cdlInformatica);
		mettiuFigo.setPianoDiStudi(pianoDiStudi);

		calendar.set(1996, Calendar.AUGUST, 28);
		Date date2=calendar.getTime();
		Studente ciuskiScemo=new Studente("000009","Luca","Quarta",date2,"ciuskifacagare@tanto.schifosamente");
		ciuskiScemo.setCorsoDiLaurea(cdlStoria);
		ciuskiScemo.setPianoDiStudi(pianoDiStudi1);
		
		//Creazione materiale
		Materiale materiale=new Materiale();
		File file=new File(TestJDBC.class.getResource("materialeaaa.txt").getPath());
		materiale.setContenuto(file);
		materiale.setProfessore(prof1);
		
		//Creazione appello
		Appello appello=new Appello();
		appello.setCorso(programmazioneAdOggetti);
		appello.setData(date2);
		appello.setProfessore(prof1);
		appello.addStudente(mettiuFigo);
		appello.addStudente(ciuskiScemo);
		
		//insert
		corsoDAO.save(fondamentiDiInformatica);
		corsoDAO.save(programmazioneAdOggetti);
		corsoDAO.save(storiaRomana);
		corsoDAO.save(inglese);
		
		corsoDiLaureaDAO.save(cdlInformatica);
		corsoDiLaureaDAO.save(cdlStoria);
		
		pianoDiStudiDAO.save(pianoDiStudi);
		pianoDiStudiDAO.save(pianoDiStudi1);
		
		adminDAO.save(admin1);

		tassaDAO.save(tassa1);
		tassaDAO.save(tassa2);
		tassaDAO.save(tassa3);
		
		studenteDAO.save(mettiuFigo);
		studenteDAO.save(ciuskiScemo);
		
		professoreDAO.save(prof1);
		
		materialeDAO.save(materiale);
		
		appelloDAO.save(appello);
		
		//find
		Studente studenteTrovato=studenteDAO.findByPrimaryKey("000000");
		if(studenteTrovato!=null) {
			System.out.println("Nome: "+studenteTrovato.getNome());
			System.out.println("Cognome: "+studenteTrovato.getCognome());
			System.out.println("email: "+studenteTrovato.getEmail());
		}else {
			System.out.println("Studente non trovato");
		}
		
		System.out.println("\n");
		
		Professore professoreTrovato=professoreDAO.findByPrimaryKey("CiccioRicca");
		if(professoreTrovato!=null) {
			System.out.println("Nome: "+professoreTrovato.getNome());
			System.out.println("Cognome: "+professoreTrovato.getCognome());
			System.out.println("email: "+professoreTrovato.getEmail());
		}else {
			System.out.println("Professore non trovato");
		}
		
		System.out.println("\n");
		
		CorsoDiLaurea cdlTrovato=corsoDiLaureaDAO.findByPrimaryKey(5);
		if(cdlTrovato!=null) {
			System.out.println("Id: "+cdlTrovato.getId());
			System.out.println("Nome: "+cdlTrovato.getName());//correggere variabile da name a nome
		}else {
			System.out.println("CorsoDiLaurea non trovato");
		}
		
		System.out.println("\n");
		
		Corso corsoTrovato=corsoDAO.findByPrimaryKey(1);
		if(corsoTrovato!=null) {
			System.out.println("Id: "+corsoTrovato.getId());
			System.out.println("Nome: "+corsoTrovato.getNome());			
		}else {
			System.out.println("Corso non trovato");
		}

		System.out.println("\n");
		
		Tassa tassaTrovato=tassaDAO.findByPrimaryKey(20);
		if(tassaTrovato!=null) {
			System.out.println("Id: "+tassaTrovato.getId());
			System.out.println("Nome: "+tassaTrovato.getNome());
			System.out.println("Importo: "+tassaTrovato.getImporto());
			System.out.println("Descrizione: "+tassaTrovato.getDescrizione());
			System.out.println("Caricata da "+ tassaTrovato.getAdmin().getNome()+" "+tassaTrovato.getAdmin().getCognome());
		}else {
			System.out.println("Tassa non trovata");
		}

		System.out.println("\n");
		
		Admin adminTrovato=adminDAO.findByPrimaryKey("baubau");
		if(adminTrovato!=null) {
			System.out.println("Nome: "+adminTrovato.getNome());
			System.out.println("Cognome: "+adminTrovato.getCognome());
			System.out.println("email: "+adminTrovato.getEmail());
		}else {
			System.out.println("Admin non trovato");
		}

		System.out.println("\n");
		
		PianoDiStudi pdsTrovato=pianoDiStudiDAO.findByPrimaryKey(12);
		if(pdsTrovato!=null) {
			System.out.println("Id: "+pdsTrovato.getId());
			System.out.println("Nome: "+pdsTrovato.getNome());
			System.out.println("appartiene al "+pdsTrovato.getCorsoDiLaurea().getName());
		}else {
			System.out.println("PianoDiStudi non trovato");
		}

		System.out.println("\n");
		
		Materiale materialeTrovato=materialeDAO.findByPrimaryKey(22);
		if(materialeTrovato!=null) {
			System.out.println("Id: "+materialeTrovato.getId());
			System.out.println("File: "+materialeTrovato.getContenuto().getName());
			System.out.println("Caricato da "+materialeTrovato.getProfessore().getNome());
			File content=materialeTrovato.getContenuto();
			String text="Il contenuto è:\n";
			try {
				BufferedReader reader=new BufferedReader(new FileReader(file));
				String line=null;
				while((line=reader.readLine())!=null) {
					text+=line;
					text+="\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(text);
		}else {
			System.out.println("Materiale non trovato");
		}

		System.out.println("\n");
		
		Appello appelloTrovato=appelloDAO.findByPrimaryKey(12);
		if(appelloTrovato!=null) {
			System.out.println("Id: "+appelloTrovato.getId());
			System.out.println("Esame: "+appelloTrovato.getCorso().getNome());
			System.out.println("Caricato da "+appelloTrovato.getProfessore().getNome());
			System.out.println("Da sostenere il: "+appelloTrovato.getData().toString());
		}else {
			System.out.println("PianoDiStudi non trovato");
		}
		
	}
}
