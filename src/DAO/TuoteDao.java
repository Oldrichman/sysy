package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.Tuote;

public class TuoteDao {

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

	public ArrayList<Tuote> haeTuotteet() {

		ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();

		try {

			// suoritetaan haku
			String sql = "select * from Tuote";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);

			// käydään hakutulokset läpi
			while (resultset.next()) {
				Tuote tuote = new Tuote();
				tuote.setId(resultset.getInt("id"));
				tuote.setNimi(resultset.getString("nimi"));
				tuote.setHinta(resultset.getDouble("hinta"));
				tuote.setTaytteet(resultset.getString("taytteet"));

				tuotteet.add(tuote);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
		} finally {

		}

		System.out.println("HAETTIIN TIETOKANNASTA TUOTTEET: "
				+ tuotteet.toString());

		return tuotteet;
	}

	public void lisaaTuote(Tuote t) {

		try {

			// suoritetaan haku

			// alustetaan sql-lause

			String sql = "insert into Tuote(id, nimi, hinta, taytteet) values(?,?,?,?)";

			PreparedStatement resultset = yhteys.prepareStatement(sql);

			// täytetään puuttuvat tiedot
			resultset.setInt(1, t.getId());
			resultset.setString(2, t.getNimi());
			resultset.setDouble(3, t.getHinta());
			resultset.setString(4, t.getTaytteet());
		

			// suoritetaan lause
			resultset.executeUpdate();
			System.out.println("LISÄTTIIN TUOTE TIETOKANTAAN: " + t);
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tuotteen lisäämisyritys aiheutti virheen");
			System.out.println(e);
		} finally {
		}

	}

	public void poistaTuote(int id) {
		try {

			String sql = "DELETE FROM Tuote WHERE id = ?";
			PreparedStatement st = yhteys.prepareStatement(sql);

			st.setInt(1, id);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}}