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

public class takeCdl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		CorsoDiLaureaDAO corsoDiLaureaDAO = DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
		if(req.getParameter("id") != null) {
			CorsoDiLaurea corsoDiLaurea=corsoDiLaureaDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id")));
			req.setAttribute("corsoDiLaurea", corsoDiLaurea);
			RequestDispatcher dispatcher=req.getRequestDispatcher("infoCDL.jsp");
			dispatcher.forward(req, resp);
		}
		resp.setContentType("application/json");
		List<CorsoDiLaurea> cdls = corsoDiLaureaDAO.findAll();
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		boolean first=false;
		out.println("[");
		for(CorsoDiLaurea c:cdls){
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
