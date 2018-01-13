package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Appello {
	
	private long id;
	private Date data;
	private Professore professore;
	private Corso corso;
	private Set<Studente> studentiIscritti;
	private int nStudentiIscritti;
	
	public Appello(long id, Date data, Professore professore, Corso corso, Set<Studente> studentiIscritti) {
		super();
		this.id = id;
		this.data = data;
		this.professore = professore;
		this.corso = corso;
		this.studentiIscritti = studentiIscritti;
		this.nStudentiIscritti=studentiIscritti.size();
	}

	public Appello(Date data) {
		super();
		this.data = data;
	}
	
	public Appello() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Professore getProfessore() {
		return professore;
	}

	public void setProfessore(Professore professore) {
		this.professore = professore;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Set<Studente> getStudentiIscritti() {
		return studentiIscritti;
	}
	
	public Set<Studente> getStudentiIscrittiEsame() {
		return studentiIscritti;
	}
	
	public Set<Studente> getStudentiIscrittiEsiti() {
		return studentiIscritti;
	}

	public void setStudentiIscritti(Set<Studente> studentiIscritti) {
		this.studentiIscritti = studentiIscritti;
		nStudentiIscritti=studentiIscritti.size();
	}
	
	public void addStudente(Studente studente) {
		if(studentiIscritti==null) {
			studentiIscritti=new HashSet<Studente>();
		}
		studentiIscritti.add(studente);
		nStudentiIscritti=studentiIscritti.size();
	}

	public int getnStudentiIscritti() {
		return nStudentiIscritti;
	}

	public void setnStudentiIscritti(int nStudentiIscritti) {
		this.nStudentiIscritti = nStudentiIscritti;
	}

	
}
