package dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDao {
	public Produit save(Produit p);
	public List<Produit> ProduitParMC(String mc);
	public Produit getProduit(Long id);
	public Produit upDate(Produit p);
	public void deleteProduit(Long id);
}
