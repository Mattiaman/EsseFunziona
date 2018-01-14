package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;
import persistence.dao.ProfessoreDAO;

public class takeRicevimento  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String nomeUtente = req.getParameter("nomeUtente");
		
		if(matricola == null)
			matricola = req.getParameter("matricola");
		
		resp.setContentType("application/json");
		ProfessoreDAO professoreDAO = DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
		Date data = professoreDAO.trovaRicevimento(matricola,nomeUtente);
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		out.print(gson.toJson(data));
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
