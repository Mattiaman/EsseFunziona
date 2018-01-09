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
import persistence.DatiStudente;
import persistence.dao.StudenteDAO;

public class LoginStudente extends HttpServlet{

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
		String matricola=req.getParameter("matricola");
		String password=req.getParameter("password");
		StudenteDAO studenteDAO=DatabaseManager.getInstance().getDaoFactory().getStudenteDAO();
		DatiStudente datiStudente=studenteDAO.findByPrimaryKeyData(matricola);
		if(datiStudente==null){
			out.println("<html>");
			out.println("<head><title>Login</title></head>");
			out.println("<body>");
			out.println("<h1>Matricola o password errati</h1>");			
			out.println("</body>");
			out.println("</html>");
		}
		else {
			if(password.equals(datiStudente.getPassword())){
				session.setAttribute("matricola",matricola);
				RequestDispatcher dispacher = req.getRequestDispatcher("studentMenu.html");
				dispacher.forward(req, resp);
			}
			else {
				out.println("<html>");
				out.println("<head><title>Login</title></head>");
				out.println("<body>");
				out.println("<h1>Matricola o password errati</h1>");			
				out.println("</body>");
				out.println("</html>");				
			}
		}
	}

	
	
}
