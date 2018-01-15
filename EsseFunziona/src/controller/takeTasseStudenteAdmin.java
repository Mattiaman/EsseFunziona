package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.sql.SetDataSourceTagSupport;

import com.google.gson.Gson;

import model.*;
import persistence.DatabaseManager;
import persistence.dao.*;

public class takeTasseStudenteAdmin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		TassaDAO tassaDAO = DatabaseManager.getInstance().getDaoFactory().getTassaDAO();
		StudenteDAO studDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		Studente stud=studDAO.findByPrimaryKeyData(req.getParameter("matricola"));
		Set<Tassa> tasse = stud.getTasse();
		PrintWriter out=resp.getWriter();
		boolean first=false;
		if (!tasse.isEmpty()) {

			out.println("[");
			for (Tassa c : tasse) {
				if (first)
					out.print(",");
				else
					first = true;
				String stato = null;
				if (tassaDAO.getStatoTassa(c, stud))
					stato = "pagata";
				else
					stato = "non pagata";

				out.print("{");
				out.print("\"id\":\"" + c.getId() + "\",\"importo\":\"" + c.getImporto() + "\",\"nome\":\"" + c.getNome() + "\",\"descrizione\":\""
						+ c.getDescrizione() + "\",\"stato\":\"" + stato+"\"");
				out.print("}");
			}
			out.print("]");
		}
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudenteDAO studDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		Studente stud=studDAO.findByPrimaryKey(req.getParameter("matricola"));
		TassaDAO tassaDAO=DatabaseManager.getInstance().getDaoFactory().getTassaDAO();
		Tassa tax=tassaDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id")));
		boolean stato;
		if(req.getParameter("stato").equals("pagata"))
			stato=true;
		else
			stato=false;
		
		tassaDAO.setStatoTassa(tax, stud, stato);
	}
	
	
	
}
