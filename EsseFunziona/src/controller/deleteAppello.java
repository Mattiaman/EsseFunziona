package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appello;
import model.Corso;
import model.Tassa;
import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;
import persistence.dao.CorsoDAO;
import persistence.dao.TassaDAO;

public class deleteAppello extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AppelloDAO appelloDAO=DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();
		System.out.println(req.getParameter("id"));
		Appello appello=appelloDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id")));
		appelloDAO.delete(appello);
	}
	

}
