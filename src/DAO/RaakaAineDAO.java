package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.RaakaAineet;

public class RaakaAineDAO {

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

	public ArrayList<RaakaAineet> haeRaakaAineet() {

		ArrayList<RaakaAineet> raakaAineet = new ArrayList<>();

		try {

			// suoritetaan haku
			String sql = "select * from Raaka_aine";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);

			// käydään hakutulokset läpi
			while (resultset.next()) {
				RaakaAineet raakaAine = new RaakaAineet();

				raakaAine.setNimi(resultset.getString("nimi"));

				raakaAineet.add(raakaAine);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
		} finally {

		}

		System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: "
				+ raakaAineet.toString());

		return raakaAineet;
	}

	public void lisaaRaakaAine(RaakaAineet RA) {

		try {

			// suoritetaan haku

			// alustetaan sql-lause

			String sql = "insert into Raaka_aine(nimi) values(?)";

			PreparedStatement resultset = yhteys.prepareStatement(sql);

			// täytetään puuttuvat tiedot

			resultset.setString(2, RA.getNimi());

			// suoritetaan lause
			resultset.executeUpdate();
			System.out.println("LISÄTTIIN RAAKA-AINE TIETOKANTAAN: " + RA);
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Raaka-aineen lisäämisyritys aiheutti virheen");
			System.out.println(e);
		} finally {
		}

	}

	public void poistaRaakaAine(String nimi) {
		try {

			String sql = "DELETE FROM Raaka_aine WHERE nimi = ?";
			PreparedStatement st = yhteys.prepareStatement(sql);

			st.setString( 0, nimi);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

