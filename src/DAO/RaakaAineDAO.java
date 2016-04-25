package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.RaakaAineet;
/**
 * 
 * @author Joni Bärlund, SySy
 *
 */
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
			String sql = "select * from Raaka_aine ORDER BY nimi";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);

			// k�yd��n hakutulokset l�pi
			while (resultset.next()) {
				RaakaAineet raakaAine = new RaakaAineet();

				raakaAine.setNimi(resultset.getString("nimi"));
				raakaAine.setPoisto(resultset.getString("poisto"));
				raakaAineet.add(raakaAine);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETT� TAPAHTUI
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

			// t�ytet��n puuttuvat tiedot

			resultset.setString(1, RA.getNimi());

			// suoritetaan lause
			resultset.executeUpdate();
			System.out.println("LIS�TTIIN RAAKA-AINE TIETOKANTAAN: " + RA);
		} catch (Exception e) {
			// JOTAIN VIRHETT� TAPAHTUI
			System.out.println("Raaka-aineen lis��misyritys aiheutti virheen");
			System.out.println(e);
		} finally {
		}

	}

	public void piilotaRaakaAine(String nimi) {
		try {

			String sql = "UPDATE Raaka_aine SET poisto = 'piilotettu' where nimi = ?";
			PreparedStatement st = yhteys.prepareStatement(sql);

			st.setString(1, nimi);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
		public void poistaRaakaAine(String nimi) {
			try {

				String sql = "DELETE FROM Raaka_aine where nimi = ?";
				PreparedStatement st = yhteys.prepareStatement(sql);

				st.setString(1, nimi);
				st.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);}
			}
			public void TuoRaakaAine(String nimi) {
				try {

					String sql = "UPDATE Raaka_aine SET poisto = null WHERE nimi = ?";
					PreparedStatement st = yhteys.prepareStatement(sql);

					st.setString(1, nimi);
					st.executeUpdate();

				} catch (Exception e) {
					System.out.println(e);
				}
		
		}
		

}

