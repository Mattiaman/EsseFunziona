package persistence;

import java.sql.Connection;

public class UtilityJDBC {
	private DatabaseData databaseData;
	
	public UtilityJDBC(DatabaseData databaseData) {
		this.databaseData=databaseData;
	}
	
	public void createDatabase() {
		Connection connection=databaseData.getConnection();
		
		String create=
				"create SEQUENCE idSequenza;"+
				"create table studente (matricola CHARACTER(6), nome VARCHAR(255), cognome VARCHAR(255), dataDiNascita DATE, email VARCHAR(255), corsoDiLaureaId bigint REFERENCES corsoDiLaurea(\"id\"), pianoDiStudiId bigint REFERENCES pianoDiStudi(\"id\"));"+
				"create table professore (nomeUtente VARCHAR(20), nome VARCHAR(255), cognome VARCHAR(255), dataDiNascita DATE, email VARCHAR(255));"+
				"create table admin (nomeUtente VARCHAR(20), nome VARCHAR(255), cognome VARCHAR(255), dataDiNascita DATE, email VARCHAR(255));"+
				""
	}
}
