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
import persistence.PianoDiStudiProxy;
import persistence.dao.*;

public class mostraPiano extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		StudenteDAO studDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		Studente stud=studDAO.findByPrimaryKeyData(req.getParameter("id"));
		PianoDiStudi pds=studDAO.getRichiestaModificaPds(stud);

		System.out.println(pds.getId());
		if(pds instanceof PianoDiStudiProxy)
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
		StudenteDAO studDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		PianoDiStudiDAO pdsDAO=DatabaseManager.getInstance().getDaoFactory().getPianoDiStudiDAO();
		Studente stud=studDAO.findByPrimaryKeyData(req.getParameter("id"));
		PianoDiStudi pdsVecchio=stud.getPianoDiStudi();
		PianoDiStudi pdsNuovo=studDAO.getRichiestaModificaPds(stud);
		
		String s=req.getParameter("status");
		System.out.println(s);
		
		if(s.equals("1")) {
			pdsDAO.delete(pdsVecchio);
			studDAO.setPianoDiStudi(stud,pdsNuovo);
			System.out.println("aggiornato");
		}
		else {
			System.out.println("bau");
			pdsDAO.delete(pdsNuovo);
		}

	}

	
	
}
