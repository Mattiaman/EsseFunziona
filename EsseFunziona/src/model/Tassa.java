package model;

public class Tassa {
	private long id;
	private float importo;
	private String nome;
	private String descrizione;
	private Admin admin;
	
	public Tassa(long id, float importo, String nome, String descrizione, Admin admin) {
		super();
		this.id = id;
		this.importo = importo;
		this.nome = nome;
		this.descrizione = descrizione;
		this.admin=admin;
	}

	public Tassa() {
		// TODO Auto-generated constructor stub
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
