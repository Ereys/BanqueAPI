package db;

import java.sql.Connection;
import java.sql.DriverManager;
import wrapper.ClientDAO;

public class DBConnection {
	
	private Connection con;
	private static DBConnection instance;
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque_db", "root", "");
		}catch (Exception e) {
			// gerer cas erreur
		}
	}
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public static void disconnect() {
		if(instance !=null && instance.getConnection() != null) {
			try {
				instance.getConnection().close();
				instance = null;
			}catch (Exception e) {
				System.out.println("disconnecte");
				getInstance();
			}
		}
	}
}
