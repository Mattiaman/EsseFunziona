package model;

public class Tassa {
	private long id;
	private float importo;
	private String nome;
	private String descrizione;
	private Studente intestatario;
	private boolean pagata;
	private Admin admin;
	
	public Tassa(long id, float importo, String nome, String descrizione, Studente intestatario, boolean pagata, Admin admin) {
		super();
		this.id = id;
		this.importo = importo;
		this.nome = nome;
		this.descrizione = descrizione;
		this.intestatario = intestatario;
		this.pagata = pagata;
		this.admin=admin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Studente getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(Studente intestatario) {
		this.intestatario = intestatario;
	}

	public boolean isPagata() {
		return pagata;
	}

	public void setPagata(boolean pagata) {
		this.pagata = pagata;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
