package fr.mesproduits.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import fr.mesproduits.service.Produit;
import fr.mesproduits.service.ProduitServiceServiceLocator;
import fr.mesproduits.service.ProduitWS;

/**
 * Servlet implementation class GestionProduit
 */
@WebServlet("/GestionProduit")
public class GestionProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestionProduit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// proxy client = stub
		// proxyClient = null;
		
		try {
			ProduitWS proxyClient = new ProduitServiceServiceLocator().getProduitWSPort(); // []
			
			Produit[] produits = proxyClient.getProduits();
			//System.out.println(produits[0].getCode());
			request.setAttribute("listeDesProduits", produits);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
