package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professore extends Utente {
	
	private String nomeUtente;
	List<Studente> studentiRicevimento;

	public Professore(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente) {
		super(nome, cognome, dataDiNascita, email, "professore");
		this.nomeUtente = nomeUtente;
	}

	public Professore(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente,
			List<Studente> studentiRicevimento) {
		super(nome, cognome, dataDiNascita, email, "professore");
		this.nomeUtente = nomeUtente;
		this.studentiRicevimento = studentiRicevimento;
	}

	public Professore() {
		// TODO Auto-generated constructor stub
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public List<Studente> getStudentiRicevimento() {
		return studentiRicevimento;
	}

	public void setStudentiRicevimento(List<Studente> studentiRicevimento) {
		this.studentiRicevimento = studentiRicevimento;
	}
	
	public void addStudente(Studente studente) {
		if(studentiRicevimento==null) {
			studentiRicevimento=new ArrayList<Studente>();
		}
		studentiRicevimento.add(studente);
	}
}
