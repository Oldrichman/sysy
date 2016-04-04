package password;

public class Kayttaja {
	private String suola;
	private String email;
	private String salasana;
	public boolean valid;
	
	public Kayttaja(String suola, String email, String salasana) {
		this.suola = suola;
		this.email = email;
		this.salasana = salasana;
	}


	public Kayttaja() {
		// TODO Auto-generated constructor stub
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	
	// Tarkistetaan onko tiedot oikein
	public boolean isValid() {
		return valid;
	}
	
	public void setValid(boolean newValid) {
		this.valid = newValid;
	}


	public String getSuola() {
		return suola;
	}


	public void setSuola(String suola) {
		this.suola = suola;
	}

}
