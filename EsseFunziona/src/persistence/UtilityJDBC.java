package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilityJDBC {
	private DatabaseData databaseData;
	
	public UtilityJDBC(DatabaseData databaseData) {
		this.databaseData=databaseData;
	}
	
	public void createDatabase() {
		Connection connection=databaseData.getConnection();
		
		try {
			String create=
					"create SEQUENCE idSequenza;"+
					"create table pianoDiStudi(\"id\" bigint primary key, nome VARCHAR(255));"+
					"create table corsoDiLaurea(\"id\" bigint primary key, nome VARCHAR(255));"+
					"create table studente (\"matricola\" CHARACTER(6) primary key, nome VARCHAR(255), cognome VARCHAR(255), dataDiNascita DATE, email VARCHAR(255), corsoDiLaureaId bigint REFERENCES corsoDiLaurea(\"id\"), pianoDiStudiId bigint REFERENCES pianoDiStudi(\"id\"), password VARCHAR(20));"+
					"create table professore (\"nomeUtente\" VARCHAR(20) primary key, nome VARCHAR(255), cognome VARCHAR(255), dataDiNascita DATE, email VARCHAR(255), password VARCHAR(20));"+
					"create table admin (\"nomeUtente\" VARCHAR(20) primary key, nome VARCHAR(255), cognome VARCHAR(255), dataDiNascita DATE, email VARCHAR(255), password VARCHAR(20));"+
					"create table tassa(\"id\" bigint primary key, \"importo\" real, nome VARCHAR(255), descrizione VARCHAR(255), nomeUtenteAdmin VARCHAR(20) REFERENCES admin(\"nomeUtente\"));"+
					"create table corso(\"id\" bigint primary key, nome VARCHAR(255));"+
					"create table materiale(\"id\" bigint primary key, contenuto bytea, nomeUtenteProfessore VARCHAR(20) REFERENCES professore(\"nomeUtente\"));"+
					"create table appello(\"id\" bigint primary key, dataAppello DATE, nomeUtenteProfessore VARCHAR(20) REFERENCES professore(\"nomeUtente\"), corsoId bigint REFERENCES corso(\"id\"));"+
					"create table devePagare(\"id\" bigint primary key, matricolaStudente CHARACTER(6) REFERENCES studente(\"matricola\"), idTassa bigint REFERENCES tassa(\"id\"), pagata boolean);"+
					"create table appartieneA(\"id\" bigint primary key, idCorso bigint REFERENCES corso(\"id\"), idCorsoDiLaurea bigint REFERENCES corsoDiLaurea(\"id\"));"+
					"create table contiene(\"id\" bigint primary key, idCorso bigint REFERENCES corso(\"id\"), idPianoDiStudi bigint REFERENCES pianoDiStudi(\"id\"));"+
					"create table prenota(\"id\" bigint primary key, idAppello bigint REFERENCES appello(\"id\"), matricolaStudente CHARACTER(6) REFERENCES studente(\"matricola\"), dataPrenotazione DATE);";
			
			PreparedStatement statement=connection.prepareStatement(create);
			statement.executeUpdate();
			System.out.println("creato database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void dropDatabase() {
		Connection connection=databaseData.getConnection();
		
		try {
			String drop=
					"drop SEQUENCE if EXISTS idSequenza CASCADE;"+
					"drop table if exists studente CASCADE;"+
					"drop table if exists professore CASCADE;"+
					"drop table if exists admin CASCADE;"+
					"drop table if exists tassa CASCADE;"+
					"drop table if exists corsoDiLaurea CASCADE;"+
					"drop table if exists pianoDiStudi CASCADE;"+
					"drop table if exists corso CASCADE;"+
					"drop table if exists materiale CASCADE;"+
					"drop table if exists appello CASCADE;"+
					"drop table if exists devePagare CASCADE;"+
					"drop table if exists appartienea CASCADE;"+
					"drop table if exists contiene CASCADE;"+
					"drop table if exists prenota CASCADE;";
		
			PreparedStatement statement=connection.prepareStatement(drop);
			statement.executeUpdate();
			System.out.println("cancellato database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void resetDatabase() {
		Connection connection=databaseData.getConnection();
		try {
			PreparedStatement statement=null;
			String delete;
			
			delete="delete FROM studente";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM professore";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();			
			
			delete="delete FROM admin";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM tassa";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM corsoDiLaurea";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM pianoDiStudi";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM corso";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM materiale";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM appello";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM devePagare";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM contiene";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM appartiene";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete="delete FROM prenota";
			statement=connection.prepareStatement(delete);
			statement.executeUpdate();
			
			System.out.println("resettato database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
