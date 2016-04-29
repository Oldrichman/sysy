package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.Konnektori;
import password.Kayttaja;

public class KayttajaDao {

	private Connection yhteys = null;
	// Otettu Mikolta ohje ja tehty sen perusteella OH
	static Konnektori currentCon = null;
	static ResultSet rs = null;

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

	public ArrayList<Kayttaja> haeTiedot(String email) {

		ArrayList<Kayttaja> tiedot = new ArrayList<Kayttaja>();

		try {

			// suoritetaan haku

			Kayttaja kayttaja = new Kayttaja();
			kayttaja.setEmail(email);
			// connect to DB
			Connection currentCon = Konnektori.getConnection();
			PreparedStatement usernamehaku = currentCon
					.prepareStatement("SELECT * from Asiakas where email = ?");
			System.out.println(usernamehaku.toString());
			System.out.println(kayttaja.getEmail());
			usernamehaku.setString(1, kayttaja.getEmail());
			rs = usernamehaku.executeQuery();

			// käydään hakutulokset läpi
			while (rs.next()) {

				kayttaja.setEtunimi(rs.getString("etunimi"));
				kayttaja.setSukunimi(rs.getString("sukunimi"));
				kayttaja.setEmail(rs.getString("email"));
				kayttaja.setOsoite(rs.getString("osoite"));
				kayttaja.setPostinro(rs.getString("postinro"));
				kayttaja.setSalasana(rs.getString("salasana"));
				kayttaja.setSuosikkiPitsa(rs.getString("suosikkiPitsa"));
				tiedot.add(kayttaja);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETÄ TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
			System.out.println(e);
		} finally {

		}

		System.out.println("HAETTIIN TIETOKANNASTA TIEDOT: "
				+ tiedot.toString());

		return tiedot;
	}

	public void paivitaOsoite(String osoite, String email) {
		try {

			String sql = "UPDATE Asiakas SET osoite = ? WHERE email = ?";
			PreparedStatement st = yhteys.prepareStatement(sql);

			st.setString(1, osoite);
			st.setString(2, email);
			
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}}
		public void paivitaPostinro(String postinro, String email) {
			try {

				String sql = "UPDATE Asiakas SET postinro = ? WHERE email = ?";
				PreparedStatement st = yhteys.prepareStatement(sql);

				st.setString(1, postinro);
				st.setString(2, email);
				
				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}}
			public void paivitaSuosikkipitsa(String suosikkipitsa, String email) {
				try {

					String sql = "UPDATE Asiakas SET suosikkipitsa = ? WHERE email = ?";
					PreparedStatement st = yhteys.prepareStatement(sql);

					st.setString(1, suosikkipitsa);
					st.setString(2, email);
					
					st.executeUpdate();

				} catch (Exception e) {
					System.out.println(e);
				}
	}

}
