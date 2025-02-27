package web;

import java.util.*;

import metier.entities.Produit;

public class ProduitModel {
	private String moCle;
	List<Produit> produits = new ArrayList<Produit>();
	
	public String getMoCle() {
		return moCle ; 
	}
	public List<Produit> getProduits(){
		return produits ;
	}
	public void setMoCle(String moCle) {
		this.moCle = moCle;
	}
	public void setProduits(List<Produit> produits) { 
		this.produits = produits;
	}
	
}
