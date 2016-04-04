package security;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class SalaajaTest {

	public static void main(String[] args) {
		Salaaja salaaja = new Salaaja();
		
		String suola = null;
		try {
			suola = salaaja.generoiSuola();
			System.out.println(suola);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String salasana = salaaja.salaa("testi", suola, "SHA-512", 100);
			System.out.println(salasana);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
