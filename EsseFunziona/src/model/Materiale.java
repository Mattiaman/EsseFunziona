package model;

import java.io.File;

public class Materiale {
	
	private File contenuto;
	private long id;
	private Professore professore;
	
	public Materiale(File contenuto, long id, Professore professore) {
		super();
		this.contenuto = contenuto;
		this.id = id;
		this.professore=professore;
	}

	public File getContenuto() {
		return contenuto;
	}

	public void setContenuto(File contenuto) {
		this.contenuto = contenuto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Professore getProfessore() {
		return professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
	}
	
}
