package fr.produitappv2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.produitappv2.services.ProduitService;

/**
 * Servlet implementation class EditProduit
 */
@WebServlet("/EditProduit")
public class EditProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProduit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProduitService produitService = new ProduitService();
		String description = produitService.getProduitParCode(code).getDescription();
		double prix = produitService.getProduitParCode(code).getPrix();
		
		request.setAttribute("code", code);
		request.setAttribute("description", description);
		request.setAttribute("prix", prix);
		
		request.getRequestDispatcher("/WEB-INF/editProduit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProduitService produitService = new ProduitService();
		
		String code = request.getParameter("code");
		String description = request.getParameter("description");
		double prix = Double.parseDouble(request.getParameter("prix"));
		
		produitService.editProduit(code, description, prix);
		request.getRequestDispatcher("/WEB-INF/ajoutProduit.jsp").forward(request, response);
	}

}
