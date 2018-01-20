package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Professore;
import model.Studente;
import persistence.DatabaseManager;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;

public class takeStudenti extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		StudenteDAO studenteDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		if(req.getParameter("matricola") != null) {
			Studente studente=studenteDAO.findByPrimaryKey(req.getParameter("matricola"));
			req.setAttribute("studente", studente);
			RequestDispatcher dispatcher=req.getRequestDispatcher("infoStudente.jsp");
			dispatcher.forward(req, resp);
		}
		
		resp.setContentType("application/json");
		List<Studente> studs = studenteDAO.findAll();
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		boolean first=false;
		out.println("[");
		for(Studente s:studs){
			if(first)
				out.print(",");
			else
				first=true;
			out.print(gson.toJson(s));
		}
		out.print("]");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
