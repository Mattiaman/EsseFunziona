package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professore;
import persistence.DatabaseManager;
import persistence.dao.ProfessoreDAO;

class deleteProfessore extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ProfessoreDAO professoreDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
		System.out.println(req.getParameter("nomeUtente"));
		Professore professore=professoreDAO.findByPrimaryKey(req.getParameter("nomeUtente"));
		professoreDAO.delete(professore);
	}
	

}
