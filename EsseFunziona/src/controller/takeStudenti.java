package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.StudenteDAO;

public class takeStudenti extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		List<Studente> studs = studenteDAO.findAll();
		req.setAttribute("studenti", studs);

		RequestDispatcher dispacher = req.getRequestDispatcher("studenti.jsp");
		dispacher.forward(req, resp);
		
	}
	
	
	
	
	
	
	
	
	
	
}
