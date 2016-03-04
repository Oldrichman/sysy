package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TuoteDao.TuoteDao;
import admin.bean.Tuote;


@WebServlet("/etusivu")
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
			
			request.setAttribute("", lista);
			request.getRequestDispatcher("kotisivu.jsp").forward(request, response);
			wout.close();
			
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
		
	}

}
