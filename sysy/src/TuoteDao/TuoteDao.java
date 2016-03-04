package TuoteDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.bean.Tuote;

public class TuoteDao {

	private Connection yhteys = null;
	
	public void avaaYhteys() {
		// TIETOKANTAHAKU
	
		String username = "";
		String password = "";
		String url = "";
		
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
		e.printStackTrace();
		}
	}	
				// suljetaan yhteys
	public void suljeYhteys() {
		try {
			yhteys.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
