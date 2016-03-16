package servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminKirjausDAO;
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

		// Haetaan käyttäjän tiedot
		//AdminKirjausDAO akDao = new AdminKirjausDAO();
		//akDao.avaaYhteys();
		//if (((String)request.getAttribute("username")).equals("admin") && (request.getAttribute("userid")!=null)) {
			//akDao.suljeYhteys();
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
	//}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		// Luetaan HTML-Lomakkeelle täytetyt tiedot

		if (request.getParameter("nimi") != null
				&& request.getParameter("hinta") != null) {
			
			
			String Nimi = request.getParameter("nimi");
			String Hinta = request.getParameter("hinta");
			String[] taytteetarray = request.getParameterValues("taytteet");
			String poisto = request.getParameter("poisto");
			double Hinta1 = Double.parseDouble(Hinta);
			
			String taytteet = taytteetarray[0];
			
			for (int i = 1; i < taytteetarray.length; i++) {
				taytteet += ", " + taytteetarray[i];
			}
			
			Tuote tuote = new Tuote(0, Nimi, Hinta1, taytteet ,poisto);
			DecimalFormat formaatteri = new DecimalFormat("0.00");

			System.out.println("<p>");
			System.out.println("<b>" + tuote.getNimi() + "</b>");
			System.out.println("<b> Täytteet: " + tuote.getTaytteet() + "</b>");
			System.out.println("<b> Piilotettu: " + tuote.getPoisto() + "</b>");
			System.out.println("<br/>");
			System.out.println("Hinta: " + formaatteri.format(tuote.getHinta())
					+ " EUR");

			System.out.println("</p>");

			Tuote t = new Tuote(0, Nimi, Hinta1, taytteet, poisto);
			TuoteDao tDao = new TuoteDao();

			try {

				tDao.avaaYhteys();
				tDao.lisaaTuote(t);
				tDao.suljeYhteys();

			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("kontrolleri");

		} else if (request.getParameter("nimi") != null
				&& request.getParameter("action").equals("Piilota")) {

			RaakaAineDAO RADao = new RaakaAineDAO();
			String PiilotaNimi = (request.getParameter("nimi"));

			System.out.println("NIMI: " + PiilotaNimi);

			try {
				RADao.avaaYhteys();
				RADao.piilotaRaakaAine(PiilotaNimi);
				RADao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);

			}
			
			response.sendRedirect("kontrolleri");
			return;}
			
			else if (request.getParameter("nimi") != null
					&& request.getParameter("action").equals("Tuo täyte")) {

				RaakaAineDAO RADao = new RaakaAineDAO();
				String TuoNimi = (request.getParameter("nimi"));

				System.out.println("NIMI: " + TuoNimi);

				try {
					RADao.avaaYhteys();
					RADao.TuoRaakaAine(TuoNimi);
					RADao.suljeYhteys();
				} catch (Exception e) {
					throw new ServletException(e);

				}
				
				response.sendRedirect("kontrolleri");
				return;
			
		} else if (request.getParameter("pois") != null
				&& request.getParameter("action").equals("Poista")) {

			RaakaAineDAO RADao = new RaakaAineDAO();
			String PoistaNimi = (request.getParameter("pois"));

			System.out.println("NIMI: " + PoistaNimi);

			try {
				RADao.avaaYhteys();
				RADao.poistaRaakaAine(PoistaNimi);
				RADao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("kontrolleri");
			return;

		} else if (request.getParameter("lisaa") != null) {
			String Nimi = request.getParameter("lisaa");
			String Poisto = request.getParameter("poisto");
			RaakaAineet RA = new RaakaAineet(Nimi, Poisto);
	
			
			System.out.println("Täytteen nimi: " + Nimi);
	
			RaakaAineDAO RADao = new RaakaAineDAO();

			try {
				RADao.avaaYhteys();
				RADao.lisaaRaakaAine(RA);
				RADao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("kontrolleri");
			return;
		}

		else if (request.getParameter("id") != null
				&& request.getParameter("action").equals("Piilota menusta")) {

			TuoteDao TDao = new TuoteDao();
			int PiilotaTuote = 0;

	
			try {
				PiilotaTuote = Integer.parseInt(request.getParameter("id"));
			} catch (Exception ex) {
				System.out.println(ex);
			}

			System.out.println("ID: " + PiilotaTuote);
			try {
				TDao.avaaYhteys();
				TDao.piilotaTuote(PiilotaTuote);
				TDao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("kontrolleri");
			return;
			}
		
		else if (request.getParameter("id") != null
				&& request.getParameter("action").equals("Tuo menuun")) {

			TuoteDao TDao = new TuoteDao();
			int TuoTuote = 0;

	
			try {
				TuoTuote = Integer.parseInt(request.getParameter("id"));
			} catch (Exception ex) {
				System.out.println(ex);
			}

			System.out.println("ID: " + TuoTuote);
			try {
				TDao.avaaYhteys();
				TDao.TuoTuote(TuoTuote);
				TDao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("kontrolleri");
			return;
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
			response.sendRedirect("kontrolleri");
			return;
		}
	}
}