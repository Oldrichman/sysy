package password;

public class Admin {
	private String suola;
	private String kayttajatunnus;
	private String salasana;
	public boolean valid;
	
	public Admin(String suola, String kayttajatunnus, String salasana) {
		this.suola = suola;
		this.kayttajatunnus = kayttajatunnus;
		this.salasana = salasana;
	}


	public Admin() {
		// TODO Auto-generated constructor stub
	}


	public String getKayttajatunnus() {
		return kayttajatunnus;
	}

	public void setKayttajatunnus(String kayttajatunnus) {
		this.kayttajatunnus = kayttajatunnus;
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
