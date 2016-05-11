package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
		
		HttpSession sessio = request.getSession(false);
		
		
		List<Tuote> lista = null;
		lista = (List<Tuote>) sessio.getAttribute("kori");
		for (int i = 0; i < lista.size(); i++) {
			wout.print(lista.get(i));
		}

		// requestiin talteen
		request.setAttribute("tilaus", lista);

		// jsp hoitaa muotoilun
		request.getRequestDispatcher("Ostoskori.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		TilausDAO tDao = new TilausDAO();
		request.setCharacterEncoding("UTF-8");
	/*	if (request.getParameter("tilausnumero").equals("Lisää ostoskoriin")){
			String tuoteid = request.getParameter("tuoteid");
			String hinta = request.getParameter("hinta");
		}*/
		if (request.getParameter("tilausnumero") != null) {
			int maara2 = 0;
			String asiakastunnus = request.getParameter("asiakastunnus");
			if (request.getParameter("maara") != null) {
				String maara = request.getParameter("maara");
				maara2 = Integer.parseInt(maara);
			} else {
				maara2 = 1;
			}
			
			String tuoteID = "";
			HttpSession sessio = request.getSession(false);
			
			String koksum = String.valueOf(sessio.getAttribute("kokonaissumma")); 
			
			
			if(koksum != null && !koksum.isEmpty() && koksum != "null" ) {
				double summa = Double.parseDouble(koksum);
				sessio.setAttribute("kokonaissumma", summa + Double.parseDouble(request.getParameter("hinta")));
				
				
			} else {

				sessio = request.getSession(true);
				tuoteID = request.getParameter("tuoteid");
				System.out.println(tuoteID);
				int tuoteID2 = Integer.parseInt(tuoteID);				
				Tuote pizza = new Tuote();				
				pizza = tDao.haeTuote(tuoteID2);
				sessio.setAttribute("kokonaissumma", pizza.getHinta());


			}
			
			List<Tuote>kori = (List<Tuote>) sessio.getAttribute("kori");
			
			if(kori == null){
				kori = new ArrayList<Tuote>();
				sessio.setAttribute("kori", kori);
			}
			
			
			

			tuoteID = request.getParameter("tuoteid");			
			int tuoteId = 0;
			
			if(tuoteID != null && !tuoteID.isEmpty()){
			tuoteId = Integer.parseInt(tuoteID);
			System.out.println("Tuoteid on " + tuoteId);			
			kori.add(tDao.haeTuote(tuoteId));
			sessio.setAttribute("kori", kori);
			}
			
			String toimitustapa = request.getParameter("toimitustapa");

//			Tilaus tilaus = new Tilaus(0, asiakastunnus, maara2, kokonaissumma,
//					tuoteID2, toimitustapa);
			
			Tilaus tamaTilaus = new Tilaus();

			System.out.println("<p>");
			System.out.println("<b>" + tamaTilaus.getAsiakastunnus() + "</b>");
			System.out.println("<b> Määrä: " + tamaTilaus.getMaara() + "</b>");
			System.out.println("<b> Kokonaissumma: " + sessio.getAttribute("kokonaissumma")
					+ "</b>");
			System.out.println("<br/>");
			System.out.println(": " + tamaTilaus.getTuoteID());
			System.out.println(": " + tamaTilaus.getToimitustapa());



			try {
				
			

			} catch (Exception e) {
				throw new ServletException(e);

			}
			response.sendRedirect("LisaaOstoskoriin");
		}

	}
}