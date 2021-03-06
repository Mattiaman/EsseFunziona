package controller;

import java.io.IOException;
import java.sql.Time;
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
		String oraRicevimento = req.getParameter("oraRicevimento");
		
		if (!nomeUtenteProfessore.isEmpty() && !matricola.isEmpty() && !dataRicevimento.isEmpty() && !oraRicevimento.isEmpty()) {
			StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente studente = studenteDAO.findByPrimaryKey(matricola);
			ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
			Professore professore = professoreDAO.findByPrimaryKeyProxy(nomeUtenteProfessore);
			DateFormat formatHour = new SimpleDateFormat("HH:mm");
			Date hour;
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ITALIAN);
			Date date;
			try {
				hour = formatHour.parse(oraRicevimento);
				date = format.parse(dataRicevimento);
				date.setHours(hour.getHours());
				date.setMinutes(hour.getMinutes());
				if (professoreDAO.controllaRicevimento(matricola, nomeUtenteProfessore)) {
					professoreDAO.cancellaRicevimento(matricola, nomeUtenteProfessore);
					professoreDAO.aggiungiData(matricola, nomeUtenteProfessore, date);
					req.setAttribute("studente", studente);			
					MailGun.sendEmail("robmat56@gmail.com", studente.getEmail(), "Ricevimento", "Ricevimento Stabilito con il prof: "+ professore.getNome()+" "+professore.getCognome()+" il giorno: "+date, MailGun.GMAIL);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			
		}
		RequestDispatcher dispacher = req.getRequestDispatcher("richiesteRicevimento.jsp");
		dispacher.forward(req, resp);
	}
}