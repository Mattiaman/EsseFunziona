package model;

import java.util.Date;

public abstract class Utente {
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String email;
	private String tipo;
	
	public Utente() {
		
	}
	
	public Utente(String nome, String cognome, Date dataDiNascita, String email, String tipo) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.email = email;
		this.tipo = tipo;
	}

	public Utente(String nome, String cognome, Date dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.email = "";
		this.tipo = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
