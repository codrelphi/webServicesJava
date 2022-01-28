package fr.produitappv2.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.produitappv2.models.Produit;

public class ProduitService {

	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/produitsdb";
	private final String USERNAME = "root";
	private final String PASSWORD = "rootpwd";
	private Connection connexion = null;
	private String query;
	
	public ProduitService() {}
	
	public List<Produit> lectureProduit() {
		
		List<Produit> produits = new ArrayList<Produit>();
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			Statement st = connexion.createStatement();
			query = "SELECT * FROM produits"; // code, description, prix
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Produit p = new Produit();
				p.setCode(rs.getString("CODE"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setPrix(rs.getDouble("PRIX"));
				produits.add(p);
			}
			st.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
		return produits;
	}
	
	
	public void ajoutProduit(String code, String description, double prix) {
		//String msg = "Produit non enregistré !";
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query = "INSERT INTO produits VALUES(?, ?, ?)";
			PreparedStatement pst = connexion.prepareStatement(query);
			pst.setString(1, code);
			pst.setString(2, description);
			pst.setDouble(3, prix);
			pst.executeUpdate();
			pst.close();
			
			//msg = "Produit bien enregistré !";

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public String suppressionDeProduitParCode(String code) {
		String msg = "";
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query = "DELETE FROM produits WHERE CODE = ?";
			PreparedStatement pst = connexion.prepareStatement(query);
			pst.setString(1, code);
			//retourEU = pst.executeUpdate();
			pst.executeUpdate();
			pst.close();
			
			//System.out.println("Retour code : " + retourEU + "\n");
			
			msg = "Produit bien supprimé !";

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connexion != null) {
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		return msg;
	}
	
	public void editionProduit(String code, String uDesc, double uPrix) {
		//String msg = "Produit non enregistré !";
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query = "UPDATE produits SET DESCRIPTION = ?, PRIX = ? WHERE CODE = ?";
			PreparedStatement pst = connexion.prepareStatement(query);
			pst.setString(1, uDesc);
			pst.setDouble(2, uPrix);
			pst.setString(3, code);
			pst.executeUpdate();
			pst.close();
			
			//msg = "Produit bien enregistré !";

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public Produit getProduitParCode(String uCode) {
		
		Produit produit = new Produit();
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query = "SELECT * FROM produits WHERE code = ?"; // code, description, prix
			PreparedStatement ps = connexion.prepareStatement(query);
			ps.setString(1, uCode);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				produit.setCode(rs.getString("CODE"));
				produit.setDescription(rs.getString("DESCRIPTION"));
				produit.setPrix(rs.getDouble("PRIX"));
			}
			ps.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
		return produit;
	}
	
	public void editProduit(String code, String description, double prix) {
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query = "UPDATE produits SET DESCRIPTION = ?, PRIX = ? WHERE CODE = ?"; // code, description, prix
			PreparedStatement ps = connexion.prepareStatement(query);
			ps.setString(1, description);
			ps.setDouble(2, prix);
			ps.setString(3, code);
			ps.executeUpdate();
			ps.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public List<Produit> rechercheDeProduit(String motCles) {
		
		List<Produit> produits = new ArrayList<Produit>();
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query = "SELECT * FROM produits WHERE CODE LIKE ? OR DESCRIPTION LIKE ? OR PRIX LIKE ?";
			//query = "SELECT * FROM produits WHERE DESCRIPTION LIKE '%cool%'";
			PreparedStatement ps = connexion.prepareStatement(query);
			ps.setString(1, "%" + motCles + "%");
			ps.setString(2, "%" + motCles + "%");
			ps.setString(3, "%" + motCles + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produit p = new Produit();
				p.setCode(rs.getString("CODE"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setPrix(rs.getDouble("PRIX"));
				produits.add(p);
			}
			ps.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
		return produits;
	}
	
}
