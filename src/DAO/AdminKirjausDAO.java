package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;






import admin.Konnektori;
import password.Admin;



public class AdminKirjausDAO {
	// Otettu muualta ohje ja tehty sen perusteella MH
	static Konnektori currentCon = null;
	static ResultSet rs = null;
	
	

	public static Admin login(Admin admin) { // preparing some objects for connection
		Admin kayttajatunnus;
		
		
		try { // connect to DB
			Connection currentCon = Konnektori.getConnection();
			PreparedStatement usernamehaku = currentCon.prepareStatement("SELECT suola, kayttajatunnus, salasana password_hash from Admin where kayttajatunnus = ?");
			usernamehaku.setString(1, admin.getKayttajatunnus());
			rs = usernamehaku.executeQuery();
			if (rs.next()) {
				kayttajatunnus = new Admin (rs.getString("kayttajatunnus"), rs.getString("suola"),
						rs.getString("password_hash"));
				admin.setValid(true);
			}
						
				else {
					// EI LÖYTYNYT
					// generoidaan kuitenkin tyhjä user, jotta 
					// login tarkistus kestää aina yhtä kauan
					admin.setValid(false);
					return null;
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
		
	return admin;
	}
}
