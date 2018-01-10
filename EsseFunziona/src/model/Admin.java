package model;

import java.util.Date;

public class Admin extends Utente {
	
	private String nomeUtente;

	public Admin(String nome, String cognome, Date dataDiNascita, String email, String nomeUtente) {
		super(nome, cognome, dataDiNascita, email, "admin");
		this.nomeUtente = nomeUtente;
	}

	public Admin() {
		super("admin");
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

}
