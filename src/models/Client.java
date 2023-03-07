package models;
import java.time.LocalDate;


public class Client {

	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	
	public Client() {
		super();
	}
	
	
	/**
	 * Use to represent data from database
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 */
	public Client(int id, String nom, String prenom, LocalDate dateNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	/**
	 * Use to input data in database
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 */
	
	public Client(String nom, String prenom, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}
	
	
}
