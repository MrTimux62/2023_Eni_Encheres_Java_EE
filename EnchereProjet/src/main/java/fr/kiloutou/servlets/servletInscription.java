package fr.kiloutou.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.kiloutou.bll.ClientManager;
import fr.kiloutou.bll.UtilisateurManager;
import fr.kiloutou.bo.Adresse;
import fr.kiloutou.bo.Client;
import fr.kiloutou.bo.Utilisateur;
import fr.kiloutou.bo.exceptions.CodePostalException;
import fr.kiloutou.bo.exceptions.NumeroException;

@WebServlet("/Inscription")
public class servletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// CLIENT
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String MotDePasse = request.getParameter("password");
		
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, MotDePasse);
		utilisateur.toString();
		UtilisateurManager.ajouter(utilisateur);
		request.setAttribute("utilisateur", utilisateur);
		//response.sendRedirect("Connection");
	}

}