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
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.StudenteDAO;

public class SignUp extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispacher = 
				req.getRequestDispatcher(".jsp");
		dispacher.forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricola = req.getParameter("matricola");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String dataNascita = req.getParameter("dataNascita");
		String password = req.getParameter("password");
		String corsoDiLaurea = req.getParameter("corsoDiLaurea");
	
		DateFormat format = new SimpleDateFormat
							("yyyy-mm-dd", Locale.ITALIAN);
		Date date;
		try {
			date = format.parse(dataNascita);
			Studente stud = 
					new Studente(matricola, nome, cognome, date);
			
			CorsoDiLaureaDAO corsoDiLaureaDAO = 
					DatabaseManager.getInstance()
					.getDaoFactory().getCorsoDiLaureaDAO();
			CorsoDiLaurea cdl = corsoDiLaureaDAO.findByPrimaryKey(Long.parseLong(corsoDiLaurea));
			stud.setCorsoDiLaurea(cdl);;
			
			StudenteDAO studenteDao = 
					DatabaseManager.getInstance()
					.getDaoFactory().getStudenteDAO();
			studenteDao.save(stud);
			studenteDao.setPassword(stud, password);
			
			req.setAttribute("studente", stud);
			
			RequestDispatcher dispacher = 
					req.getRequestDispatcher("signupStudente.jsp");
			dispacher.forward(req, resp);
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	
	}
	
	
	
}
