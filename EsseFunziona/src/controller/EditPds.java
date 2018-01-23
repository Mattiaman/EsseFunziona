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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import model.*;
import persistence.DatabaseManager;
import persistence.dao.*;

public class EditPds extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		HttpSession session=req.getSession();
		StudenteDAO studDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		PianoDiStudiDAO pdsDAO=DatabaseManager.getInstance().getDaoFactory().getPianoDiStudiDAO();
		Studente s=studDAO.findByPrimaryKeyData((String) session.getAttribute("matricola"));
		if(req.getParameter("matricola")!=null)
			s=studDAO.findByPrimaryKeyData(req.getParameter("matricola"));	
		System.out.println(s.getMatricola());
		PianoDiStudi pds=pdsDAO.findByPrimaryKeyProxy(s.getPianoDiStudi().getId());
		System.out.println(pds.getId());
		if (pds!=null) {
			if (pds.getCorsi() != null) {
				if (!pds.getCorsi().isEmpty()) {
					PrintWriter out = resp.getWriter();
					Gson gson = new Gson();
					boolean first = false;
					out.println("[");
					for (Corso c : pds.getCorsi()) {
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
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JsonParser parser=new JsonParser();
		JsonArray list=parser.parse(req.getParameter("lista")).getAsJsonArray();
		HttpSession session=req.getSession();
		AdminDAO adminDAO=DatabaseManager.getInstance().getDaoFactory().getAdminDAO();
		Admin admin = adminDAO.findByPrimaryKey("admin");
		StudenteDAO studDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		PianoDiStudiDAO pdsDAO=DatabaseManager.getInstance().getDaoFactory().getPianoDiStudiDAO();
		Studente s=studDAO.findByPrimaryKeyData((String) session.getAttribute("matricola"));
		System.out.println(s.getMatricola());
		PianoDiStudi pds=pdsDAO.findByPrimaryKey(s.getPianoDiStudi().getId());
		CorsoDAO corsoDAO=DatabaseManager.getInstance().getDaoFactory().getCorsoDAO();
		Set<Corso> corsi=new HashSet<Corso>();
		for(JsonElement j:list) {
			Corso c=corsoDAO.findByPrimaryKey(Long.parseLong(j.toString()));
			if(c!=null) {
				pds.addCorso(c);
				System.out.println("added "+c.getNome());
			}
		}

		//pds.setCorsi(corsi);
		System.out.println("aaaaaa "+ pds.getCorsi().size());
		pdsDAO.save(pds);
		studDAO.sendRichiestaModificaPds(s, pds);
		MailGun.sendEmail("robmat56@gmail.com", admin.getEmail(), "Piano di studi", "C'è una nuova richiesta di cambiamento piano da: "+s.getNome()+" "+s.getCognome()+" matricola: "+s.getMatricola(), MailGun.GMAIL);
	}

	
	
}
