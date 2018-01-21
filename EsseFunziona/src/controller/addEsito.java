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

public class addEsito extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricola =req.getParameter("matricolaStudente");
		String idAppello = req.getParameter("appello");
		String voto = req.getParameter("voto");
		
		if(!voto.isEmpty() && Long.parseLong(voto)<=30 && Long.parseLong(voto)>=0) {
			StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente studente = studenteDAO.findByPrimaryKey(matricola);
			AppelloDAO appelloDAO = DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();
			Appello appello = appelloDAO.findByPrimaryKey(Long.parseLong(idAppello));
			if (appelloDAO.controllaPrenotazione(matricola, Long.parseLong(idAppello))) {
				appelloDAO.cancellaPrenotazione(matricola, Long.parseLong(idAppello));
				appelloDAO.aggiungiVoto(matricola, Long.parseLong(idAppello), Long.parseLong(voto));
				req.setAttribute("appello", appello);
				req.setAttribute("studente", studente);
				MailGun.sendEmail("robmat56@gmail.com", studente.getEmail(), "Esito Esame", "Il risultato dell'esame "+appello.getCorso()+" è di "+Long.parseLong(voto)+"/30", MailGun.GMAIL);
			}

		}
		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaEsiti.jsp");
		dispacher.forward(req, resp);
	
	}
}
