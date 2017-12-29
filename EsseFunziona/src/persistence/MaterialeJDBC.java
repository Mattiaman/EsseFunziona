package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Materiale;
import persistence.dao.MaterialeDAO;

public class MaterialeJDBC implements MaterialeDAO {

	private DatabaseData databaseData;
	
	public MaterialeJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(Materiale materiale) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {		
			String insert="insert into materiale(id, contenuto, nomeUtenteProfessore) values(?,?,?)";
			PreparedStatement statement;
			statement = connection.prepareStatement(insert);
			statement.setLong(1, materiale.getId());
			try {
				statement.setBinaryStream(2, new FileInputStream(materiale.getContenuto()), materiale.getContenuto().length());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement.setString(3, materiale.getProfessore().getNomeUtente());
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
	public Materiale findByPrimaryKey(long id) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		Materiale materiale=null;
		try {
			String query="select * from materiale where id=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				materiale=new Materiale();
				materiale.setId(result.getLong("id"));
				File file=new File("materiale");
				FileOutputStream fos=null;
				try {
					fos=new FileOutputStream(file);
					fos.write(result.getBytes("contenuto"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				materiale.setContenuto(file);
				ProfessoreJDBC professoreJDBC=new ProfessoreJDBC(databaseData);
				materiale.setProfessore(professoreJDBC.findByPrimaryKey(result.getString("nomeUtenteProfessore")));
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
	public List<Materiale> findAll() {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		List<Materiale> materiali=new ArrayList<Materiale>();
		try {
			Materiale materiale;
			String query="select * from materiale";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				materiale=findByPrimaryKey(result.getLong("id"));
				materiali.add(materiale);
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
		
		
		return materiali;
	}

	@Override
	public void update(Materiale materiale) {
		// TODO Auto-generated method stub
		Connection connection= this.databaseData.getConnection();
		try {
			String update="update materiale SET contenuto=?, nomeUtenteProfessore=? Where id=?";
			PreparedStatement statement=connection.prepareStatement(update);
			try {
				statement.setBinaryStream(1, new FileInputStream(materiale.getContenuto()), materiale.getContenuto().length());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement.setString(2, materiale.getProfessore().getNomeUtente());
			statement.setLong(3, materiale.getId());
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
	public void delete(Materiale materiale) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {
			String delete="delete from materiale where id=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setLong(1, materiale.getId());
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
