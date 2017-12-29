package model;

import java.util.Date;

public class Professore extends Utente {
	
	private String nomeUtente;

	public Professore(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente) {
		super(nome, cognome, dataDiNascita, email);
		this.nomeUtente = nomeUtente;
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
	
}
