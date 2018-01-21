package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Professore extends Utente {
	
	private String nomeUtente;
	private CorsoDiLaurea corsoDiLaurea;
	private Set<Studente> studentiRicevimento;
	private int nStudentiRicevimento;
	private Set<Corso> corsiInsegnati;
	private int nCorsiInsegnati;
	private Studio studio;
	
	public Professore(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente) {
		super(nome, cognome, dataDiNascita, email, "professore");
		this.nomeUtente = nomeUtente;
	}

	public Professore(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente, CorsoDiLaurea corsoDiLaurea,
			Set<Studente> studentiRicevimento, Set<Corso> corsiInsegnati) {
		super(nome, cognome, dataDiNascita, email, "professore");
		this.nomeUtente = nomeUtente;
		this.corsoDiLaurea = corsoDiLaurea;
		this.studentiRicevimento = studentiRicevimento;
		this.nStudentiRicevimento = studentiRicevimento.size();
		this.corsiInsegnati = corsiInsegnati;
		this.nCorsiInsegnati = corsiInsegnati.size();
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

	public CorsoDiLaurea getCorsoDiLaurea() {
		return corsoDiLaurea;
	}

	public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
		this.corsoDiLaurea = corsoDiLaurea;
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

	public Set<Corso> getCorsiInsegnati() {
		return corsiInsegnati;
	}

	public void setCorsiInsegnati(Set<Corso> corsiInsegnati) {
		this.corsiInsegnati = corsiInsegnati;
		nCorsiInsegnati=corsiInsegnati.size();
	}

	public int getnCorsiInsegnati() {
		return nCorsiInsegnati;
	}

	public void setnCorsiInsegnati(int nCorsiInsegnati) {
		this.nCorsiInsegnati = nCorsiInsegnati;
	}
	
	public void addCorso(Corso corso) {
		if(corsiInsegnati==null) {
			corsiInsegnati=new HashSet<Corso>();
		}
		corsiInsegnati.add(corso);
		nCorsiInsegnati=corsiInsegnati.size();
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}
	
	
}
