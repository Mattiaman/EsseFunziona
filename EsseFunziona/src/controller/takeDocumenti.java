package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Materiale;
import persistence.DatabaseManager;
import persistence.dao.MaterialeDAO;

public class takeDocumenti extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/json");
		MaterialeDAO materialeDAO = DatabaseManager.getInstance().getDaoFactory().getMaterialeDAO();
		List<Materiale> documenti = materialeDAO.findAll();
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		boolean first=false;
		out.println("[");
		for(Materiale m:documenti){
			if(first)
				out.print(",");
			else
				first=true;
			out.print(gson.toJson(m));
		}
		out.print("]");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
}
