package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import model.*;
import persistence.DatabaseManager;
import persistence.dao.*;

public class mostraPiano extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		StudenteDAO studDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		Studente stud=studDAO.findByPrimaryKeyData(req.getParameter("id"));
		PianoDiStudiDAO pdsDAO=DatabaseManager.getInstance().getDaoFactory().getPianoDiStudiDAO();
		PianoDiStudi pds=studDAO.getRichiestaModificaPds(stud);

		System.out.println(pds.getId());
		
//		if (pds!=null) {
//			if (pds.getCorsi() != null) {
//				if (!pds.getCorsi().isEmpty()) {
//					PrintWriter out = resp.getWriter();
//					Gson gson = new Gson();
//					boolean first = false;
//					out.println("[");
//					for (Corso c : pds.getCorsi()) {
//						if (first)
//							out.print(",");
//						else
//							first = true;
//						out.print(gson.toJson(c));
//					}
//					out.print("]");
//					out.close();
//				}
//			} 
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("nuovoNome"));
		System.out.println(req.getParameter("idCdl"));
		JsonParser parser=new JsonParser();
		JsonArray list=parser.parse(req.getParameter("lista")).getAsJsonArray();
		CorsoDiLaureaDAO cdlDAO=DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
		CorsoDiLaurea cdl=cdlDAO.findByPrimaryKey(Long.parseLong(req.getParameter("idCdl")));
		CorsoDAO corsoDAO=DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
		Set<Corso> corsi=new HashSet<Corso>();
		for(JsonElement j:list) {
			Corso c=corsoDAO.findByPrimaryKey(Long.parseLong(j.toString()));
			if(c!=null)
				corsi.add(c);
		}
		if(req.getParameter("nuovoNome")!="" && req.getParameter("nuovoNome")!=null)
			cdl.setNome(req.getParameter("nuovoNome"));
		cdl.setCorsi(corsi);
		cdlDAO.update(cdl);
	}

	
	
}
