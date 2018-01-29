package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Admin;
import model.Professore;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.AdminDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;
public class showData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String nomeUtenteAdmin = (String) session.getAttribute("nomeUtenteAdmin");
		String nomeUtenteProfessore = (String) session.getAttribute("nomeUtenteProfessore");
			
		
		if(matricola!=null) {
			StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente stud=studenteDAO.findByPrimaryKey(matricola);
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			out.print(gson.toJson(stud));
			out.close();
		}
		else if(nomeUtenteAdmin!=null) {
			AdminDAO adminDAO=DatabaseManager.getInstance().getDaoFactory().getAdminDAO();
			Admin adm=adminDAO.findByPrimaryKey(nomeUtenteAdmin);
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			out.print(gson.toJson(adm));
			out.close();
		}
		else if(nomeUtenteProfessore!=null) {
			ProfessoreDAO professoreDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
			Professore prof=professoreDAO.findByPrimaryKey(nomeUtenteProfessore);
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			out.print(gson.toJson(prof));
			out.close();
		}
		else {
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			out.print(gson.toJson("notLogged"));
			out.close();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String nomeUtenteProfessore = (String) session.getAttribute("nomeUtenteProfessore");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String dataNascita = req.getParameter("dataNascita");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		
		if(matricola!=null) {
			StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			Studente stud=studenteDAO.findByPrimaryKey(matricola);
			if (!nome.isEmpty() && !cognome.isEmpty() && !email.isEmpty() && !dataNascita.isEmpty()) {
				try {
					date = format.parse(dataNascita);
					stud.setNome(nome);
					stud.setCognome(cognome);
					stud.setDataDiNascita(date);
					stud.setEmail(email);
					studenteDAO.update(stud);
					req.setAttribute("studente", stud);
				} catch (ParseException e) {e.printStackTrace();}
			}		
		}
		else if(nomeUtenteProfessore!=null) {
			ProfessoreDAO professoreDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
			Professore prof=professoreDAO.findByPrimaryKey(nomeUtenteProfessore);
			if (!nome.isEmpty() && !cognome.isEmpty() && !email.isEmpty() && !dataNascita.isEmpty()) {
				try {
					date = format.parse(dataNascita);
					prof.setNome(nome);
					prof.setCognome(cognome);
					prof.setDataDiNascita(date);
					prof.setEmail(email);
					professoreDAO.update(prof);
					req.setAttribute("professore", prof);
				} catch (ParseException e) {e.printStackTrace();}
			}	
		}
		
		RequestDispatcher dispacher = req.getRequestDispatcher("datiAnagrafici.jsp");
		dispacher.forward(req, resp);
	}
}