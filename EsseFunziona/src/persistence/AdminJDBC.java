package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Studente;
import persistence.dao.AdminDAO;

public class AdminJDBC implements AdminDAO {

	private DatabaseData databaseData;
	
	public AdminJDBC(DatabaseData databaseData) {
		// TODO Auto-generated constructor stub
		this.databaseData=databaseData;
	}
	
	@Override
	public void save(Admin admin) {
	
		Connection connection=this.databaseData.getConnection();
		
		String insert="insert into admin (\"nomeUtente\", nome, cognome, dataDiNascita, email) values (?,?,?,?,?)";
		try {			
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, admin.getNomeUtente());	
			statement.setString(2, admin.getNome());
			statement.setString(3, admin.getCognome());
			statement.setDate(4, new Date(admin.getDataDiNascita().getTime()));
			statement.setString(5, admin.getEmail());	
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Admin findByPrimaryKey(String nomeUtente) {
		Connection connection=this.databaseData.getConnection();
		Admin admin=null;
		try {
			PreparedStatement statement;
			String find="SELECT * FROM admin WHERE \"nomeUtente\"=?";
			statement=connection.prepareStatement(find);
			statement.setString(1,nomeUtente);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				admin=new Admin();
				admin.setNomeUtente(result.getString("nomeUtente"));
				admin.setNome(result.getString("nome"));
				admin.setCognome(result.getString("cognome"));
				admin.setEmail(result.getString("email"));
				admin.setDataDiNascita(result.getDate("dataDiNascita"));
			}
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
		return admin;
	}

	@Override
	public List<Admin> findAll() {
		Connection connection=this.databaseData.getConnection();
		List<Admin> allAdmin=new ArrayList<>();
		try {
			Admin admin;
			PreparedStatement statement;
			String query="SELECT * FROM admin";
			statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				admin=findByPrimaryKey(result.getString("nomeUtente"));
				allAdmin.add(admin);
			}
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
		return allAdmin;
	}

	@Override
	public void update(Admin admin) {
		Connection connection=this.databaseData.getConnection();
		try {	
			String update="UPDATE admin SET nome=?, cognome=?, email=?, dataDiNascita=? WHERE nomeUtente=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setString(1, admin.getNomeUtente());
			statement.setString(2, admin.getNome());
			statement.setString(3, admin.getCognome());
			statement.setDate(4, new Date(admin.getDataDiNascita().getTime()));
			statement.setString(5, admin.getEmail());
			statement.executeQuery();
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

	@Override
	public void delete(Admin admin) {
		Connection connection=this.databaseData.getConnection();
		try {
			String delete="DELETE FROM admin WHERE nomeUtente=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setString(1, admin.getNomeUtente());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			statement.executeUpdate();
			connection.commit();
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
	
	@Override
	public void setPassword(Admin admin, String password) {
		// TODO Auto-generated method stub

	}
	

}
