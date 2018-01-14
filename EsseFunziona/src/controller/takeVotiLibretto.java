package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import persistence.DatabaseManager;
import persistence.dao.AppelloDAO;

public class takeVotiLibretto extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String matricola = (String) session.getAttribute("matricola");
		String idEsito = req.getParameter("idEsito");
		resp.setContentType("application/json");
		AppelloDAO appelloDAO = DatabaseManager.getInstance().getDaoFactory().getAppelloDAO();
		long voto = appelloDAO.trovaVotoLibretto(matricola,Long.parseLong(idEsito));
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		out.print(gson.toJson(voto));
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}