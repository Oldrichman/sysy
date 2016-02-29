package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//LISÄÄ KOMMENTTIA SAATANA
//KOMMENTTIATESTI
/*Olen apina isossa maailmassa, vai mitä luulet Oskari?
		Onko täällä elämää?
				Mua pelottaa.
*//**
 * Servlet implementation class Kontrolleri
 */
//Olen uusi kommentti
@WebServlet("/Kontrolleri")
public class Kontrolleri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kontrolleri() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
