package fr.produitappv2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.produitappv2.services.ProduitService;

/**
 * Servlet implementation class VoirProduit
 */
@WebServlet("/VoirProduit")
public class VoirProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VoirProduit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		ProduitService produitService = new ProduitService();
		
		/*String description = produitService.getProduitParCode(code).getDescription();
		double prix = produitService.getProduitParCode(code).getPrix();
	
		request.setAttribute("code", code);
		request.setAttribute("description", description);
		request.setAttribute("prix", prix);*/
		
		request.setAttribute("produit", produitService.getProduitParCode(code));
		
		request.getRequestDispatcher("/WEB-INF/voirProduit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
