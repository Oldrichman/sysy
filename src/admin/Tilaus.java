package admin;

import java.sql.Date;
import java.util.List;

public class Tilaus {
	
	private int tilausnumero, maara, tuoteID;
	private String asiakastunnus, toimitustapa;
	private Date toimitusaika;
	private double kokonaissumma;
	List<Tilaus> lista = null;

	public Tilaus(){
		tilausnumero = 0;
		maara= 0;
		tuoteID = 0;
		asiakastunnus = null;
		toimitustapa = null;
		kokonaissumma = 0.00;
		List<Tilaus> lista = null;
	}
	
	public Tilaus(int Tilausnumero, String Asiakastunnus, int Maara, double Kokonaissumma, int TuoteID, String Toimitustapa){
		this.tilausnumero = Tilausnumero;
		this.maara= Maara;
		this.tuoteID = TuoteID;
		this.asiakastunnus = Asiakastunnus;
		this.toimitustapa = Toimitustapa;
		this.kokonaissumma = Kokonaissumma;
	}

	public int getTilausnumero() {
		return tilausnumero;
	}

	public void setTilausnumero(int tilausnumero) {
		this.tilausnumero = tilausnumero;
	}

	public int getMaara() {
		return maara;
	}

	public void setMaara(int maara) {
		this.maara = maara;
	}

	public int getTuoteID() {
		return tuoteID;
	}

	public void setTuoteID(int tuoteID) {
		this.tuoteID = tuoteID;
	}

	public String getAsiakastunnus() {
		return asiakastunnus;
	}

	public void setAsiakastunnus(String asiakastunnus) {
		this.asiakastunnus = asiakastunnus;
	}

	public String getToimitustapa() {
		return toimitustapa;
	}

	public void setToimitustapa(String toimitustapa) {
		this.toimitustapa = toimitustapa;
	}

	public Date getToimitusaika() {
		return toimitusaika;
	}

	public void setToimitusaika(Date toimitusaika) {
		this.toimitusaika = toimitusaika;
	}

	public double getKokonaissumma() {
		return kokonaissumma;
	}

	public void setKokonaissumma(double kokonaissumma) {
		this.kokonaissumma = kokonaissumma;
	}

	@Override
	public String toString() {
		return "Tilaus [tilausnumero=" + tilausnumero + ", maara=" + maara
				+ ", tuoteID=" + tuoteID + ", asiakastunnus=" + asiakastunnus
				+ ", toimitustapa=" + toimitustapa + ", toimitusaika="
				+ toimitusaika + ", kokonaissumma=" + kokonaissumma + "]";
	}
	
	
}
