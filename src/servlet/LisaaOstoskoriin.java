package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import password.Kayttaja;
import admin.Juoma;
import admin.RaakaAineet;
import admin.Tilaus;
import admin.Tuote;
import DAO.JuomaDAO;
import DAO.KayttajaDao;
import DAO.KayttajaKirjausDAO;
import DAO.RaakaAineDAO;
import DAO.TilausDAO;
import DAO.TuoteDao;

@WebServlet("/LisaaOstoskoriin")
public class LisaaOstoskoriin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LisaaOstoskoriin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter wout = response.getWriter();

		// KayttajaDao haku
		TilausDAO tDao = new TilausDAO();

		List<Tilaus> lista = null;
		lista = tDao.haeTiedot();
		for (int i = 0; i < lista.size(); i++) {
			wout.print(lista.get(i));
		}

		// requestiin talteen
		request.setAttribute("tilaus", lista);

		// jsp hoitaa muotoilun
		request.getRequestDispatcher("Ostoskori.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("tilausnumero") != null) {
			int maara2 = 0;
			String asiakastunnus = request.getParameter("asiakastunnus");
			if (request.getParameter("maara") != null) {
				String maara = request.getParameter("maara");
				maara2 = Integer.parseInt(maara);
			} else {
				maara2 = 1;
			}
			double kokonaissumma = 0;
			HttpSession sessio = request.getSession(false);
			if(sessio == null) {
				sessio = request.getSession(true);
				kokonaissumma = Double.parseDouble(request.getParameter("hinta"));
				sessio.setAttribute("kokonaissumma", kokonaissumma);
			} else if(sessio.getAttribute("hinta") != null){
				double summa = Double.parseDouble((String)sessio.getAttribute("hinta")); 
				sessio.setAttribute("kokonaissumma", summa + Double.parseDouble(request.getParameter("hinta")));
				
			}
			

			String tuoteID = request.getParameter("tuoteid");
			System.out.println(tuoteID);
			int tuoteID2 = Integer.parseInt(tuoteID);
			String toimitustapa = request.getParameter("toimitustapa");

			Tilaus tilaus = new Tilaus(0, asiakastunnus, maara2, kokonaissumma,
					tuoteID2, toimitustapa);

			System.out.println("<p>");
			System.out.println("<b>" + tilaus.getAsiakastunnus() + "</b>");
			System.out.println("<b> Sukunimi: " + tilaus.getMaara() + "</b>");
			System.out.println("<b> Email: " + tilaus.getKokonaissumma()
					+ "</b>");
			System.out.println("<br/>");
			System.out.println(": " + tilaus.getTuoteID());
			System.out.println(": " + tilaus.getToimitustapa());

			Tilaus t = new Tilaus(0, asiakastunnus, maara2, kokonaissumma,
					tuoteID2, toimitustapa);
			TilausDAO tiDao = new TilausDAO();

			try {

				tiDao.lisaaTuote(t);

			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("LisaaOstoskoriin");
		}

	}
}