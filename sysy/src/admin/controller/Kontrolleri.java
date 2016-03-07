package admin.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TuoteDao.TuoteDao;
import admin.bean.Tuote;


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
			
			//TuoteDao haku
			TuoteDao tDao = new TuoteDao();
			
			tDao.avaaYhteys(); 
			
			List<Tuote> lista = null;
			lista = tDao.haeTuotteet();
			for (int i = 0; i < lista.size(); i++) {
				wout.print(lista.get(i));
			}
		
			tDao.suljeYhteys();
			//requestiin talteen
			request.setAttribute("", lista);
			
		
			
			//jsp hoitaa muotoilun
			request.getRequestDispatcher("kotisivu.jsp").forward(request, response);
			
			request.setAttribute("tuotteet", lista);
			request.getRequestDispatcher("tuote.jsp").forward(request, response);
			wout.close();
			
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			
			//Luetaan HTML-Lomakkeelle täytetyt tiedot
			
			String Nimi = request.getParameter("nimi");
			String Hinta = request.getParameter("hinta");
			double Hinta1 = Double.parseDouble(Hinta);
			Tuote tuote = new Tuote(1, Nimi, Hinta1);
			DecimalFormat formaatteri = new DecimalFormat("0.00");

			System.out.println("<p>");
			System.out.println("<b>" + tuote.getNimi() + "</b>");
			System.out.println("<br/>");
			System.out.println("Hinta: " + formaatteri.format(tuote.getHinta())
					+ " EUR");
			System.out.println("</p>");
			
			
		
			
			request.getParameter("nimi");
			request.getParameter("hinta");
			
			Tuote t = new Tuote(0, Nimi, Hinta1);
			TuoteDao tDao = new TuoteDao();

			try {
				tDao.avaaYhteys();
				tDao.lisaaTuote(t);
				
			} catch (Exception e) {
				
				
			}
			
			response.sendRedirect("controller");
			tDao.suljeYhteys();
			
		
	}

}
