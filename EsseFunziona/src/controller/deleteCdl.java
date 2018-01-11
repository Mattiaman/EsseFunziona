package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import persistence.DatabaseManager;
import persistence.dao.*;

public class deleteCdl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CorsoDiLaureaDAO corsoDiLaureaDAO=DatabaseManager.getInstance().getDaoFactory().getCorsoDiLaureaDAO();
		System.out.println(req.getParameter("id"));
		CorsoDiLaurea corsoDiLaurea=corsoDiLaureaDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id")));
		corsoDiLaureaDAO.delete(corsoDiLaurea);
	}
	

}
