package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.DatabaseManager;
import persistence.DatiAdmin;
import persistence.DatiProfessore;
import persistence.DatiStudente;
import persistence.dao.AdminDAO;
import persistence.dao.ProfessoreDAO;
import persistence.dao.StudenteDAO;

public class LoginAdmin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		session.setAttribute("matricola", null);
		session.setAttribute("nomeUtenteProfessore", null);
		session.setAttribute("nomeUtenteAdmin", null);
		PrintWriter out=resp.getWriter();
		String nomeUtente=req.getParameter("nomeUtente");
		String password=req.getParameter("password");
		AdminDAO adminDAO=DatabaseManager.getInstance().getDaoFactory().getAdminDAO();
		DatiAdmin datiAdmin=adminDAO.findByPrimaryKeyData(nomeUtente);
		if(datiAdmin==null){
			out.println("<html>");
			out.println("<head><title>Login</title></head>");
			out.println("<body>");
			out.println("<h1>Nome utente o password errati</h1>");			
			out.println("</body>");
			out.println("</html>");
		}
		else {
			if(password.equals(datiAdmin.getPassword())){
				session.setAttribute("nomeUtenteAdmin",nomeUtente);
				RequestDispatcher dispacher = req.getRequestDispatcher("adminMenu.html");
				dispacher.forward(req, resp);
			}
			else {	
				req.setAttribute("password", password);
				RequestDispatcher dispacher = req.getRequestDispatcher("loginAdmin.jsp");
				dispacher.forward(req, resp);
			}
		}
	}

	
	
}
