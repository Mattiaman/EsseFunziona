package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appello;
import model.Professore;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;

public class rifiutaEsame extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String idEsito = req.getParameter("idEsito");
		AppelloDAO appelloDAO = DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();	
		appelloDAO.rifiuta(matricola, Long.parseLong(idEsito));
	}
}