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
			lista = kDao.haeTiedot(null);
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

			

		

				Kayttaja t = new Kayttaja();
				KayttajaDao kDao = new KayttajaDao();
				
				try {
					
					kDao.avaaYhteys();
					kDao.haeTiedot(t);				
					kDao.suljeYhteys();
					
				} catch (Exception e) {
					throw new ServletException(e);
					
				}
				response.sendRedirect("KayttajaServlet");
			}

			
	    }
	


