package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseData {
	final private String dbURI;
	final private String username;
	final private String password;
	
	public DatabaseData(String dbURI, String username, String password) {
		this.dbURI=dbURI;
		this.username=username;
		this.password=password;
	}
	
	public Connection getConnection() {
		Connection connection=null;
		
		try {
			connection=DriverManager.getConnection(dbURI, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
