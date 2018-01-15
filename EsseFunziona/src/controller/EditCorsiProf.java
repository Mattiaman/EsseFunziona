package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import model.Corso;
import model.Professore;
import persistence.DatabaseManager;
import persistence.dao.CorsoDAO;
import persistence.dao.ProfessoreDAO;

public class EditCorsiProf extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		ProfessoreDAO prfDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
		Professore prf=prfDAO.findByPrimaryKeyProxy(req.getParameter("nomeUtente"));
		
		if (prf!=null) {
			if (prf.getCorsiInsegnati() != null) {
					PrintWriter out = resp.getWriter();
					Gson gson = new Gson();
					boolean first = false;
					out.println("[");
					for (Corso c : prf.getCorsiInsegnati()) {
						if (first)
							out.print(",");
						else
							first = true;
						out.print(gson.toJson(c));
					}
					out.print("]");
					out.close();
				}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JsonParser parser=new JsonParser();
		JsonArray list=parser.parse(req.getParameter("lista")).getAsJsonArray();
		ProfessoreDAO prfDAO=DatabaseManager.getInstance().getDaoFactory().getProfessoreDAO();
		Professore prf=prfDAO.findByPrimaryKey(req.getParameter("nomeUtente"));
		CorsoDAO corsoDAO=DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
		Set<Corso> corsi=new HashSet<Corso>();
		for(JsonElement j:list) {
			Corso c=corsoDAO.findByPrimaryKey(Long.parseLong(j.toString()));
			if(c!=null)
				corsi.add(c);
		}
		prf.setCorsiInsegnati(corsi);
		prfDAO.update(prf);
	}
}
