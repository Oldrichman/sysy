package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import password.Kayttaja;


public class KayttajaDao {

	private Connection yhteys = null;

	public void avaaYhteys() {
		// TIETOKANTAHAKU

		String username = "a1500948";
		String password = "cuZA2s32m";
		String url = "jdbc:mariadb://localhost/a1500948";

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void suljeYhteys() {
		try {
			yhteys.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Kayttaja> haeTiedot() {

		ArrayList<Kayttaja> tiedot = new ArrayList<Kayttaja>();

		try {

			// suoritetaan haku
			String sql = "select * from Asiakas where Id = 1 ";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);

			// käydään hakutulokset läpi
			while (resultset.next()) {
				Kayttaja kayttaja = new Kayttaja();
				
				kayttaja.setEtunimi(resultset.getString("etunimi"));
				kayttaja.setSukunimi(resultset.getString("sukunimi"));
				kayttaja.setEmail(resultset.getString("email"));
				kayttaja.setOsoite(resultset.getString("osoite"));
				kayttaja.setPostinro(resultset.getString("postinro"));
				kayttaja.setSalasana(resultset.getString("salasana"));
				tiedot.add(kayttaja);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
			System.out.println(e);
		} finally {

		}

		System.out.println("HAETTIIN TIETOKANNASTA TIEDOT: "
				+ tiedot.toString());

		return tiedot;
	}

	}
	

	