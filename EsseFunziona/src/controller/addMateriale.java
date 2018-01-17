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

public class addMateriale extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("aggiuntaMateriale.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		String nomeUtente = (String) session.getAttribute("nomeUtenteProfessore");
		
		String contenutoMateriale = req.getParameter("contenutoMateriale");
	
		File f= new File(contenutoMateriale);
		
		Materiale mtl = new Materiale(f);

		ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();

		Professore prf = professoreDAO.findByPrimaryKey(nomeUtente);
		mtl.setProfessore(prf);

		MaterialeDAO materialeDAO = DatabaseManager.getInstance().getDaoFactory().getMaterialeDAO();
		materialeDAO.save(mtl);

		req.setAttribute("materiale", mtl);

		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaMateriale.jsp");
		dispacher.forward(req, resp);
	
	}
	
}
