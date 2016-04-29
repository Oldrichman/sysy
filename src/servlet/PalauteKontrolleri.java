package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import avustaja.Email;

/**
 * Servlet implementation class PalauteKontrolleri
 */
@WebServlet("/PalauteKontrolleri")
public class PalauteKontrolleri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PalauteKontrolleri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Palaute vastaanotettu");
		String action = request.getParameter("action");
		
		if (action != null && action.equals("Lähetä")) {
			String palaute = request.getParameter("palaute");
			String palautemail = request.getParameter("palautemail");
			String kokopalaute = palautemail + ": " + palaute ;
			System.out.println(kokopalaute);
			//Olion perusluontitapa
			Email email = new Email();
			//metodin kutsu
			email.lahetaSahkoposti("88juslin@gmail.com", "88juslin!", "kim.friman2@myy.haaga-helia.fi", "Palaute@pizzeriaFiori", kokopalaute);
		}
	RequestDispatcher disp =
		 request.getRequestDispatcher("KiitosPalautteesta.jsp");
	disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
