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

import DAO.AdminKirjausDAO;
import servlet.Kontrolleri;

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

			String adminTunnus = admin.getKayttajatunnus();

			if (admin.isValid()) {
				HttpSession session = request.getSession();
				session.setAttribute("Login", admin);
				// Alustaa session päättymään 15min jälkeen MH
				session.setMaxInactiveInterval(15 * 60);
				Cookie adminNimi = new Cookie("kayttajatunnus", adminTunnus);
				adminNimi.setMaxAge(15 * 30);
				response.addCookie(adminNimi);
				response.sendRedirect("kontrolleri"); // logged-in page
			} else {
				response.setContentType("text/html;charset=UTF-8");
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/adminkirjautuminen.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Käyttäjätunnuksesi tai salasanasi on päin pyllyä!</font>");
				rd.include(request, response); // error page
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
