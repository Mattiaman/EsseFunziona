package model;

import java.io.File;

public class Bando {
	
	private File contenuto;
	private long id;
	private Admin admin;
	
	public Bando(File contenuto, long id, Admin admin) {
		super();
		this.contenuto = contenuto;
		this.id = id;
		this.admin=admin;
	}

	public Bando() {
		// TODO Auto-generated constructor stub
	}

	public Bando(File contenuto) {
		this.contenuto = contenuto;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
