package dao;

import java.util.List;

import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {
        ProduitDaoImplt dao = new ProduitDaoImplt();
		/*
		  Produit p1 = dao.save(new
		 * Produit("Hp ELITBOOK", 2000, 2)); Produit p2 = dao.save(new
		 * Produit("Impriment", 4000, 10)); Produit p3 = dao.save(new
		 * Produit("HP PROBOOK", 5000, 12)); System.out.println(p1.toString());
		*/
		List<Produit> prods = dao.ProduitParMC("%H%");
		for(Produit p : prods) {
			System.out.println(p.toString());
		}
		
	}
	

}
