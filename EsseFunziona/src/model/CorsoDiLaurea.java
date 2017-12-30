package model;

import java.util.HashSet;
import java.util.Set;

public class CorsoDiLaurea {

	private long id;
	private String name;
	private Set<Corso> corsi;
	
	public CorsoDiLaurea(String name, Set<Corso> corsi) {
		super();
		this.name = name;
		this.corsi = corsi;
	}

	public CorsoDiLaurea(String name) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
