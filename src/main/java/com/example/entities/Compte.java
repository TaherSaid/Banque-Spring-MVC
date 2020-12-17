package com.example.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class Compte {


	private long code;
	
	private int solde;
	private String dateCreation;
	public Compte(long code,int solde, String dateCreation) {
		super();
		this.code = code;
		this.solde=solde;
		this.dateCreation = dateCreation;
	}
	public Compte(int solde, String dateCreation) {
		super();
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	public Compte(int solde) {
		super();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		this.solde = solde;
		this.dateCreation  = formatter.format(new Date());
	}
	public Compte() {
		super();
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public int getSolde() {
		return solde;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	
}
