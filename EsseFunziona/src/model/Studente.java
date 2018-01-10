package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Studente extends Utente {

	private String matricola;
	private CorsoDiLaurea corsoDiLaurea;
	private PianoDiStudi pianoDiStudi;
	private Set<Tassa> tasse;

	public Studente() {
		super("studente");
	}
	
	public Studente(String matricola, String nome, String cognome, Date dataDiNascita, String email) {
		super(nome, cognome, dataDiNascita, email, "studente");
		this.matricola=matricola;
	}


	

	public Studente(String matricola, String nome, String cognome, Date dataDiNascita) {
		super(nome, cognome, dataDiNascita);
		this.matricola = matricola;
		
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public CorsoDiLaurea getCorsoDiLaurea() {
		return corsoDiLaurea;
	}

	public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
		this.corsoDiLaurea = corsoDiLaurea;
	}

	public PianoDiStudi getPianoDiStudi() {
		return pianoDiStudi;
	}

	public void setPianoDiStudi(PianoDiStudi pianoDiStudi) {
		this.pianoDiStudi = pianoDiStudi;
	}

	public Set<Tassa> getTasse() {
		if(this.tasse== null) {
			tasse=new HashSet<Tassa>();
		}
		return tasse;
	}

	public void setTasse(Set<Tassa> tasse) {
		this.tasse = tasse;
	}
	
	public void addTassa(Tassa tassa) {
		if(this.tasse== null) {
			tasse=new HashSet<Tassa>();
		}
		tasse.add(tassa);
	}
	
}
