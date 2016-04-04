package DAO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import admin.Konnektori;
import password.Kayttaja;
import security.Salaaja;

public class KayttajaKirjausDAO {
	// Otettu Mikolta ohje ja tehty sen perusteella OH
	static Konnektori currentCon = null;
	static ResultSet rs = null;

	public static Kayttaja login(Kayttaja kayttaja) { // preparing some objects for
												// connection
		Kayttaja email;

		try { // connect to DB
			Connection currentCon = Konnektori.getConnection();
			PreparedStatement usernamehaku = currentCon
					.prepareStatement("SELECT suola, email, salasana from Asiakas where email = ?");
			usernamehaku.setString(1, kayttaja.getEmail());
			rs = usernamehaku.executeQuery();
			if (rs.next()) {
				String suola = rs.getString("suola");
				String salasana = rs.getString("salasana");
				Salaaja salaaja = new Salaaja();
				String salattuTeksti = null; 
				
				try {
					 salattuTeksti = salaaja.salaa(kayttaja.getSalasana(), suola, "SHA-512", 100);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			
				if (salattuTeksti.equals(rs.getString("salasana"))) {
					kayttaja.setValid(true);
				}

			}

			else {
				// EI LÖYTYNYT
				// generoidaan kuitenkin tyhjä user, jotta
				// login tarkistus kestää aina yhtä kauan
				kayttaja.setValid(false);
				return kayttaja;
			}
		} catch (SQLException e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
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

		return kayttaja;
	}
}
