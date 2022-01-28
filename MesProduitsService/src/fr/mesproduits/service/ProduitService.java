package fr.mesproduits.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.mesproduits.model.Produit;

@WebService(name="ProduitWS")
public class ProduitService {

	private List<Produit> produits = new ArrayList<Produit>();
	
	@WebMethod
	public Produit getProduitByCode(@WebParam(name="code") String code) {
		Produit p = new Produit(code);
		return p;
	}
	
	@WebMethod
	public List<Produit> getProduits() {
		
		produits.add(new Produit("P1"));
		produits.add(new Produit("P2"));
		produits.add(new Produit("P3"));
		
		return produits;
	}
	
	@WebMethod
	public void ajouterProduit(@WebParam(name="Produit") Produit p) {
		produits.add(p);
	}
}
