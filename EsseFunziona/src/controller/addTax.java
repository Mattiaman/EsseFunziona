package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Studente;
import model.Tassa;
import persistence.DatabaseManager;
import persistence.dao.AdminDAO;
import persistence.dao.StudenteDAO;
import persistence.dao.TassaDAO;

public class addTax extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacher = 
				req.getRequestDispatcher("aggiuntaTasse.jsp");
		dispacher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		String adminTassa = (String) session.getAttribute("nomeUtenteAdmin");
		
		String importoTassa = req.getParameter("importoTassa");
		String nomeTassa = req.getParameter("nomeTassa");
		String descrizioneTassa = req.getParameter("descrizioneTassa");
	
		if (!adminTassa.isEmpty() && !importoTassa.isEmpty() && !nomeTassa.isEmpty() && !descrizioneTassa.isEmpty()) {
			Tassa tax = new Tassa();
			tax.setImporto(Float.parseFloat(importoTassa));
			tax.setDescrizione(descrizioneTassa);
			tax.setNome(nomeTassa);
			AdminDAO adminDAO = DatabaseManager.getInstance().getDaoFactory().getAdminDAO();
			Admin adm = adminDAO.findByPrimaryKey(adminTassa);
			tax.setAdmin(adm);
			TassaDAO tassaDAO = DatabaseManager.getInstance().getDaoFactory().getTassaDAO();
			tassaDAO.save(tax);
			StudenteDAO studDAO = DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
			List<Studente> studs = studDAO.findAll();
			for (Studente s : studs) {
				tassaDAO.inoltraTassa(tax, s);
				MailGun.sendEmail("robmat56@gmail.com", s.getEmail(), "Tassa", "La tassa "+tax.getNome()+" "+tax.getDescrizione()+" di importo: "+tax.getImporto()+" � stata aggiunta", MailGun.GMAIL);
			}
			req.setAttribute("tassa", tax);
		}
		RequestDispatcher dispacher = req.getRequestDispatcher("aggiuntaTasse.jsp");
		dispacher.forward(req, resp);
	
	}
	
}
