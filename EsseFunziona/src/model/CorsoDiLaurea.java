package model;

import java.util.Set;

public class CorsoDiLaurea {

	private long id;
	private String name;
	private Set<Corso> corsi;
	
	public CorsoDiLaurea(int id, String name, Set<Corso> corsi) {
		super();
		this.id = id;
		this.name = name;
		this.corsi = corsi;
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
	
	
}
