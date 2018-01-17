package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DatabaseManager;
import persistence.dao.BandoDAO;
import persistence.dao.MaterialeDAO;

public class downloader extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File my_file=null;
		if(req.getParameter("tipo").equals("materiale")) {
			MaterialeDAO materialeDAO = DatabaseManager.getInstance().getDaoFactory().getMaterialeDAO();
			my_file=materialeDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id"))).getContenuto();
		}else {
			BandoDAO bandoDAO=DatabaseManager.getInstance().getDaoFactory().getBandoDAO();
			my_file=bandoDAO.findByPrimaryKey(Long.parseLong(req.getParameter("id"))).getContenuto();
		}
        
        resp.setHeader("Content-disposition","attachment; filename="+my_file.getName());

		OutputStream out = resp.getOutputStream();
		FileInputStream in = new FileInputStream(my_file);
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0){
		    out.write(buffer, 0, length);
		}
		in.close();
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
