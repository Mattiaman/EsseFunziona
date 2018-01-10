package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		Studente stud=studenteDAO.findByPrimaryKey(matricola);
		
		AdminDAO adminDAO=DatabaseManager.getInstance().getDaoFactory().getAdminDAO();
		Admin adm=adminDAO.findByPrimaryKey(nomeUtenteAdmin);
		
		ProfessoreDAO professoreDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
		Professore prof=professoreDAO.findByPrimaryKey(nomeUtenteProfessore);

		
		
		if(stud!=null) {
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			out.print(gson.toJson(stud));
			out.close();
		}
		else if(prof!=null) {
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			out.print(gson.toJson(prof));
			out.close();
		}
		else if(adm!=null) {
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			out.print(gson.toJson(adm));
			out.close();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
	}
}