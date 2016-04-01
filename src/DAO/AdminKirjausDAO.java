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
import password.Admin;
import security.Salaaja;

public class AdminKirjausDAO {
	// Otettu muualta ohje ja tehty sen perusteella MH
	static Konnektori currentCon = null;
	static ResultSet rs = null;

	public static Admin login(Admin admin) { // preparing some objects for
												// connection
		Admin kayttajatunnus;

		try { // connect to DB
			Connection currentCon = Konnektori.getConnection();
			PreparedStatement usernamehaku = currentCon
					.prepareStatement("SELECT suola, kayttajatunnus, salasana from Admin where kayttajatunnus = ?");
			usernamehaku.setString(1, admin.getKayttajatunnus());
			rs = usernamehaku.executeQuery();
			if (rs.next()) {
				String suola = rs.getString("suola");
				String salasana = rs.getString("salasana");
				Salaaja salaaja = new Salaaja();
				String salattuTeksti = null; 
				
				try {
					 salattuTeksti = salaaja.salaa(admin.getSalasana(), suola, "SHA-512", 100);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			
				if (salattuTeksti.equals(rs.getString("salasana"))) {
					admin.setValid(true);
				}

			}

			else {
				// EI L�YTYNYT
				// generoidaan kuitenkin tyhj� user, jotta
				// login tarkistus kest�� aina yht� kauan
				admin.setValid(false);
				return admin;
			}
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

		return admin;
	}
}
