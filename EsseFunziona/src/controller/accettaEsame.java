package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;
import persistence.dao.StudenteDAO;

public class accettaEsame extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String idEsito = req.getParameter("idEsito");
		AppelloDAO appelloDAO = DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();	
		appelloDAO.accetta(matricola, Long.parseLong(idEsito));
	}
}