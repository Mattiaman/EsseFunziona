package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professore;
import model.Studente;
import persistence.dao.ProfessoreDAO;

public class ProfessoreJDBC implements ProfessoreDAO {
	
	private DatabaseData databaseData;

	public ProfessoreJDBC(DatabaseData databaseData) {
		this.databaseData=databaseData;
	}

	@Override
	public void save(Professore professore) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {		
			String insert="insert into profesore(nomeUtente, nome, cognome, dataDiNascita, email) values (?,?,?,?,?)";
			PreparedStatement statement=connection.prepareStatement(insert);
			statement.setString(1, professore.getNomeUtente());
			statement.setString(2, professore.getNome());
			statement.setString(3, professore.getCognome());
			statement.setDate(4, new Date(professore.getDataDiNascita().getTime()));
			statement.setString(5, professore.getEmail());
			statement.executeUpdate();
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
	public Professore findByPrimaryKey(String nomeUtente) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		Professore professore=null;
		try {
			String query="select * from professore where nomeUtente=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, nomeUtente);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				professore=new Professore();
				professore.setNomeUtente(result.getString("nomeUtente"));
				professore.setNome(result.getString("nome"));
				professore.setCognome(result.getString("cognome"));
				professore.setDataDiNascita(new java.util.Date(result.getDate("dataDiNascita").getTime()));
				professore.setEmail(result.getString("email"));
	
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
		
		return null;
	}

	@Override
	public List<Professore> findAll() {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		List<Professore> professori=new ArrayList<Professore>();
		Professore professore;
		try {
			String query="select * from professore";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				professore=findByPrimaryKey(result.getString("nomeUtente"));
				professori.add(professore);
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
		
		return professori;
	}

	@Override
	public void update(Professore professore) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		
		try {
			String update="update professore SET nome=?, cognome=?, dataDiNascita=?, email=? where nomeUtente=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setString(1, professore.getNome());
			statement.setString(2, professore.getCognome());
			statement.setDate(3, new Date(professore.getDataDiNascita().getTime()));
			statement.setString(4, professore.getEmail());
			statement.setString(5, professore.getNomeUtente());
			statement.executeUpdate();
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
	public void delete(Professore professore) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {
			String delete="delete from professore where nomeUtente=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setString(1, professore.getNomeUtente());
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
	
	public void setPassword(Professore professore, String password) {
		Connection connection = this.databaseData.getConnection();
		try {
			String update = "update professore SET password = ? WHERE nomeUtente=?";
			PreparedStatement statement;
			statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, professore.getNomeUtente());
			statement.executeUpdate();
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
