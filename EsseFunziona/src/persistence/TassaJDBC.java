package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Studente;
import model.Tassa;
import persistence.dao.AdminDAO;
import persistence.dao.TassaDAO;

public class TassaJDBC implements TassaDAO {

	private DatabaseData databaseData;
	
	public TassaJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(Tassa tassa) {
		Connection connection=this.databaseData.getConnection();
		try {
			String insert="insert into tassa(id, importo, nome, descrizione, nomeUtenteAdmin) values(?,?,?,?,?)";
			long id=IdGenerator.getId(connection);
			tassa.setId(id);
			PreparedStatement statement=connection.prepareStatement(insert);
			statement.setLong(1, id);
			statement.setFloat(2, tassa.getImporto());
			statement.setString(3, tassa.getNome());
			statement.setString(4, tassa.getDescrizione());
			statement.setString(5, tassa.getAdmin().getNomeUtente());
			
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
	public Tassa findByPrimaryKey(long id) {
		Connection connection=this.databaseData.getConnection();
		Tassa tassa=null;
		try {
			String query="SELECT * FROM tassa WHERE id=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setLong(1, id);
			
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				tassa=new Tassa();
				tassa.setId(result.getLong("id"));
				tassa.setNome(result.getString("nome"));
				tassa.setDescrizione(result.getString("descrizione"));
				tassa.setImporto(result.getFloat("importo"));
				AdminDAO adminDAO=new AdminJDBC(this.databaseData);
				tassa.setAdmin(adminDAO.findByPrimaryKey(result.getString("nomeUtenteAdmin")));
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
		
		return tassa;
	}

	@Override
	public List<Tassa> findAll() {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		
		List<Tassa> tasse=new ArrayList<Tassa>();
		try {
			Tassa tassa;
			PreparedStatement statement;
			String query="SELECT * FROM tassa";
			
			statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				tassa=findByPrimaryKey(result.getLong("id"));
				tasse.add(tassa);
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
		return tasse;
	}

	@Override
	public void update(Tassa tassa) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {
			String update="update tassa SET importo=?, nome=?, descrizione=?, nomeUtenteAdmin=? WHERE id=?";
			PreparedStatement statement=connection.prepareStatement(update);
			statement.setFloat(1, tassa.getImporto());
			statement.setString(2, tassa.getNome());
			statement.setString(3, tassa.getDescrizione());
			statement.setString(4, tassa.getAdmin().getNomeUtente());
			statement.setLong(5, tassa.getId());
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
	public void delete(Tassa tassa) {
		// TODO Auto-generated method stub
		Connection connection=databaseData.getConnection();
		try {
			String delete="delete FROM tassa WHERE id=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setLong(1, tassa.getId());
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
	public void inoltraTassa(Tassa tassa, Studente studente) {
		Connection connection = databaseData.getConnection();
		try {
			String check = "select from tassa where id=?";
			PreparedStatement statement;
			statement = connection.prepareStatement(check);
			statement.setLong(1, tassa.getId());
			ResultSet result = statement.executeQuery();
			String inoltra = "insert into devePagare(id, matricolaStudente, idTassa, pagata) values(?,?,?,FALSE)";
			PreparedStatement ins = connection.prepareStatement(inoltra);
			ins.setLong(1, IdGenerator.getId(connection));
			ins.setString(2, studente.getMatricola());
			ins.setLong(3, tassa.getId());
			ins.executeUpdate();
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
	public boolean getStatoTassa(Tassa tassa, Studente studente) {
		Connection connection=databaseData.getConnection();
		boolean status=false;
		try {
			String query="select * from devePagare where matricolaStudente=? and idTassa=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setString(1, studente.getMatricola());
			statement.setLong(2, tassa.getId());
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				status=result.getBoolean("pagata");
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
		return status;
	}

}
