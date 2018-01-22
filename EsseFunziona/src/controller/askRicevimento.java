package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Professore;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;

public class askRicevimento extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		String matricola = (String) session.getAttribute("matricola");
		String nomeUtenteProfessore = req.getParameter("professoreRicevimento");
		
		if (!nomeUtenteProfessore.isEmpty() && !matricola.isEmpty()) {
			ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
			Professore professore = professoreDAO.findByPrimaryKey(nomeUtenteProfessore);
			StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente studente = studenteDAO.findByPrimaryKey(matricola);
			professore.addStudente(studente);
			professoreDAO.update(professore);
			req.setAttribute("professore", professore);
			MailGun.sendEmail("robmat56@gmail.com", professore.getEmail(), "Ricevimento", "Salve Prof, Vorrei se possibile un ricevimento", MailGun.GMAIL);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("chiedereRicevimento.jsp");
		dispatcher.forward(req, resp);
		

	
	}
}
