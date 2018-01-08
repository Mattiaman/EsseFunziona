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

import model.Bando;
import persistence.dao.BandoDAO;

public class BandoJDBC implements BandoDAO {

	private DatabaseData databaseData;
	
	public BandoJDBC(DatabaseData databaseData) {
		this.databaseData = databaseData;
	}

	@Override
	public void save(Bando bando) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {		
			String insert="insert into bando(id, contenuto, nomeUtenteAdmin) values(?,?,?)";
			PreparedStatement statement;
			statement = connection.prepareStatement(insert);
			statement.setLong(1,IdGenerator.getId(connection));
			try {
				statement.setBinaryStream(2, new FileInputStream(bando.getContenuto()), bando.getContenuto().length());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement.setString(3, bando.getAdmin().getNomeUtente());
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
	public Bando findByPrimaryKey(long id) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		Bando bando=null;
		try {
			String query="select * from bando where id=?";
			PreparedStatement statement=connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				bando=new Bando();
				bando.setId(result.getLong("id"));
				File file=new File("bando");
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
				
				bando.setContenuto(file);
				AdminJDBC adminJDBC=new AdminJDBC(databaseData);
				bando.setAdmin(adminJDBC.findByPrimaryKey(result.getString("nomeUtenteAdmin")));
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
		
		return bando;
	}

	@Override
	public List<Bando> findAll() {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		List<Bando> bandi=new ArrayList<Bando>();
		try {
			Bando bando;
			String query="select * from bando";
			PreparedStatement statement=connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				bando=findByPrimaryKey(result.getLong("id"));
				bandi.add(bando);
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
		
		
		return bandi;
	}

	@Override
	public void update(Bando bando) {
		// TODO Auto-generated method stub
		Connection connection= this.databaseData.getConnection();
		try {
			String update="update bando SET contenuto=?, nomeUtenteAdmin=? Where id=?";
			PreparedStatement statement=connection.prepareStatement(update);
			try {
				statement.setBinaryStream(1, new FileInputStream(bando.getContenuto()), bando.getContenuto().length());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			statement.setString(2, bando.getAdmin().getNomeUtente());
			statement.setLong(3, bando.getId());
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
	public void delete(Bando bando) {
		// TODO Auto-generated method stub
		Connection connection=this.databaseData.getConnection();
		try {
			String delete="delete from bando where id=?";
			PreparedStatement statement=connection.prepareStatement(delete);
			statement.setLong(1, bando.getId());
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
