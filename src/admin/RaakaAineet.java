package admin;

public class RaakaAineet {

	private String nimi, poisto;
	
	
	

	public RaakaAineet(String nimi, String poisto) {
		this.nimi = nimi;
		this.poisto = poisto;

	}

	
	

	public String getPoisto() {
		return poisto;
	}




	public void setPoisto(String poisto) {
		this.poisto = poisto;
	}




	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	
	public RaakaAineet() {
		super();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "RaakaAineet [raakaAineet=" + nimi + "]";
	}
}
