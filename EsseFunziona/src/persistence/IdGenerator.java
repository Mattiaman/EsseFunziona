package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdGenerator {

	
	
	
	private static final String query = "SELECT nextval('idSequenza') AS id";

	public static Long getId(Connection c) {
		Long id = null;
		try {
			PreparedStatement preparedStatement = c.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			id = resultSet.getLong("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id+1;
	}
	
}
