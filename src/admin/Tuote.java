package admin;


public class Tuote {
	
	private int id;
	private String nimi;
	String taytteet;
	private double hinta;
	private String poisto;
	
	public Tuote() {
		id = 0;
		nimi = null;
		hinta = 0;
		taytteet = null;
		poisto = null;
		
	}
	
	public Tuote(int id, String nimi, double hinta, String taytteet, String poisto) {
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.taytteet = taytteet;
		this.poisto= poisto;
	}
	
	
	public int getId() {
		return id;
	}

	public String getPoisto() {
		return poisto;
	}

	public void setPoisto(String poisto) {
		this.poisto = poisto;
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

	public String getTaytteet() {
		return taytteet;
	}

	public void setTaytteet(String string) {
		this.taytteet = string;
	}

	@Override
	public String toString() {
		return "Tuote [id=" + id + ", nimi=" + nimi + ", taytteet=" + taytteet
				+ ", hinta=" + hinta + ", poisto=" + poisto + "]";
	}

	
	
}