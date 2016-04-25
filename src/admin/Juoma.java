package admin;


/**
 * 
 * @author Joni Bärlund, SySy
 *
 */
public class Juoma {
	private int id;
	private String juoma;
	private double hinta;
	private String poisto;
	
	public Juoma(){
		id = 0;
		juoma = null;
		hinta = 0;
		poisto = null;
		
	}
	
	public Juoma (int id, String juoma, double hinta,String poisto){
		this.id= id;
		this.juoma= juoma;
		this.hinta= hinta;
		this.poisto= poisto;
		
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
