package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tassa;
import persistence.DatabaseManager;
import persistence.dao.TassaDAO;

public class deleteTax extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TassaDAO tassaDAO=DatabaseManager.getInstance().getDaoFactory().getTassaDAO();
		System.out.println(req.getParameter("id"));
		Tassa tax=tassaDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id")));
		tassaDAO.delete(tax);
	}
	

}
