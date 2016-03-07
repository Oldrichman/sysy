package admin.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TuoteDao.TuoteDao;
import admin.bean.Tuote;

/**
 * Servlet implementation class kayttajasivu
 */
@WebServlet("/kayttajasivu")
public class kayttajasivu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kayttajasivu() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter wout = response.getWriter();	
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
