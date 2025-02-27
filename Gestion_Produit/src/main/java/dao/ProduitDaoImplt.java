package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitDaoImplt implements IProduitDao {
	// l'enregistrement des produits
	@Override
	public Produit save(Produit p) {
		Connection connection = SingltonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO produits (DESIGNATION, PRIX, QUANTITE) VALUES (?, ?, ?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM produits");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps2.close();
		} catch (Exception e) {

		}
		return p;
	}

	// la recherche sur les produits

	@Override
	public List<Produit> ProduitParMC(String mc) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingltonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM produits WHERE DESIGNATION LIKE ? ");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));

				produits.add(p);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return produits;
	}

// l'affichage des produits 
	@Override
	public Produit getProduit(Long id) {

		Produit p = null;
		Connection connection = SingltonConnection.getConnection();

		try {

			PreparedStatement ps = connection.prepareStatement("SELECT * FROM produits WHERE ID = ?");
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				p = new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

// la modéfication des produits 
	@Override
	public Produit upDate(Produit p) {
		Connection connection = SingltonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE  produits SET DESIGNATION=?, PRIX=?, QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM produits");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps2.close();
		} catch (Exception e) {

		}
		return p;
	}

// la supprission des produits 
	@Override
	public void deleteProduit(Long id) {
		Connection connection = SingltonConnection.getConnection();
		try {

			PreparedStatement ps = connection.prepareStatement("DELETE FROM produits WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
