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
import java.util.List;
import java.util.Set;

import model.*;

public class TestJDBC {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		DAOFactory factory= new PostgresDAOFactory();
		
		UtilityJDBC utility=factory.getUtilityJDBC();
		utility.dropDatabase();
		utility.createDatabase();
		
//		StudenteDAO studenteDAO=factory.getStudenteDAO();
//		ProfessoreDAO professoreDAO=factory.getProfessoreDAO();
//		AdminDAO adminDAO=factory.getAdminDAO();
//		CorsoDiLaureaDAO corsoDiLaureaDAO=factory.getCorsoDiLaureaDAO();
//		PianoDiStudiDAO pianoDiStudiDAO=factory.getPianoDiStudiDAO();
//		CorsoDAO corsoDAO=factory.getCorsoDAO();
//		MaterialeDAO materialeDAO=factory.getMaterialeDAO();
//		BandoDAO bandoDAO=factory.getBandoDAO();
//		AppelloDAO appelloDAO=factory.getAppelloDAO();
//		TassaDAO tassaDAO=factory.getTassaDAO();
//		
//		//creazione Corsi
//		Corso fondamentiDiInformatica=new Corso("Fondamenti di Informatica");
//		Corso programmazioneAdOggetti=new Corso("Programmazione ad Oggetti");
//		Corso storiaRomana=new Corso("Storia Romana");
//		Corso inglese=new Corso("Inglese");
//		
//		//creazione Corsi Di Laurea
//		Set<Corso> inf=new HashSet<Corso>();
//		inf.add(fondamentiDiInformatica);
//		inf.add(programmazioneAdOggetti);
//		inf.add(inglese);
//		CorsoDiLaurea cdlInformatica=new CorsoDiLaurea("Corso di Laurea in Informatica", inf);
//		CorsoDiLaurea cdlStoria=new CorsoDiLaurea("Corso di Laurea in Storia");
//		cdlStoria.addCorso(storiaRomana);
//		cdlStoria.addCorso(inglese);
//		
//		//creazione piano di studi
//		PianoDiStudi pianoDiStudi1=new PianoDiStudi("piano1");
//		pianoDiStudi1.setCorsoDiLaurea(cdlInformatica);
//		pianoDiStudi1.addCorso(programmazioneAdOggetti);
//		pianoDiStudi1.addCorso(fondamentiDiInformatica);
//		pianoDiStudi1.addCorso(inglese);
//		pianoDiStudi1.setCorsoDiLaurea(cdlInformatica);
//		PianoDiStudi pianoDiStudi=new PianoDiStudi("piano2", cdlStoria);
//		pianoDiStudi.addCorso(inglese);
//		pianoDiStudi.addCorso(storiaRomana);
//		
//		//Creazione Admin
//		Calendar calendar1 = Calendar.getInstance();
//		calendar1.set(1990, Calendar.APRIL, 1);
//		Date date3 = calendar1.getTime();
//		
//		Admin admin1= new Admin ("admin","admin",date3,"robmat56@gmail.com","admin");
//		
//	
//		//Creazione Tasse	
//		Tassa tassa1= new Tassa(500,"tassa1","tassaIscrizione1",admin1);
//		Tassa tassa2= new Tassa(400,"tassa2","tassaIscrizione2",admin1);
//		Tassa tassa3= new Tassa(300,"tassa3","tassaIscrizione3",admin1);
//		
//		//Creazione Professore
//		//Professore prof1= new Professore("francesco","ricca",date3,"ricca@unical.it","CiccioRicca");
//		
//		
//		//Creazione studente
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(1996, Calendar.APRIL, 13);
//		Date date1 = calendar.getTime();
//
//		Studente mettiuFigo=new Studente("000000","Mattia","Cava",date1,"robmat56@hotmail.it");
//		mettiuFigo.setCorsoDiLaurea(cdlInformatica);
//		mettiuFigo.setPianoDiStudi(pianoDiStudi);
//
//		calendar.set(1996, Calendar.AUGUST, 28);
//		Date date2=calendar.getTime();
//		Studente ciuskiScemo=new Studente("000009","Luca","Quarta",date2,"ciuskifacagare@tanto.schifosamente");
//		ciuskiScemo.setCorsoDiLaurea(cdlStoria);
//		ciuskiScemo.setPianoDiStudi(pianoDiStudi1);
//		
//		Creazione materiale
//		Materiale materiale=new Materiale();
//		File file=new File(TestJDBC.class.getResource("materialeaaa.txt").getPath());
//		materiale.setContenuto(file);
//		materiale.setProfessore(prof1);
//		
//		Materiale materiale1=new Materiale();
//		materiale1.setContenuto(file);
//		materiale1.setProfessore(prof1);
//		
//		//Creazione materiale
//		Bando bando=new Bando();
//		bando.setContenuto(file);
//		bando.setAdmin(admin1);
//		
//		//Creazione appello
//		Appello appello=new Appello();
//		appello.setCorso(programmazioneAdOggetti);
//		appello.setData(date2);
//		appello.setProfessore(prof1);
//		appello.addStudente(mettiuFigo);
//		appello.addStudente(ciuskiScemo);
//		
//		//insert
//		corsoDAO.save(fondamentiDiInformatica);
//		corsoDAO.save(programmazioneAdOggetti);
//		corsoDAO.save(storiaRomana);
//		corsoDAO.save(inglese);
//		
//		corsoDiLaureaDAO.save(cdlInformatica);
//		corsoDiLaureaDAO.save(cdlStoria);
//		
//		pianoDiStudiDAO.save(pianoDiStudi);
//		pianoDiStudiDAO.save(pianoDiStudi1);
//		
//		adminDAO.save(admin1);
//
//		tassaDAO.save(tassa1);
//		tassaDAO.save(tassa2);
//		tassaDAO.save(tassa3);
//		
//		studenteDAO.save(mettiuFigo);
//		studenteDAO.save(ciuskiScemo);
//		
//		professoreDAO.save(prof1);
//		
//		materialeDAO.save(materiale);
//		materialeDAO.save(materiale1);
//		
//		bandoDAO.save(bando);
//		
//		appelloDAO.save(appello);
		
//		//find
//		Studente studenteTrovato=studenteDAO.findByPrimaryKey("000000");
//		if(studenteTrovato!=null) {
//			System.out.println("Nome: "+studenteTrovato.getNome());
//			System.out.println("Cognome: "+studenteTrovato.getCognome());
//			System.out.println("email: "+studenteTrovato.getEmail());
//		}else {
//			System.out.println("Studente non trovato");
//		}
//		
//		System.out.println("\n");
//		
//		Professore professoreTrovato=professoreDAO.findByPrimaryKey("CiccioRicca");
//		if(professoreTrovato!=null) {
//			System.out.println("Nome: "+professoreTrovato.getNome());
//			System.out.println("Cognome: "+professoreTrovato.getCognome());
//			System.out.println("email: "+professoreTrovato.getEmail());
//		}else {
//			System.out.println("Professore non trovato");
//		}
//		
//		System.out.println("\n");
//		
//		CorsoDiLaurea cdlTrovato=corsoDiLaureaDAO.findByPrimaryKey(6);
//		if(cdlTrovato!=null) {
//			System.out.println("Id: "+cdlTrovato.getId());
//			System.out.println("Nome: "+cdlTrovato.getNome());//correggere variabile da name a nome
//		}else {
//			System.out.println("CorsoDiLaurea non trovato");
//		}
//		
//		System.out.println("\n");
//		
//		Corso corsoTrovato=corsoDAO.findByPrimaryKey(2);
//		if(corsoTrovato!=null) {
//			System.out.println("Id: "+corsoTrovato.getId());
//			System.out.println("Nome: "+corsoTrovato.getNome());			
//		}else {
//			System.out.println("Corso non trovato");
//		}
//
//		System.out.println("\n");
//		
//		Tassa tassaTrovato=tassaDAO.findByPrimaryKey(20);
//		if(tassaTrovato!=null) {
//			System.out.println("Id: "+tassaTrovato.getId());
//			System.out.println("Nome: "+tassaTrovato.getNome());
//			System.out.println("Importo: "+tassaTrovato.getImporto());
//			System.out.println("Descrizione: "+tassaTrovato.getDescrizione());
//			System.out.println("Caricata da "+ tassaTrovato.getAdmin().getNome()+" "+tassaTrovato.getAdmin().getCognome());
//		}else {
//			System.out.println("Tassa non trovata");
//		}
//
//		System.out.println("\n");
//		
//		Admin adminTrovato=adminDAO.findByPrimaryKey("baubau");
//		if(adminTrovato!=null) {
//			System.out.println("Nome: "+adminTrovato.getNome());
//			System.out.println("Cognome: "+adminTrovato.getCognome());
//			System.out.println("email: "+adminTrovato.getEmail());
//		}else {
//			System.out.println("Admin non trovato");
//		}
//
//		System.out.println("\n");
//		
//		PianoDiStudi pdsTrovato=pianoDiStudiDAO.findByPrimaryKey(13);
//		if(pdsTrovato!=null) {
//			System.out.println("Id: "+pdsTrovato.getId());
//			System.out.println("Nome: "+pdsTrovato.getNome());
//			System.out.println("appartiene al "+pdsTrovato.getCorsoDiLaurea().getNome());
//		}else {
//			System.out.println("PianoDiStudi non trovato");
//		}
//
//		System.out.println("\n");
//		
//		Materiale materialeTrovato=materialeDAO.findByPrimaryKey(23);
//		if(materialeTrovato!=null) {
//			System.out.println("Id: "+materialeTrovato.getId());
//			System.out.println("File: "+materialeTrovato.getContenuto().getName());
//			System.out.println("Caricato da "+materialeTrovato.getProfessore().getNome());
//			File content=materialeTrovato.getContenuto();
//			String text="Il contenuto è:\n";
//			try {
//				BufferedReader reader=new BufferedReader(new FileReader(file));
//				String line=null;
//				while((line=reader.readLine())!=null) {
//					text+=line;
//					text+="\n";
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(text);
//		}else {
//			System.out.println("Materiale non trovato");
//		}
//
//		System.out.println("\n");
//		
//		Bando bandoTrovato=bandoDAO.findByPrimaryKey(25);
//		if(bandoTrovato!=null) {
//			System.out.println("Id: "+bandoTrovato.getId());
//			System.out.println("File: "+bandoTrovato.getContenuto().getName());
//			System.out.println("Caricato da "+bandoTrovato.getAdmin().getNome());
//			File content=bandoTrovato.getContenuto();
//			String text="Il contenuto è:\n";
//			try {
//				BufferedReader reader=new BufferedReader(new FileReader(file));
//				String line=null;
//				while((line=reader.readLine())!=null) {
//					text+=line;
//					text+="\n";
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(text);
//		}else {
//			System.out.println("Materiale non trovato");
//		}
//
//		System.out.println("\n");
//		
//		Appello appelloTrovato=appelloDAO.findByPrimaryKey(24);
//		if(appelloTrovato!=null) {
//			System.out.println("Id: "+appelloTrovato.getId());
//			System.out.println("Esame: "+appelloTrovato.getCorso().getNome());
//			System.out.println("Caricato da "+appelloTrovato.getProfessore().getNome()+" "+appelloTrovato.getProfessore().getCognome());
//			System.out.println("Da sostenere il: "+appelloTrovato.getData().toString());
//		}else {
//			System.out.println("Appello non trovato");
//		}
//		System.out.println("\n");
// 
//		//find_all
//		
//		List<Studente> studenti=studenteDAO.findAll();
//		for(Studente std:studenti) {
//			System.out.println("Nome: "+std.getNome());
//			System.out.println("Cognome: "+std.getCognome());
//			System.out.println("email: "+std.getEmail());
//			System.out.println("\n");
//		}
//		
//		System.out.println("\n");
//		
//		List<Professore> professori=professoreDAO.findAll();
//		for(Professore prof:professori) {
//			System.out.println("Nome: "+prof.getNome());
//			System.out.println("Cognome: "+prof.getCognome());
//			System.out.println("email: "+prof.getEmail());
//			System.out.println("\n");
//		}
//		
//		System.out.println("\n");
//		
//		List<CorsoDiLaurea> cdl=corsoDiLaureaDAO.findAll();
//		for(CorsoDiLaurea corsoDiLaurea:cdl) {
//			System.out.println("Nome: "+corsoDiLaurea.getNome());
//			System.out.println("\n");
//		}
//		
//		System.out.println("\n");
//		
//		List<Corso> corsi=corsoDAO.findAll();
//		for(Corso crs:corsi) {
//			System.out.println("Nome: "+crs.getNome());
//			System.out.println("\n");
//		}
//		
//		System.out.println("\n");
//		
//		List<Tassa> tasse=tassaDAO.findAll();
//		for(Tassa tss:tasse) {
//			System.out.println("Importo: "+tss.getImporto());
//			System.out.println("Nome: "+tss.getNome());
//			System.out.println("Descrizione: "+tss.getDescrizione());
//			System.out.println("admin: "+tss.getAdmin().getNomeUtente());
//			System.out.println("\n");
//		}
//		
//		System.out.println("\n");
//		
//		List<Admin> admin=adminDAO.findAll();
//		for(Admin adm:admin) {
//			System.out.println("Nome: "+adm.getNome());
//			System.out.println("Cognome: "+adm.getCognome());
//			System.out.println("email: "+adm.getEmail());
//			System.out.println("\n");
//		}
//		
//		System.out.println("\n");
//		
//		List<PianoDiStudi> pds=pianoDiStudiDAO.findAll();
//		for(PianoDiStudi piano:pds) {
//			System.out.println("Nome: "+piano.getNome());
//			System.out.println("Corso di laurea: "+piano.getCorsoDiLaurea());
//			System.out.println("\n");
//		}
//		
//		System.out.println("\n");
//		
////		List<Materiale> materiali=materialeDAO.findAll();
////		for(Materiale mtl:materiali) {
////			System.out.println("File: "+mtl.getContenuto().getName());
////			System.out.println("Caricato da "+mtl.getProfessore().getNome());
////			File content=materialeTrovato.getContenuto();
////			String text="Il contenuto è:\n";
////			try {
////				BufferedReader reader=new BufferedReader(new FileReader(file));
////				String line=null;
////				while((line=reader.readLine())!=null) {
////					text+=line;
////					text+="\n";
////				}
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			System.out.println(text);
////		}
////	
////		System.out.println("\n");
////		
////		List<Bando> bandi=bandoDAO.findAll();
////		for(Bando bnd:bandi) {
////			System.out.println("File: "+bnd.getContenuto().getName());
////			System.out.println("Caricato da "+bnd.getAdmin().getNome());
////			File content=bandoTrovato.getContenuto();
////			String text="Il contenuto è:\n";
////			try {
////				BufferedReader reader=new BufferedReader(new FileReader(file));
////				String line=null;
////				while((line=reader.readLine())!=null) {
////					text+=line;
////					text+="\n";
////				}
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			System.out.println(text);
////		}
//	
//		System.out.println("\n");
//		
//		List<Appello> appelli=appelloDAO.findAll();
//		for(Appello app:appelli) {
//			System.out.println("Esame: "+app.getCorso().getNome());
//			System.out.println("Caricato da "+app.getProfessore().getNome()+" "+app.getProfessore().getCognome());
//			System.out.println("Da sostenere il: "+app.getData().toString());
//			System.out.println("");
//		}
//	
//	
//		//Update
//		
//		String cdlpds=pianoDiStudi1.getCorsoDiLaurea().getNome();
////		String profMtl=materiale.getProfessore().getCognome();
////		String corsoApp=appello.getCorso().getNome();
//		
//		//Corsi
//		System.out.println("Nome: "+fondamentiDiInformatica.getNome());
//		fondamentiDiInformatica.setNome("fondamenti aggiornato");
//		corsoDAO.update(fondamentiDiInformatica);
//		System.out.println("Nome: "+fondamentiDiInformatica.getNome());
//		System.out.println("");
//		
//		//Corsi Di Laurea
//		System.out.println("Nome: "+cdlInformatica.getNome());
//		cdlInformatica.setNome("corso di miagolatori");
//		corsoDiLaureaDAO.update(cdlInformatica);
//		System.out.println("Nome: "+cdlInformatica.getNome());
//		System.out.println("");
//		
//		//piano di studi
//		System.out.println("Nome corso di laurea: "+cdlpds);
//		pianoDiStudi1.setCorsoDiLaurea(cdlInformatica);
//		pianoDiStudiDAO.update(pianoDiStudi1);
//		System.out.println("Nome corso di laurea: "+pianoDiStudi1.getCorsoDiLaurea().getNome());
//		System.out.println("");
//		
//		//Admin
//		System.out.println("Cognome: "+admin1.getCognome());
//		admin1.setCognome("piculapecorella");
//		adminDAO.update(admin1);
//		System.out.println("Cognome: "+admin1.getCognome());
//		System.out.println("");
//		
//		//Tasse	
//		System.out.println("Importo: "+tassa1.getImporto());
//		tassa1.setImporto(1000);
//		tassaDAO.update(tassa1);
//		System.out.println("Importo: "+tassa1.getImporto());
//		System.out.println("");
//		
//		//Professore
//		System.out.println("Cognome: "+prof1.getCognome());
//		prof1.setCognome("rich");
//		professoreDAO.update(prof1);
//		System.out.println("Cognome: "+prof1.getCognome());
//		System.out.println("");
//		
//		//studente
//		System.out.println("E-mail: "+mettiuFigo.getEmail());
//		mettiuFigo.setEmail("ciuskifigo@tantissimo.it");
//		studenteDAO.update(mettiuFigo);
//		System.out.println("E-mail: "+mettiuFigo.getEmail());
//		System.out.println("");
//		
//		//materiale
//		System.out.println("Prof materiale: "+profMtl);
//		materiale.setProfessore(prof1);
//		materialeDAO.update(materiale);
//		System.out.println("Prof materiale: "+materiale.getProfessore().getCognome());
//		System.out.println("");
//		
//		//appello
//		System.out.println("Corso Appello: "+corsoApp);
//		appello.setCorso(storiaRomana);
//		appelloDAO.update(appello);
//		System.out.println("Corso Appello: "+appello.getCorso().getNome());
//		System.out.println("");
//		
//		//delete
//		int c=1;
//		corsoDAO.delete(inglese);
//		System.out.println("delete "+(c++));
//
//		corsoDAO.delete(programmazioneAdOggetti);
//		System.out.println("delete "+(c++));
//		
//		corsoDiLaureaDAO.delete(cdlInformatica);
//		System.out.println("delete "+(c++));
//		
//		pianoDiStudiDAO.delete(pianoDiStudi);
//		System.out.println("delete "+(c++));
//
//		//pianoDiStudiDAO.delete(pianoDiStudi1);
//		//System.out.println("delete "+(c++));
//		
//		//adminDAO.delete(admin1);
//		//System.out.println("delete "+(c++));
//
//		tassaDAO.delete(tassa1);
//		System.out.println("delete "+(c++));
//		
//		tassaDAO.delete(tassa2);
//		System.out.println("delete "+(c++));
//		
//		tassaDAO.delete(tassa3);
//		System.out.println("delete "+(c++));
//		
//	//	professoreDAO.delete(prof1);
//	//	System.out.println("delete "+(c++));
//		
//		studenteDAO.delete(ciuskiScemo);
//		System.out.println("delete "+(c++));
//		
//		materialeDAO.delete(materiale);
//		System.out.println("delete "+(c++));
//
//		appelloDAO.delete(appello);
//		System.out.println("delete "+(c++));
		
	}
	
}	