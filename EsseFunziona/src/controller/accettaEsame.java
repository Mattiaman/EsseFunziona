package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.StudenteDAO;

public class accettaEsame extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();

		String matricola = (String) session.getAttribute("matricola");
		StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();	
		Studente studente = studenteDAO.findByPrimaryKey(matricola);	
		
		String nomeUtente = req.getParameter("");

	
	}
}