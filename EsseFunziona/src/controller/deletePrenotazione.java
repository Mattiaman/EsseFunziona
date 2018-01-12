package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appello;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;
import persistence.dao.StudenteDAO;

public class deletePrenotazione  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
		// TODO Auto-generated method stub
		
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String idAppello = req.getParameter("idAppello");
		
		
		AppelloDAO appelloDAO = DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();
		Appello appello = appelloDAO.findByPrimaryKey(Long.parseLong(idAppello));
		
		appelloDAO.cancellaPrenotazione(matricola, Long.parseLong(idAppello));
		
		
	
	}
}
