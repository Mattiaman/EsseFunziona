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

import model.Corso;
import model.CorsoDiLaurea;
import model.PianoDiStudi;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.PianoDiStudiDAO;
import persistence.dao.StudenteDAO;

public class SignUpStudente extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CorsoDiLaureaDAO cdlDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
		List<CorsoDiLaurea> cldList = cdlDAO.findAll();
		req.setAttribute("corsiDiLaurea", cldList);
		RequestDispatcher dispacher = req.getRequestDispatcher("signupStudente.jsp");
		dispacher.forward(req, resp);
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricola = req.getParameter("matricola");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String dataNascita = req.getParameter("dataNascita");
		String password = req.getParameter("password");
		String corsoDiLaurea = req.getParameter("corsoDiLaurea");
		String pianoDiStudi = req.getParameter("pianoDiStudi");
	
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ITALIAN);
		Date date;
		try {
			date = format.parse(dataNascita);
			Studente stud = new Studente(matricola, nome, cognome, date, email);
			
			CorsoDiLaureaDAO corsoDiLaureaDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
			CorsoDiLaurea cdl = corsoDiLaureaDAO.findByPrimaryKeyProxy(Long.parseLong(corsoDiLaurea));
			stud.setCorsoDiLaurea(cdl);
			
			PianoDiStudi pds = new PianoDiStudi();
			pds.setNome("Piano di "+nome+" "+cognome);
			pds.setCorsoDiLaurea(cdl);
			if(cdl==null)
				System.out.println("00000");
			pds.setCorsi(cdl.getCorsi());
			PianoDiStudiDAO pianoDiStudiDAO = DatabaseManager.getInstance().getDaoFactory().getPianoDiStudiDAO();
			pianoDiStudiDAO.save(pds);
			stud.setPianoDiStudi(pds);

			StudenteDAO studenteDao = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			studenteDao.save(stud);
			studenteDao.setPassword(stud, password);

			req.setAttribute("studente", stud);

			RequestDispatcher dispacher = req.getRequestDispatcher("signupStudente.jsp");
			dispacher.forward(req, resp);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	
	}
	
	
	
}
