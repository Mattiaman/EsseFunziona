package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Admin;
import model.Materiale;
import model.Professore;
import persistence.DatabaseManager;
import persistence.dao.AdminDAO;
import persistence.dao.MaterialeDAO;
import persistence.dao.ProfessoreDAO;

public class addBandi extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("aggiuntaBandi.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idBando = req.getParameter("idBando");
		String contenutoBando = req.getParameter("contenutoBando");
		String nomeUtenteProfessore = req.getParameter("nomeUtenteProfessore");
	
		File f= new File(contenutoBando);
		Long id = Long.parseLong(idBando);
		
		Materiale bando = new Materiale(f, id);

		ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();

		Professore prf = professoreDAO.findByPrimaryKey(nomeUtenteProfessore);
		bando.setProfessore(prf);

		MaterialeDAO materialeDAO = DatabaseManager.getInstance().getDaoFactory().getMaterialeDAO();
		materialeDAO.save(bando);

		req.setAttribute("bando", bando);

		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaBandi.jsp");
		dispacher.forward(req, resp);
	
	}
	
}
