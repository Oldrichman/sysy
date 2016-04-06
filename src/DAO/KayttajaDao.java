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
import admin.Tuote;

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

	public ArrayList<Kayttaja> haeTiedot(Kayttaja t) {

		ArrayList<Kayttaja> tietoja = new ArrayList<Kayttaja>();

		try {

			// suoritetaan haku
			String sql = "select * from Asiakas where email = testi@sysy.fi";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);

			// käydään hakutulokset läpi
			while (resultset.next()) {
				Kayttaja tiedot = new Kayttaja();
				
				tiedot.setEtunimi(resultset.getString("etunimi"));
				tiedot.setSukunimi(resultset.getString("sukunimi"));
				tiedot.setEmail(resultset.getString("email"));
				tiedot.setOsoite(resultset.getString("osoite"));
				tiedot.setPostinro(resultset.getString("postinumero"));
				tiedot.setSalasana(resultset.getString("salasana"));
				tiedot.add(tietoja);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
		} finally {

		}

		System.out.println("HAETTIIN TIETOKANNASTA TUOTTEET: "
				+ tietoja.toString());

		return tietoja;
	}

	}
	

	