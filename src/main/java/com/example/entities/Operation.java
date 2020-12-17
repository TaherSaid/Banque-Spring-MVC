package com.example.entities;


import java.util.Date;

public class Operation {

	private int numOperation;
	
	private Date dateOperation;
	private int montant;
	private Compte compte;
	public Operation(int numOperation, Date dateOperation, int montant, Compte compte) {
		super();
		this.numOperation = numOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	public Operation(Date dateOperation, int montant, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	public Operation() {
		super();
	}
	public int getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(int numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	
}
