package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konnektori {
	static Connection con;
	static String url;
	// Tämä on yleinen konnektori Protoon MH
	// Tän avulla ei tarvii Daossa aina avata erikseen yhteyttä MH

	public static Connection getConnection() {
		try {
			String url = "jdbc:mariadb://localhost/a1500948"; 
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, "a1500948", "cuZA2s32m"); 
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}

	public void suljeYhteys() {
		try {
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}
