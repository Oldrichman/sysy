package admin;



public class Juoma {

	private String juoma;
	private double hinta;
	
	public Juoma(){
		juoma = null;
		hinta = 0;
	}
	
	public Juoma (String juoma, double hinta){
		this.juoma= juoma;
		this.hinta= hinta;
	}

	public String getJuoma() {
		return juoma;
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

	

}
