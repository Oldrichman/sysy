package TuoteDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.bean.Tuote;

public class TuoteDao {

	private Connection yhteys = null;
	
	public void avaaYhteys() {
		// TIETOKANTAHAKU
	
		String username = "";
		String password = "";
		String url = "";
		
		// YHTEYDEN AVAUS JA HAKU
				// ajurin lataus
	try {
		Class.forName("org.mariadb.jdbc.Driver").newInstance();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
				// avataan yhteys
	try {
		yhteys = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}	
				// suljetaan yhteys
	public void suljeYhteys() {
		try {
			yhteys.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Tuote> haeTuotteet() {

		ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();


		try {

			// suoritetaan haku
			String sql = "select * from tuote";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);

			// käydään hakutulokset läpi
			while (resultset.next()) {
				Tuote tuote = new Tuote();
				tuote.setId(resultset.getInt("id"));
				tuote.setNimi(resultset.getString("nimi"));
				tuote.setHinta(resultset.getDouble("hinta"));

				/*
				 * //lisätään tuote listaan Tuote t = new Tuote(id, nimi,
				 * hinta); pizza.add(p); }
				 */

			}
		} catch (Exception e) {
			// JOTAIN VIRHEITÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
		} finally {
			
		}
		
		System.out.println("HAETTIIN TIETOKANNASTA TUOTTEET: "
				+ tuotteet.toString());

		return tuotteet;	
	}	
	
	public void lisaaTuote(Tuote t) throws SQLException{
		
		try {
			
			//suoritetaan haku
			
			//alustetaan sql-lause
			String sql = "insert into tuote(nimi, hinta) values(?,?)";
			PreparedStatement resultset = yhteys.prepareStatement(sql);
			
			//täytetään puuttuvat tiedot
			resultset.setString(1, t.getNimi());
			resultset.setDouble(2, t.getHinta());
			
			//suoritetaan lause
			resultset.executeUpdate();
			System.out.println("LISÄTTIIN TUOTE TIETOKANTAAN: "+t);
		} catch(Exception e) {
			//JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tuotteen lisäämisyritys aiheutti virheen");
		}finally {
		}
	}
}
