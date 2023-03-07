package models;

import java.time.LocalDate;

public class Transaction {
	
	private int id;
	private int compteId;
	private double montant;
	private LocalDate dateTransaction;
	private TransactionEnum typeTransaction;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int id, int compteId, double montant, LocalDate dateTransaction,
			TransactionEnum typeTransaction) {
		super();
		this.id = id;
		this.compteId = compteId;
		this.montant = montant;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
	}
	

	public Transaction(int compteId, double montant, LocalDate dateTransaction, TransactionEnum typeTransaction) {
		super();
		this.compteId = compteId;
		this.montant = montant;
		this.dateTransaction = dateTransaction;
		this.typeTransaction = typeTransaction;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompteId() {
		return compteId;
	}

	public void setCompteId(int compteId) {
		this.compteId = compteId;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public TransactionEnum getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(TransactionEnum typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", compteId=" + compteId + ", montant=" + montant + ", typeTransaction="
				+ typeTransaction + ", dateTransaction=" + dateTransaction + "]";
	}
	
	
}
