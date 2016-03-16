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
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static Admin login(Admin admin) { // preparing some objects for connection
		Statement stmt = null;
		String kayttajatunnus = admin.getKayttajatunnus();
		String salasana = admin.getSalasana();
		String haku = "select * from users where kayttajatunnus='" + kayttajatunnus
				+ "' AND salasana='" + salasana + "'";
		System.out.println("Your user name is " + kayttajatunnus);
		System.out.println("Your salasana is " + salasana);
		System.out.println("Query: " + haku);
		try { // connect to DB
			currentCon = Konnektori.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(haku);
			boolean more = rs.next(); // if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				admin.setValid(false);
			} // if user exists set the isValid variable to true else
			if (more) {
				System.out.println("Welcome " + kayttajatunnus);
				admin.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} // some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {

				}
				currentCon = null;
			}
		}
		return admin;
	}

}
