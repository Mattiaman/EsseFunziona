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

import model.*;
import persistence.DatabaseManager;
import persistence.dao.*;

public class takeCorsi extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/json");
		CorsoDAO corsoDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
		List<Corso> corsi = corsoDAO.findAll();
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		boolean first=false;
		out.println("[");
		for(Corso c:corsi){
			if(first)
				out.print(",");
			else
				first=true;
			out.print(gson.toJson(c));
		}
		out.print("]");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
