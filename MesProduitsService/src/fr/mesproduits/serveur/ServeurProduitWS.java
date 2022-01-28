package fr.mesproduits.serveur;

import javax.xml.ws.Endpoint;

import fr.mesproduits.service.ProduitService;

public class ServeurProduitWS {

	private static final String URL = "http://localhost:9090/";
			
	public static void main(String[] args) {
		
		Endpoint.publish(ServeurProduitWS.URL, new ProduitService());
		
		System.out.println("Serveur allumé...");
	
		
	}
	


}
