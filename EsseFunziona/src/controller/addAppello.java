package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appello;
import model.Corso;
import model.CorsoDiLaurea;
import model.Professore;
import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;
import persistence.dao.CorsoDAO;
import persistence.dao.CorsoDiLaureaDAO;
import persistence.dao.ProfessoreDAO;

public class addAppello extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("aggiuntaAppelli.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String dataAppello = req.getParameter("dataAppello");
		String corsoAppello = req.getParameter("corsoAppello");
		String nomeUtente = req.getParameter("nomeUtente");
		
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ITALIAN);
		Date date;
		try {
			date = format.parse(dataAppello);
			Appello appello=new Appello(date);
			
			CorsoDAO corsoDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
			Corso c = corsoDAO.findByPrimaryKey(Long.parseLong(corsoAppello));
			appello.setCorso(c);
			
			ProfessoreDAO profDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
			Professore p = profDAO.findByPrimaryKey(nomeUtente);
			appello.setProfessore(p);
			
			AppelloDAO appelloDAO = DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();
			appelloDAO.save(appello);
			
			req.setAttribute("appello", appello);
			
			RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaAppelli.jsp");
			dispacher.forward(req, resp);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	
	}
	
}
