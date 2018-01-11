package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Corso;
import model.Tassa;
import persistence.DatabaseManager;
import persistence.dao.CorsoDAO;
import persistence.dao.TassaDAO;

public class deleteCorso extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CorsoDAO corsoDAO=DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
		System.out.println(req.getParameter("id"));
		Corso corso=corsoDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id")));
		corsoDAO.delete(corso);
	}
	

}
