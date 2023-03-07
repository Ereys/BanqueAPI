package wrapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import models.Client;
import models.Transaction;
import models.TransactionEnum;

public class TransactionDAO implements DAO<Transaction>{

	
	
	
	/**
	 * Get all the transaction of a client
	 * @id of the client
	 */
	@Override
	public List<Transaction> getAll(int id) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			List<Transaction> list = new ArrayList<Transaction>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM transactions t WHERE t.compte_id = ?");
			ps.setInt(id, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Transaction(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4).toLocalDate(),TransactionEnum.valueOf(rs.getString(5))));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			DBConnection.disconnect();
		}
	}

	/***
	 * Get a transaction by his id
	 */
	@Override
	public Transaction get(int id) {
		Connection con = DBConnection.getInstance().getConnection();
		System.out.println("con" + con);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM transactions WHERE transactions.id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new Transaction(rs.getInt(1), rs.getInt(2), rs.getDouble(3),rs.getDate(4).toLocalDate(), TransactionEnum.valueOf(rs.getString(5)));
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			DBConnection.disconnect();
		}
	}
	
	/**
	 * Update account with the new value
	 */
	@Override
	public void update(int id, Transaction objectUpdated) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			String query = "UPDATE comptes SET solde = solde" + 
					(objectUpdated.getTypeTransaction() == TransactionEnum.DEPOT ?" +" :" - ");
			PreparedStatement ps = con.prepareStatement(query + " ? WHERE comptes.id =?;");
			ps.setDouble(1, objectUpdated.getMontant() );
			ps.setInt(2, id);
			ps.executeUpdate(); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	/**
	 * Create transaction in the bd
	 */

	@Override
	public void create(Transaction newObject) {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO transactions(compte_id, montant, date_transaction, type) VALUES(?,?,?,?)");
			ps.setInt(1, newObject.getCompteId());
			ps.setDouble(2, newObject.getMontant());
			ps.setDate(3, Date.valueOf(newObject.getDateTransaction()));
			ps.setString(4, newObject.getTypeTransaction().toString());
			int nb = ps.executeUpdate();
			
			if(nb > 1) {
				throw new RuntimeException();
			}			
			this.update(newObject.getCompteId() , newObject);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.disconnect();
		}
	}
	
	public void transaction() {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE comptes SET solde = solde + 200 WHERE comptes.id = ?");
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
