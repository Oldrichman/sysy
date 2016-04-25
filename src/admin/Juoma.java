package admin;



public class Juoma {
	private int id;
	private String juoma;
	private double hinta;
	private String poisto;
	
	public Juoma(){
		juoma = null;
		hinta = 0;
		poisto = null;
	}
	
	public Juoma (int id, String juoma, double hinta,String poisto){
		this.juoma= juoma;
		this.hinta= hinta;
		this.poisto= poisto;
		this.id= id;
	}

	public String getJuoma() {
		return juoma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setJuoma(String juoma) {
		this.juoma = juoma;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public String getPoisto() {
		return poisto;
	}

	public void setPoisto(String poisto) {
		this.poisto = poisto;
	}
	

}
