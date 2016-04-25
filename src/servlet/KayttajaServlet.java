package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import password.Kayttaja;
import DAO.KayttajaDao;
import DAO.KayttajaKirjausDAO;


	/**
	 * Servlet implementation class MenuKontrolleri
	 */
	@WebServlet("/KayttajaServlet")
	public class KayttajaServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public KayttajaServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
	    protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			java.io.PrintWriter wout = response.getWriter();

			// KayttajaDao haku
						KayttajaDao kDao = new KayttajaDao();

						kDao.avaaYhteys();

						List<Kayttaja> lista = null;
						lista = kDao.haeTiedot("testi@sysy.fi");
						for (int i = 0; i < lista.size(); i++) {
							wout.print(lista.get(i));
						}

						kDao.suljeYhteys();

						

						// requestiin talteen
						request.setAttribute("tiedot", lista);
						
						// jsp hoitaa muotoilun
						request.getRequestDispatcher("Kayttaja.jsp").forward(request, response);
						

					}
		

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	    protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");

			request.setCharacterEncoding("UTF-8");
			
			if (request.getParameter("email") != null){
				
				String etunimi = request.getParameter("etunimi");
				String sukunimi = request.getParameter("sukunimi");
				String email = request.getParameter("email");
				String osoite = request.getParameter("osoite");
				String postinro = request.getParameter("postinro");
				String salasana = request.getParameter("salasana");
				String suola = request.getParameter("suola");
				String suosikkiPitsa = request.getParameter("suosikkiPitsa");

				Kayttaja kayttaja = new Kayttaja(0, etunimi, sukunimi, email, osoite, postinro, salasana, suola, suosikkiPitsa);
			
				System.out.println("<p>");
				System.out.println("<b>" + kayttaja.getEtunimi() + "</b>");
				System.out.println("<b> Sukunimi: " + kayttaja.getSukunimi() + "</b>");
				System.out.println("<b> Email: " + kayttaja.getEmail() + "</b>");
				System.out.println("<br/>");
				System.out.println(": " + kayttaja.getOsoite());
				System.out.println(": " + kayttaja.getPostinro());
				
					Kayttaja k = new Kayttaja(0, etunimi, sukunimi, email, osoite, postinro, salasana, suola, suosikkiPitsa);
					KayttajaKirjausDAO krDao = new KayttajaKirjausDAO();
					
					try {
						
						krDao.lisaaKayttaja(k);
						
					} catch (Exception e) {
						throw new ServletException(e);
						
					}
					response.sendRedirect("KayttajaServlet");
				}

				
		    }}
	


