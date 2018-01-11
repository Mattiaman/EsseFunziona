package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

public class requestRicevimento  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("chiedereRicevimento.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		String nomeUtenteProfessore = (String) session.getAttribute("nomeUtenteProfessore");
		String matricola = req.getParameter("richiesteRicevimenti");
		String dataRicevimento = req.getParameter("dataRicevimento");
		
		StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();		
		Studente studente = studenteDAO.findByPrimaryKey(matricola);
		
		ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();		
		Professore professore = professoreDAO.findByPrimaryKey(nomeUtenteProfessore);
		professore.getStudentiRicevimento().remove(studente);
		

		DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ITALIAN);
		Date date;
		try {
			date = format.parse(dataRicevimento);
			professoreDAO.creaRicevimento(matricola, nomeUtenteProfessore, date);
		} catch (ParseException e) { e.printStackTrace();}
		
		req.setAttribute("Studente", studente);
		RequestDispatcher dispacher = req.getRequestDispatcher("chiedereRicevimento.jsp");
		dispacher.forward(req, resp);
	}
}