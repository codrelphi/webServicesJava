package fr.produitappv2.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.produitappv2.models.User;

public class UserService {

	private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/produitsdb";
	private final String USERNAME = "root";
	private final String PASSWORD = "rootpwd";
	private Connection connexion = null;
	private String query;
	
	public UserService() {}
	
	public boolean verifierAuthentification(User user) {
		int nbr_user = 0;
		
		try {
			// chargement du driver
			Class.forName(DRIVER);
			
			// ouverture de la connection
			connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query = "SELECT COUNT(*) AS NBR_USER FROM USERS WHERE LOGIN = ? AND PASSWORD = ?";
			PreparedStatement ps = connexion.prepareStatement(query);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nbr_user = rs.getInt("NBR_USER");
			}

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
		
		if (nbr_user == 0) return false;
		else return true;
	}
}
