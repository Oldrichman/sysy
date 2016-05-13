package servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.JuomaDAO;
import DAO.RaakaAineDAO;
import DAO.TuoteDao;
import admin.Juoma;
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
		
		String action = request.getParameter("action");
		
		if (action != null && action.equals("kirjaudu-ulos")) {
				
				
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.removeAttribute("Login");
					session.invalidate();
					response.sendRedirect(request.getContextPath() + "/");
				}
			}
		else {

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

		 // JuomaDAO haku
	    JuomaDAO jDao = new JuomaDAO();

	 		jDao.avaaYhteys();

	 		List<Juoma> lista2 = null;
	 		lista2 = jDao.haekaikkiJuomat();
	 		for (int i = 0; i < lista2.size(); i++) {
	 			wout.print(lista2.get(i));
	 		}

	 		jDao.suljeYhteys();

	 		

	 		// requestiin talteen
	 		request.setAttribute("Juoma", lista2);

		request.setAttribute("tuotteet", lista);
		request.setAttribute("RaakaAineet", lista1);
		// jsp hoitaa muotoilun
		request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
	//}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		
		
		// Luetaan HTML-Lomakkeelle t�ytetyt tiedot

		Object RaakaAineDAO;
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
			DecimalFormat formaatteri = new DecimalFormat("0,00");

			System.out.println("<p>");
			System.out.println("<b>" + tuote.getNimi() + "</b>");
			System.out.println("<b> T�ytteet: " + tuote.getTaytteet() + "</b>");
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
	
		} 
			response.setCharacterEncoding("UTF-8");
		

		
		

		else if (request.getParameter("LJU") != null 
				&& request.getParameter("HJU") != null) {
			
			String Juoma = request.getParameter("LJU");
			String HintaJU = request.getParameter("HJU");
			String poisto = request.getParameter("poisto");
			
			double HintaJUO = Double.parseDouble(HintaJU);
			
	
			
			System.out.println("Juoman nimi: " + Juoma);
			System.out.println("Hinta: " + HintaJUO);
			Juoma j = new Juoma(0, Juoma, HintaJUO, poisto);
			JuomaDAO JUDao = new JuomaDAO();

			try {
				JUDao.avaaYhteys();
				JUDao.lisaaJuoma(j);
				JUDao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("kontrolleri");
			return;
			} 
		
		
		
			else if (request.getParameter("lisaaRA") != null) {
			String Nimi = request.getParameter("lisaaRA");
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
				&& request.getParameter("action").equals("Piilota juoma")) {

			JuomaDAO JDao = new JuomaDAO();
			int PiilotaJuoma = 0;

	
			try {
				PiilotaJuoma = Integer.parseInt(request.getParameter("id"));
			} catch (Exception ex) {
				System.out.println(ex);
			}

			System.out.println("ID: " + PiilotaJuoma);
			try {
				JDao.avaaYhteys();
				JDao.piilotaJuoma(PiilotaJuoma);
				JDao.suljeYhteys();
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
		
		
		else if (request.getParameter("id") != null
				&& request.getParameter("action").equals("Tuo juoma")) {

			JuomaDAO TDao = new JuomaDAO();
			int TuoJuoma= 0;

	
			try {
				TuoJuoma = Integer.parseInt(request.getParameter("id"));
			} catch (Exception ex) {
				System.out.println(ex);
			}

			System.out.println("ID: " + TuoJuoma);
			try {
				TDao.avaaYhteys();
				TDao.TuoJuoma(TuoJuoma);
				TDao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("kontrolleri");
			return;
			}
		
		else if (request.getParameter("id") != null
				&& request.getParameter("action").equals("Tallenna")) {

			JuomaDAO TDao = new JuomaDAO();
			int id= 0;
			double uusihinta = 0;
			String juoma = null;
			
			try {
				id = Integer.parseInt(request.getParameter("id"));
				uusihinta = Double.parseDouble(request.getParameter("hinta"));
				juoma = (request.getParameter("juoma"));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			
			System.out.println("ID: " + id);
			try {
				TDao.avaaYhteys();
				TDao.paivitaHinta(id,uusihinta);
				TDao.paivitaJuoma(id, juoma);
				TDao.suljeYhteys();
			} catch (Exception e) {
				throw new ServletException(e);
			
			}
			response.sendRedirect("kontrolleri");
			return;
			
		}
		
		
	
		else if (request.getParameter("id") != null
				&& request.getParameter("action").equals("Tallenna muutos")) {

			TuoteDao TDao = new TuoteDao();
			int id= 0;
			double uusihinta = 0;
			
			
			
			try {
				id = Integer.parseInt(request.getParameter("id"));
				uusihinta = Double.parseDouble(request.getParameter("hinta"));
				
			} catch (Exception ex) {
				System.out.println(ex);
			}
			
			System.out.println("ID: " + id);
			try {
				TDao.avaaYhteys();
				TDao.paivitaHinta(id,uusihinta);
				
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