package password;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.AdminKirjausDAO;
import servlet.Kontrolleri;

/*package password;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KirjauduAdmin {

//Poistettu turhaa tekstiä MH

 /** 
  * Servlet implementation class LoginServlet 
  */
@WebServlet("/KirjauduAdmin")
public class KirjauduAdmin extends HttpServlet {  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, java.io.IOException {
		try { 
			 
			Admin admin = new Admin();
			 admin.setKayttajatunnus(request.getParameter("kayttajatunnus"));
			 admin.setSalasana(request.getParameter("salasana"));
			 admin.setSuola(request.getParameter("suola"));
			 
			 admin = AdminKirjausDAO.login(admin);
			 
			 if (admin.isValid()) {
				 HttpSession session = request.getSession(); 
				 session.setAttribute("Login",admin); 
				 response.sendRedirect("AdminMenu"); //logged-in page
			 }else 
			 {
				 request.setAttribute("Virhe", "virhe");
				 response.sendRedirect("adminkirjautuminen.jsp"); //error page  
			 }
			 
				 
		}
		catch (Throwable theException){ 
			System.out.println(theException); 
			}
		}
	}
