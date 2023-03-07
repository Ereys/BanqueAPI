package models;

public class Compte {
	
	private int id;
	private int idClient;
	private TypeCompte typeCompte;
	private double solde;
	
	public Compte() {
		super();
	}

	public Compte(int id, int client, TypeCompte typeCompte, double solde) {
		super();
		this.id = id;
		this.idClient = client;
		this.typeCompte = typeCompte;
		this.solde = solde;
	}

	public Compte(int client, TypeCompte typeCompte, double solde) {
		super();
		this.idClient = client;
		this.typeCompte = typeCompte;
		this.solde = solde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClient() {
		return idClient;
	}

	public void setClient(int client) {
		this.idClient = client;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", idClient=" + idClient + ", typeCompte=" + typeCompte + ", solde=" + solde + "]";
	}
	
	
}
