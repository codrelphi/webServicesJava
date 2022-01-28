package fr.mesproduits.metier;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

import fr.mesproduits.service.Produit;
import fr.mesproduits.service.ProduitServiceServiceLocator;
import fr.mesproduits.service.ProduitWS;

public class GestionProduits {

	public static void main(String[] args) throws RemoteException {
		
		Scanner lectureClavier = new Scanner(System.in);
		
		try {
			
			ProduitWS proxyClient = new ProduitServiceServiceLocator().getProduitWSPort();
			
			System.out.println("\nListe des produits\n");
			for (Produit p : proxyClient.getProduits()) {
				System.out.println("Code: " + p.getCode());
				System.out.println("Description: " + p.getDescription());
				System.out.println("Prix: " + p.getPrix());
				System.out.println("-------------------------------------");
			}
			
			System.out.println("\nAfficher un produit\n");
			System.out.print("Entrez le code: ");
			String code = lectureClavier.next();
			Produit p = proxyClient.getProduitByCode(code);
			System.out.println("Produit avec code <" + code + ">");
			System.out.println("Code: " + p.getCode());
			System.out.println("Description: " + p.getDescription());
			System.out.println("Prix: " + p.getPrix());
			
			System.out.println("\nAjouter un produit\n");
			System.out.print("Entrez le code: ");
			code = lectureClavier.next();
			System.out.print("Entrez la description: ");
			String description = lectureClavier.next();
			System.out.print("Entrez le prix: ");
			double prix = lectureClavier.nextDouble();
			Produit produitAAjouter = new Produit(code, description, prix);
			proxyClient.ajouterProduit(produitAAjouter);
			System.out.println("Produit bien ajouté !");
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
				

	}

}
