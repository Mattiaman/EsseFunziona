package model;

public class Studio {

	private long id;
	private String cubo;
	private String piano;
	private long latitudine;
	private long longitudine;
	
	public Studio() {

	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCubo() {
		return cubo;
	}
	public void setCubo(String cubo) {
		this.cubo = cubo;
	}
	public String getPiano() {
		return piano;
	}
	public void setPiano(String piano) {
		this.piano = piano;
	}
	public long getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(long latitudine) {
		this.latitudine = latitudine;
	}
	public long getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(long longitudine) {
		this.longitudine = longitudine;
	}
	
}
