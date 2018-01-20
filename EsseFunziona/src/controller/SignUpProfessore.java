package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CorsoDiLaurea;
import model.Professore;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;

public class SignUpProfessore extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("signupProfessore.jsp");
		dispacher.forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeUtente = req.getParameter("nomeUtente");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String dataNascita = req.getParameter("dataNascita");
		String password = req.getParameter("password");
		String cdl = req.getParameter("corsoDiLaurea");
	
		if (!nomeUtente.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !email.isEmpty() && !dataNascita.isEmpty() && !password.isEmpty() && !cdl.isEmpty()) {
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ITALIAN);
			Date date;
			try {
				date = format.parse(dataNascita);
				Professore prof = new Professore(nome, cognome, date, email, nomeUtente);

				CorsoDiLaureaDAO corsoDiLaureaDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
				CorsoDiLaurea corsoDiLaurea = corsoDiLaureaDAO.findByPrimaryKey(Long.parseLong(cdl));
				prof.setCorsoDiLaurea(corsoDiLaurea);

				ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
				professoreDAO.save(prof);
				professoreDAO.setPassword(prof, password);

				req.setAttribute("professore", prof);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		RequestDispatcher dispacher = req.getRequestDispatcher("signupProfessore.jsp");
		dispacher.forward(req, resp);	
	
	
	}
	
	
	
}
