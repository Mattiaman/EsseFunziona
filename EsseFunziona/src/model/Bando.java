package model;

import java.io.File;
import java.io.IOException;

public class Bando {
	
	private File contenuto;
	private long id;
	private Admin admin;
	private String absolutePath;
	
	public Bando(File contenuto, long id, Admin admin) {
		super();
		this.contenuto = contenuto;
		this.id = id;
		this.admin=admin;
		try {
			this.absolutePath=contenuto.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			this.absolutePath=contenuto.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	
	
}
