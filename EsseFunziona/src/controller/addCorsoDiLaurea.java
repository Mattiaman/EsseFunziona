package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corso;
import model.CorsoDiLaurea;
import model.Materiale;
import model.Professore;
import persistence.DatabaseManager;
import persistence.dao.CorsoDAO;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.MaterialeDAO;
import persistence.dao.ProfessoreDAO;

public class addCorsoDiLaurea extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("aggiuntaCorsiDiLaurea.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeCdl = req.getParameter("nomecdl");
		String pgfacebook = req.getParameter("pgfacebook");

		if (!nomeCdl.isEmpty()) {
			CorsoDiLaurea cdl = new CorsoDiLaurea(nomeCdl);
			cdl.setFacebook(pgfacebook);
			CorsoDiLaureaDAO cdlDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
			cdlDAO.save(cdl);
			req.setAttribute("corsoDL", cdl);
		}
		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaCorsiDiLaurea.jsp");
		dispacher.forward(req, resp);
	
	}
	
}