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
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.ws.org.objectweb.asm.Type;

import model.*;
import persistence.DatabaseManager;
import persistence.dao.*;

public class takeProfessori extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ProfessoreDAO professoreDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
		if(req.getParameter("nomeUtente") != null) {
			Professore professore=professoreDAO.findByPrimaryKey(req.getParameter("nomeUtente"));
			req.setAttribute("professore", professore);
			RequestDispatcher dispatcher=req.getRequestDispatcher("infoProf.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		resp.setContentType("application/json");
		List<Professore> profs = professoreDAO.findAllProxy();
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		boolean first=false;
		out.println("[");
		for(Professore p:profs){
			p.getStudentiRicevimento();
			if(first)
				out.print(",");
			else
				first=true;
			out.print(gson.toJson(p));
		}
		out.print("]");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	
	
}
