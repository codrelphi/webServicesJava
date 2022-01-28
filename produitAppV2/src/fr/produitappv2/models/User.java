package fr.produitappv2.models;

import javax.servlet.http.HttpServletRequest;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private char sex;
	private String login;
	private String password;
	
	public User() {}

	public User(String nom, String prenom, char sex, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sex = sex;
		this.login = login;
		this.password = password;
	}
	
	
	public void authentification(HttpServletRequest request) {
		
		String login = request.getParameter("inputLogin");
		String password = request.getParameter("inputPassword");
		
	}
	

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
