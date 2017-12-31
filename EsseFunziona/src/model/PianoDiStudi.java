package model;

import java.util.HashSet;
import java.util.Set;

public class PianoDiStudi {
	private long id;
	private String nome;
	private Set<Corso> corsi;
	private CorsoDiLaurea corsoDiLaurea;
	
	public PianoDiStudi(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public PianoDiStudi(String nome, CorsoDiLaurea corsoDiLaurea) {
		super();
		this.nome = nome;
		this.corsoDiLaurea = corsoDiLaurea;
	}

	public PianoDiStudi(String nome, Set<Corso> corsi) {
		super();
		this.nome = nome;
		this.corsi = corsi;
	}

	public PianoDiStudi(String nome) {
		super();
		this.nome = nome;
	}

	public PianoDiStudi() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}
	
	public void addCorso(Corso corso) {
		if(this.corsi==null)
			corsi=new HashSet<Corso>();
		corsi.add(corso);
	}

	public CorsoDiLaurea getCorsoDiLaurea() {
		return corsoDiLaurea;
	}

	public void setCorsoDiLaurea(CorsoDiLaurea corsoDiLaurea) {
		this.corsoDiLaurea = corsoDiLaurea;
	}

}
