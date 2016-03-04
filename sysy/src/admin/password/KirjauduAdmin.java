package admin.password;

import java.util.Scanner;

public class KirjauduAdmin {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();

		String kayttajatunnus = admin.getKayttajatunnus();
		String salasana = admin.getSalasana();
		System.out.println(kayttajatunnus + " " + salasana);
		System.out.println("Anna käyttäjätunnus: ");
		String tunnus = input.nextLine();
		if (tunnus.equalsIgnoreCase(kayttajatunnus)) {
			System.out.println("Anna Salasana: ");
			String annettu = input.nextLine();

			if (annettu.equals(salasana)) {
				System.out.println("Tervetuloa " + kayttajatunnus);
			} else {
				System.out.println("Väärä salasana");
			}

		} else {
			System.out.println("Väärä käyttäjätunnus");
		}
	}
}
