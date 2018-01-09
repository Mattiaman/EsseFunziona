package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Corso;
import model.CorsoDiLaurea;
import model.PianoDiStudi;
import model.Professore;
import model.Studente;
import model.Utente;
import persistence.DatabaseManager;
import persistence.DatiAdmin;
import persistence.DatiProfessore;
import persistence.DatiStudente;
import persistence.dao.AdminDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;
public class showData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String nomeUtenteAdmin = (String) session.getAttribute("nomeUtenteAdmin");
		String nomeUtenteProfessore = (String) session.getAttribute("nomeUtenteProfessore");
		
		StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		Studente stud=studenteDAO.findByPrimaryKey(matricola);
		
		AdminDAO adminDAO=DatabaseManager.getInstance().getDaoFactory().getAdminDAO();
		Admin adm=adminDAO.findByPrimaryKeyData(nomeUtenteAdmin);
		
		ProfessoreDAO professoreDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
		Professore prof=professoreDAO.findByPrimaryKeyData(nomeUtenteProfessore);

		
		req.setAttribute("professore", prof);
		
		req.setAttribute("admin", adm);
		
		req.setAttribute("studente", stud);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("datiAnagrafici.jsp");
		dispacher.forward(req, resp);
		
		
	}
}
