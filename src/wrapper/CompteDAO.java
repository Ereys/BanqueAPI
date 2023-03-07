package wrapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import models.Compte;
import models.Transaction;
import models.TransactionEnum;
import models.TypeCompte;

public class CompteDAO implements DAO<Compte>{
	
	
	/**
	 * Get all account of a client
	 * @id id of the client
	 */
	@Override
	public List<Compte> getAll(int id) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			List<Compte> list = new ArrayList<Compte>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM comptes c WHERE c.client_id = ?");
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Compte(rs.getInt(1), rs.getInt(2), TypeCompte.fromInteger(rs.getInt(3)), rs.getDouble(4)));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			DBConnection.disconnect();
		}
	}


	/**
	 * Get an account by his id
	 */

	@Override
	public Compte get(int id) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			ClientDAO c = new ClientDAO();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM comptes WHERE comptes.id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return new Compte(rs.getInt(1), rs.getInt(2), TypeCompte.fromInteger(rs.getInt(3)), rs.getDouble(4));
			}	
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			DBConnection.disconnect();
		}
	}


	@Override
	public void update(int id, Compte objectUpdated) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create an acount in this the bd
	 */
	@Override
	public void create(Compte newObject) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO comptes(client_id, types_comptes_id, solde) VALUES(?,?,?)");
			ps.setInt(1, newObject.getClient());
			ps.setInt(2,  newObject.getTypeCompte().getValue());
			ps.setDouble(3, newObject.getSolde());
			int nb = ps.executeUpdate();
			if(nb > 1) {
				throw new RuntimeException();
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.disconnect();
		}
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
