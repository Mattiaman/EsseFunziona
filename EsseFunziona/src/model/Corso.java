package model;

public class Corso {

	private long id;
	private String nome;
	
	public Corso(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Corso() {
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
	
}
