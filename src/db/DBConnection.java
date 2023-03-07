package db;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;
import wrapper.ClientDAO;

public class DBConnection {
	
	private Connection con;
	private static DBConnection instance;
	
	private DBConnection() {
		try {
			// charger pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creer une connection du package java sql et on va renseigner l'adresse de la
			// bdd mysql avec login et mdp
			Dotenv dotenv = Dotenv.load();
			System.out.println(dotenv.get("DATABASE_USERNAME"));
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
