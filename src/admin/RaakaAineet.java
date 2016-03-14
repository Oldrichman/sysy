package admin;

public class RaakaAineet {

	String nimi;
	
	

	public RaakaAineet(String nimi) {
		this.nimi = nimi;
		

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
