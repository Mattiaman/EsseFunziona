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
				req.getRequestDispatcher("richiesteRicevimento.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		String nomeUtenteProfessore = (String) session.getAttribute("nomeUtenteProfessore");
		String matricola = req.getParameter("richiesteRicevimenti");
		String dataRicevimento = req.getParameter("dataRicevimento");
		
		if (!nomeUtenteProfessore.isEmpty() && !matricola.isEmpty() && !dataRicevimento.isEmpty()) {
			StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente studente = studenteDAO.findByPrimaryKey(matricola);
			ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
			Professore professore = professoreDAO.findByPrimaryKeyProxy(nomeUtenteProfessore);
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ITALIAN);
			Date date;
			try {
				date = format.parse(dataRicevimento);
				if (professoreDAO.controllaRicevimento(matricola, nomeUtenteProfessore)) {
					professoreDAO.cancellaRicevimento(matricola, nomeUtenteProfessore);
					professoreDAO.aggiungiData(matricola, nomeUtenteProfessore, date);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			req.setAttribute("studente", studente);
		}
		RequestDispatcher dispacher = req.getRequestDispatcher("richiesteRicevimento.jsp");
		dispacher.forward(req, resp);
	}
}