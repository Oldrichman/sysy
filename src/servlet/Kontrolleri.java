package servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RaakaAineDAO;
import DAO.TuoteDao;
import admin.RaakaAineet;
import admin.Tuote;

@WebServlet("/kontrolleri")
public class Kontrolleri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Kontrolleri() {
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter wout = response.getWriter();

		// TuoteDao haku
		TuoteDao tDao = new TuoteDao();

		tDao.avaaYhteys();

		List<Tuote> lista = null;
		lista = tDao.haeTuotteet();
		for (int i = 0; i < lista.size(); i++) {
			wout.print(lista.get(i));
		}

		tDao.suljeYhteys();

		// tietokannasta raaka-aineet
		RaakaAineDAO RADao = new RaakaAineDAO();

		RADao.avaaYhteys();

		List<RaakaAineet> lista1 = null;
		lista1 = RADao.haeRaakaAineet();
		for (int i = 0; i < lista1.size(); i++) {
			wout.print(lista1.get(i));
		}

		RADao.suljeYhteys();

		// requestiin talteen
		request.setAttribute("tuotteet", lista);
		request.setAttribute("RaakaAineet", lista1);
		// jsp hoitaa muotoilun
		request.getRequestDispatcher("admin.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		// Luetaan HTML-Lomakkeelle t�ytetyt tiedot

		if (request.getParameter("nimi") != null
				&& request.getParameter("hinta") != null) {
			String id = request.getParameter("id");
			int id1 = Integer.parseInt(id);
			String Nimi = request.getParameter("nimi");
			String Hinta = request.getParameter("hinta");
			String taytteet = request.getParameter("taytteet");
			double Hinta1 = Double.parseDouble(Hinta);
			Tuote tuote = new Tuote(id1, Nimi, Hinta1, taytteet);
			DecimalFormat formaatteri = new DecimalFormat("0.00");

			System.out.println("<p>");
			System.out.println("<b>" + tuote.getNimi() + "</b>");
			System.out.println("<b> T�ytteet: " + tuote.getTaytteet() + "</b>");
			System.out.println("<br/>");
			System.out.println("Hinta: " + formaatteri.format(tuote.getHinta())
					+ " EUR");

			

			System.out.println("</p>");

			Tuote t = new Tuote(id1, Nimi, Hinta1, taytteet);
			TuoteDao tDao = new TuoteDao();
			
			try {
				
				tDao.avaaYhteys();
				tDao.lisaaTuote(t);				
				tDao.suljeYhteys();
				
			} catch (Exception e) {
				throw new ServletException(e);
				
			}
			response.sendRedirect("kontrolleri");
		}

		else {
			TuoteDao tDao = new TuoteDao();
			int poistettavaid = 0;
			try {
			poistettavaid = Integer.parseInt(request.getParameter("id"));
			} catch (Exception ex) {
				System.out.println(ex);
			}

			System.out.println("ID: " + poistettavaid);

			try {
				tDao.avaaYhteys();
				tDao.poistaTuote(poistettavaid);
				tDao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);
			}
			
			
			
			if (request.getParameter("nimi") != null
					) {
				String Nimi = request.getParameter("nimi");
				RaakaAineet RA = new RaakaAineet(Nimi);
				

				System.out.println("<p>");
				System.out.println("<b>" + RA.getNimi() + "</b>");
				
				System.out.println("<br/>");
			
			
			 RaakaAineet r1 = new RaakaAineet(Nimi);
			 RaakaAineDAO RADao = new RaakaAineDAO();
			 
			 try {
			 RADao.avaaYhteys();
			 RADao.lisaaRaakaAine(r1);
			 RADao.suljeYhteys();
			 } catch (Exception e) {
					throw new ServletException(e);
					
				}
			 response.sendRedirect("kontrolleri");
			}
			
			 else {
			 RaakaAineDAO RADao = new RaakaAineDAO();
			 String poistettavaNimi = (request.getParameter("nimi"));

			 System.out.println("NIMI: " + poistettavaNimi);
			 
			 try {
			 RADao.avaaYhteys();
			 RADao.poistaRaakaAine(poistettavaNimi);
			 RADao.suljeYhteys();
			 } catch (Exception e) {
			 throw new ServletException(e);
			
			 }

	}
}}}