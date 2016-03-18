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

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();

		String kayttajatunnus = admin.getKayttajatunnus();
		String salasana = admin.getSalasana();
		System.out.println(kayttajatunnus + " " + salasana);
		System.out.println("Anna k‰ytt‰j‰tunnus: ");
		String tunnus = input.nextLine();
		if (tunnus.equalsIgnoreCase(kayttajatunnus)) {
			System.out.println("Anna Salasana: ");
			String annettu = input.nextLine();

			if (annettu.equals(salasana)) {
				System.out.println("Tervetuloa " + kayttajatunnus);
			} else {
				System.out.println("V‰‰r‰ salasana");
			}

		} else {
			System.out.println("V‰‰r‰ k‰ytt‰j‰tunnus");
		}
	}


protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");

	response.getWriter();
	
	

	// Luetaan HTML-Lomakkeelle t‰ytetyt tiedot

	if (request.getParameter("nimi") != null && request.getParameter("hinta1") != null) {

		// K‰yt‰ jos POISTO nappulaa ei haluta
		// String Nimi = request.getParameter("nimi");
		String Hinta = request.getParameter("hinta");
		double Hinta1 = Double.parseDouble(Hinta);
		;

		System.out.println("<p>");
		System.out.println("<b>" + pizza.getNimi() + "</b>");
		System.out.println("<br/>");
		System.out.println("Hinta: " + formaatteri.format(pizza.getHinta())
				+ " EUR");
		System.out.println("</p>");

		AdminKirjausDAO akDao = new AdminKirjausDAO();

		try {
			akDao.avaaYhteys();
			akDao.lisaaPizza(p);
			akDao.suljeYhteys();
		} catch (Exception e) {
			throw new ServletException(e);

		}
	}

	else {
		AdminKirjausDAO akDao = new AdminKirjausDAO();

		System.out.println("ID: " + poistettavaid);

		try {
			akDao.avaaYhteys();
			akDao.poistaPizza(poistettavaid);
			akDao.suljeYhteys();
		} catch (Exception e) {
			throw new ServletException(e);

		}

		response.sendRedirect("controller");

	

	}
}
}*/

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
			 
			 admin = AdminKirjausDAO.login(admin);
			 
			 if (admin.isValid()) {
				 HttpSession session = request.getSession(true); 
				 session.setAttribute("Login",admin); 
				 response.sendRedirect("kontrolleri"); //logged-in page
			 }else 
				 response.sendRedirect("adminkirjautuminen.jsp"); //error page 
		}
		catch (Throwable theException){ 
			System.out.println(theException); 
			}
		}
	}
