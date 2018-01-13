package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Professore extends Utente {
	
	private String nomeUtente;
	private Set<Studente> studentiRicevimento;
	private int nStudentiRicevimento;
	
	public Professore(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente) {
		super(nome, cognome, dataDiNascita, email, "professore");
		this.nomeUtente = nomeUtente;
	}

	public Professore(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente,
			Set<Studente> studentiRicevimento) {
		super(nome, cognome, dataDiNascita, email, "professore");
		this.nomeUtente = nomeUtente;
		this.studentiRicevimento = studentiRicevimento;
		this.nStudentiRicevimento = studentiRicevimento.size();
	}

	public Professore() {
		super("professore");
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public int getnStudentiRicevimento() {
		return nStudentiRicevimento;
	}

	public void setnStudentiRicevimento(int nStudentiRicevimento) {
		this.nStudentiRicevimento = nStudentiRicevimento;
	}

	public Set<Studente> getStudentiRicevimento() {
		return studentiRicevimento;
	}

	public void setStudentiRicevimento(Set<Studente> studentiRicevimento) {
		this.studentiRicevimento = studentiRicevimento;
		nStudentiRicevimento=studentiRicevimento.size();
	}
	
	public void addStudente(Studente studente) {
		if(studentiRicevimento==null) {
			studentiRicevimento=new HashSet<Studente>();
		}
		studentiRicevimento.add(studente);
		nStudentiRicevimento=studentiRicevimento.size();
	}
}
