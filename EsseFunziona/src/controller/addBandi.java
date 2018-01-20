package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Bando;
import model.Materiale;
import model.Professore;
import persistence.DatabaseManager;
import persistence.dao.AdminDAO;
import persistence.dao.BandoDAO;
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
		HttpSession session = req.getSession();
		
		String nomeUtente = (String) session.getAttribute("nomeUtenteAdmin");
		
		String contenutoBando = req.getParameter("contenutoBando");
	
		if (!nomeUtente.isEmpty() && !contenutoBando.isEmpty()) {
			File f = new File(contenutoBando);
			Bando bnd = new Bando(f);
			AdminDAO adminDAO = DatabaseManager.getInstance().getDaoFactory().getAdminDAO();
			Admin adm = adminDAO.findByPrimaryKey(nomeUtente);
			bnd.setAdmin(adm);
			BandoDAO bandoDAO = DatabaseManager.getInstance().getDaoFactory().getBandoDAO();
			bandoDAO.save(bnd);
			req.setAttribute("bando", bnd);
		}
		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaBandi.jsp");
		dispacher.forward(req, resp);
	
	}
	
}
