package password;

public class Admin {
	
	private String kayttajatunnus;
	private String salasana;
	public boolean valid;
	
	public Admin() {
		this.kayttajatunnus = "admin";
		this.salasana = "admin";
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

}
