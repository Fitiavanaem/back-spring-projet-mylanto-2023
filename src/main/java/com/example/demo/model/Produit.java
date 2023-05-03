package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
public class Produit {

	@Id
	private String numProduit;
	
	@Column
	private String design;
	
	@Column
	private int prix;
	
	@Column
	private double quantite;
	
	public Produit() {
		super();
	}
	
	public Produit(String numProduit, String design, int prix, double quantite) {
		super();
		this.numProduit = numProduit;
		this.design = design;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public String getNumProduit() {
		return numProduit;
	}
	public void setNumProduit(String numProduit) {
		this.numProduit = numProduit;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
	
	
}
