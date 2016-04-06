package password;

import java.util.ArrayList;

public class Kayttaja {
	
	private String suola;
	private String email;
	private String salasana, etunimi, sukunimi, osoite, postinro;
	public boolean valid;
	
	public Kayttaja() {
		etunimi = null;
		sukunimi = null;
		email = null;
		osoite = null;
		postinro = null;
	}

	
	public Kayttaja(String suola, String email, String salasana) {
		this.suola = suola;
		this.email = email;
		this.salasana = salasana;
	}
	
	


	public String getEmail() {
		return email;
	}

	public String getEtunimi() {
		return etunimi;
	}


	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}


	public String getSukunimi() {
		return sukunimi;
	}


	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}


	public String getOsoite() {
		return osoite;
	}


	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}


	public String getPostinro() {
		return postinro;
	}


	public void setPostinro(String postinro) {
		this.postinro = postinro;
	}


	@Override
	public String toString() {
		return "Kayttaja [suola=" + suola + ", email=" + email + ", salasana="
				+ salasana + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", osoite=" + osoite + ", postinro=" + postinro + ", valid="
				+ valid + ", getEmail()=" + getEmail() + ", getSalasana()="
				+ getSalasana() + ", isValid()=" + isValid() + ", getSuola()="
				+ getSuola() + "]";
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


	public void add(ArrayList<Kayttaja> tietoja) {
		// TODO Auto-generated method stub
		
	}

}
