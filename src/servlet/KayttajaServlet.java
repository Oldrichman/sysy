package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import password.Kayttaja;
import DAO.JuomaDAO;
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
						
						HttpSession session = request.getSession(false);
						Kayttaja kayttaja = (Kayttaja) session.getAttribute("Login");
						String email = kayttaja.getEmail();

						List<Kayttaja> lista = null;
						lista = kDao.haeTiedot(email);
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
					response.setContentType("text/html;charset=UTF-8");
					 PrintWriter out = response.getWriter();
					 out.println("<font color=red>Rekisteröinti onnistui!</font>");
					 RequestDispatcher rd = getServletContext().getRequestDispatcher("/kotisivu.jsp");
					 rd.include(request, response); //error page
				}
			else if (request.getParameter("email") != null
					&& request.getParameter("action").equals("Tallenna tiedot")) {
				HttpSession session = request.getSession(false);
				KayttajaDao TDao = new KayttajaDao();
				Kayttaja kayttaja = (Kayttaja) session.getAttribute("Login");
				String email = kayttaja.getEmail();
				String osoite = null;
				String postinro = null;
				String suosikkipitsa = null;
			
				try {
					osoite = (request.getParameter("osoite"));
					email = (request.getParameter("email"));
					postinro = (request.getParameter("postinro"));
					suosikkipitsa = (request.getParameter("suosikkipitsa"));
					
				} catch (Exception ex) {
					System.out.println(ex);
				}
				
				System.out.println("osoite: " + osoite );
				try {
					TDao.avaaYhteys();
					TDao.paivitaOsoite(email,osoite);
					TDao.paivitaPostinro(email,postinro);
					TDao.paivitaSuosikkipitsa(email,suosikkipitsa);
					TDao.suljeYhteys();
				} catch (Exception e) {
					throw new ServletException(e);

				}
				response.sendRedirect("KayttajaServlet");
				return;
				}
				
		    }}
	
