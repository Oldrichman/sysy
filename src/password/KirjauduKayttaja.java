package password;

import java.io.PrintWriter;

import static java.nio.charset.StandardCharsets.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KayttajaKirjausDAO;

//Poistettu turhaa tekstiä MH

 /** 
  * Servlet implementation class LoginServlet 
  */
@WebServlet("/KirjauduKayttaja")
public class KirjauduKayttaja extends HttpServlet {  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, java.io.IOException {
		
		try { 
			response.setContentType("text/html;charset=UTF-8");
			Kayttaja kayttaja = new Kayttaja();
			 kayttaja.setEmail(request.getParameter("email"));
			 kayttaja.setSalasana(request.getParameter("salasana"));
			 kayttaja.setSuola(request.getParameter("suola"));
			 
			 kayttaja = KayttajaKirjausDAO.login(kayttaja);
			 
			 String kayttajaTunnus = kayttaja.getEmail();
			 
			 if (kayttaja.isValid()) {
				 HttpSession session = request.getSession(); 
				 session.setAttribute("Login",kayttaja);
				 //Alustaa session päättymään 15min jälkeen OH
				 session.setMaxInactiveInterval(15*60);
				 Cookie kayttajaNimi = new Cookie("email", kayttajaTunnus);
				 kayttajaNimi.setMaxAge(15*30);
				 response.addCookie(kayttajaNimi);
				 response.sendRedirect("KayttajaServlet"); //logged-in page
			 }else {
				 response.setContentType("text/html;charset=UTF-8");
				 PrintWriter out = response.getWriter();
				 out.println("<font color=red>Käyttäjätunnuksesi tai salasanasi on päin pyllyä!</font>");
				 RequestDispatcher rd = getServletContext().getRequestDispatcher("/kotisivu.jsp");
				 rd.include(request, response); //error page
			 }
		}
		catch (Throwable theException){ 
			System.out.println(theException); 
			}
		}
	}
