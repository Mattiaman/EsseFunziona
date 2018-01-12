package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appello;
import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;

public class addEsito extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricola =req.getParameter("matricolaStudente");
		String idAppello = req.getParameter("appello");
		String voto = req.getParameter("voto");
		
		
		AppelloDAO appelloDAO = DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();
		Appello appello = appelloDAO.findByPrimaryKey(Long.parseLong(idAppello));
		
		appelloDAO.aggiungiVoto(matricola, Long.parseLong(idAppello), Long.parseLong(voto));
		
		req.setAttribute("appello", appello);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaEsito.jsp");
		dispacher.forward(req, resp);
	
	}
}
