package admin.bean;

public class Tuote {
	
	private int id;
	private String nimi;
	private double hinta;
	
	public Tuote() {
		id = 0;
		nimi = null;
		hinta = 0;
	}
	
	public Tuote(int id, String nimi, double hinta) {
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	
}
