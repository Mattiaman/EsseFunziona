package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.DatabaseManager;
public class showData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		StudenteDao dao = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		StudenteCredenziali studente = dao.findByPrimaryKeyCredential(username);
		
		
	}
}
