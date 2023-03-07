package wrapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import models.Client;

public class ClientDAO implements DAO<Client> {


	@Override
	public List<Client> getAll(int id) {
		return null;
	}

	

	/**
	 * Get a client by his id
	 */
	
	@Override
	public Client get(int id) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			List<Client> list = new ArrayList<Client>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM clients WHERE clients.id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())return new Client(rs.getInt(1), rs.getString("NOM"), rs.getString("PRENOM"), rs.getDate(4).toLocalDate());
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			DBConnection.disconnect();
		}
	}	

	@Override
	public void update(int id, Client objectUpdated) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Create a client in the bd
	 */
	@Override
	public void create(Client newObject) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO clients(NOM, PRENOM, DATE_NAISSANCE) VALUES(?,?,?)");
			ps.setString(1, newObject.getNom());
			ps.setString(2, newObject.getPrenom());
			ps.setDate(3, Date.valueOf(newObject.getDateNaissance()));
			int nb = ps.executeUpdate();
			if(nb > 1) {
				throw new RuntimeException();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.disconnect();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
