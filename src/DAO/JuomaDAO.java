package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.Juoma;

public class JuomaDAO {

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

	public ArrayList<Juoma> haeJuomat() {

		ArrayList<Juoma> juomat = new ArrayList<Juoma>();

		try {

			// suoritetaan haku
			String sql = "select * from Juomat ORDER BY juoma";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);

			// käydään hakutulokset läpi
			while (resultset.next()) {
				Juoma juoma = new Juoma();
				juoma.setJuoma(resultset.getString("juoma"));
				juoma.setHinta(resultset.getDouble("hinta"));
				

				juomat.add(juoma);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
		} finally {

		}

		System.out.println("HAETTIIN TIETOKANNASTA JUOMAT: "
				+juomat.toString());

		return juomat;
	}

	
	public void lisaaJuoma(Juoma j) {

		try {

			// suoritetaan haku

			// alustetaan sql-lause

			String sql = "insert into Juomat(juoma, hinta) values(?,?)";

			PreparedStatement resultset = yhteys.prepareStatement(sql);

			// täytetään puuttuvat tiedot
			resultset.setString(1, j.getJuoma());
			resultset.setDouble(2, j.getHinta());
			
		

			// suoritetaan lause
			resultset.executeUpdate();
			System.out.println("LISÄTTIIN JUOMA TIETOKANTAAN: " + j);
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Juoman lisäämisyritys aiheutti virheen");
			System.out.println(e);
		} finally {
		}

	}

	public void piilotaJuoma(String juoma) {
		try {

			String sql = "UPDATE Juomat SET poisto = 'X' WHERE juoma = ?";
			PreparedStatement st = yhteys.prepareStatement(sql);

			st.setString(1, juoma);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}}
		
	
	}