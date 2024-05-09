package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;

@WebServlet(name = "cs", urlPatterns = {"/controller", "*.do"})
public class CreditServlet extends HttpServlet{
	
	private ICreditMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CreditMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("CreditView.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Lire les données de la requete
		 */
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		/*
		 * Valider les données
		 */
		/*
		 * Stocker les données saisies dans le modéle
		 */
		CreditModel credit = new CreditModel();
		credit.setMontant(montant);
		credit.setTaux(taux);
		credit.setDuree(duree);
		/*
		 * Faire appel à la couche métier pour effectuer les traitements 
		 */
		double resultat = metier.calculerMensualiteCredit(montant, taux, duree);
		/*
		 * Stocker le résultat dans le modéle
		 */
		credit.setMensualite(resultat);
		/*
		 * Stocker le modéle dans l'objet request
		 */
		request.setAttribute("creditModel", credit);
		/*
		 * Faire un forward vers la vue JSP
		 */
		request.getRequestDispatcher("CreditView.jsp").forward(request, response);
	}
}
