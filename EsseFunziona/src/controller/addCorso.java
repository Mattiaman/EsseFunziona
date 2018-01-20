package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corso;
import persistence.DatabaseManager;
import persistence.dao.CorsoDAO;

public class addCorso extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("aggiuntaCorsi.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeCorso = req.getParameter("nomeCorso");
		Corso crs;
		
		if (nomeCorso!=null) {
			crs = new Corso(nomeCorso);
			CorsoDAO corsoDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
			corsoDAO.save(crs);
			req.setAttribute("corso", crs);
		}
		

		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaCorsi.jsp");
		dispacher.forward(req, resp);
	
	}
	
}