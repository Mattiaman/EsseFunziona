package model;

import java.util.HashSet;
import java.util.Set;

public class CorsoDiLaurea {

	private long id;
	private String nome;
	private Set<Corso> corsi;
	private String facebook;
	
	public CorsoDiLaurea(String nome, Set<Corso> corsi) {
		super();
		this.nome = nome;
		this.corsi = corsi;
	}

	public CorsoDiLaurea(String nome) {
		super();
		this.nome = nome;
	}

	
	
	public CorsoDiLaurea(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public CorsoDiLaurea() {
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

	public void setNome(String name) {
		this.nome = name;
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

	public boolean esiste(Corso c) {
		for(Corso x:corsi) {
			if(x.getId()==c.getId())
				return true;
		}
		return false;
	}
	
	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

}
