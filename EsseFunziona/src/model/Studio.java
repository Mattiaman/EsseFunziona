package model;

public class Studio {

	private long id;
	private String cubo;
	private String piano;
	private double latitudine;
	private double longitudine;
	
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
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	
}
