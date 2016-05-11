package DAO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import admin.Konnektori;
import admin.Tilaus;
import admin.Tuote;

public class TilausDAO {

	private Connection yhteys = null;
	// Otettu Mikolta ohje ja tehty sen perusteella OH
	static Konnektori currentCon = null;
	static ResultSet rs = null;

	public ArrayList<Tilaus> haeTiedot() {

		ArrayList<Tilaus> tiedot = new ArrayList<Tilaus>();

		try {

			// suoritetaan haku
			int tilausnumero = 0;
			Tilaus tilaus = new Tilaus();
			tilaus.setTilausnumero(tilausnumero);
			// connect to DB
			Connection currentCon = Konnektori.getConnection();
			PreparedStatement usernamehaku = currentCon
					.prepareStatement("SELECT * from Tilaus where tilausnumero = ?");
			System.out.println(usernamehaku.toString());
			System.out.println(tilaus.getTilausnumero());
			usernamehaku.setInt(1, tilaus.getTilausnumero());
			rs = usernamehaku.executeQuery();

			// k�yd��n hakutulokset l�pi
			while (rs.next()) {

				tilaus.setAsiakastunnus(rs.getString("asiakastunnus"));
				tilaus.setMaara(rs.getInt("maara"));
				tilaus.setKokonaissumma(rs.getDouble("kokonaissumma"));
				tilaus.setTuoteID(rs.getInt("tuoteID"));
				tilaus.setToimitustapa(rs.getString("toimitustapa"));

				tiedot.add(tilaus);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETT� TAPAHTUI
			System.out.println("Tietokantahaku aiheutti virheen");
			System.out.println(e);
		} finally {

		}

		System.out.println("HAETTIIN TIETOKANNASTA TIEDOT: "
				+ tiedot.toString());

		return tiedot;

	}

	public void lisaaTuote(Tilaus t) {

		try { // connect to DB
			Connection currentCon = Konnektori.getConnection();

			PreparedStatement tLisays = currentCon
					.prepareStatement("insert into Tilaus(asiakasID, tilausnumero, tuotemaara, kokonaishinta) values(?,?,?,?)");

			if ("tuotemaara" != null)
				/*
				 * {t.getMaara()
				 * 
				 * cart[itemCount] = new Item(itemName, price, quantity);
				 * 
				 * totalPrice += (totalPrice * quantity);
				 * 
				 * itemCount++; }
				 */
				tLisays.setString(2, t.getAsiakastunnus());
			tLisays.setInt(1, t.getTilausnumero());
			tLisays.setInt(3, t.getMaara());
			tLisays.setDouble(4, t.getKokonaissumma());
			tLisays.setInt(5, t.getTuoteID());

			tLisays.executeUpdate();

			System.out.println("Pizzan lisäys onnistui!");
		} catch (SQLException e) {
			// JOTAIN VIRHETT� TAPAHTUI
			try {
				throw new Exception("Tietokantahaku aiheutti virheen", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			if (currentCon != null) {
				try {
					currentCon.suljeYhteys();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
	}

	public void poistaTuote(int id) {
		try {

			String sql = "DELETE FROM Tilaus WHERE TuoteID = ?";
			PreparedStatement st = yhteys.prepareStatement(sql);

			st.setInt(1, id);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Tuote haeTuote(int id){
		Connection currentCon = Konnektori.getConnection();
		Tuote tuote = new Tuote();		
		try {
			
			String sql = "SELECT * FROM Tuote WHERE id = ?";
			PreparedStatement st = currentCon.prepareStatement(sql);
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				double hinta = rs.getDouble("hinta");
				String nimi = rs.getString("nimi");
				
				tuote.setHinta(hinta);
				tuote.setNimi(nimi);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return tuote;
	}
}
