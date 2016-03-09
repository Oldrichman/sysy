package password;



import java.util.Scanner;

public class SalasanaAdmin {

	private Scanner input;
	private Admin admin;

	public SalasanaAdmin() {
		input = new Scanner(System.in);
		admin = new Admin();
	}

	public void MuutaTunnus() {
		String nykyTunnus = admin.getKayttajatunnus();
		System.out.println(nykyTunnus);
		System.out.println("Anna vanha k‰ytt‰j‰tunnus: ");
		String vanhaTunnus = input.nextLine();

		if (nykyTunnus.equalsIgnoreCase(vanhaTunnus)) {
			System.out.println("Anna uusi k‰ytt‰j‰tunnus: ");
			String uusiTunnus = input.nextLine();
			System.out.println("Anna uusi k‰ytt‰j‰tunnus uudestaan: ");
			String toistoTunnus = input.nextLine();

			if (toistoTunnus.equalsIgnoreCase(uusiTunnus)) {
				admin.setKayttajatunnus(toistoTunnus);
			} else {
				System.out.println("Antamasi tiedot eiv‰t t‰sm‰‰");
			}

		} else {
			System.out.println("Virheellinen k‰ytt‰j‰tunnus");
		}
	}

	public void MuutaSalasana() {
		String nykySalasana = admin.getSalasana();
		System.out.println(nykySalasana);
		System.out.println("Anna vanha salasana: ");
		String vanhaSalasana = input.nextLine();

		if (nykySalasana.equals(vanhaSalasana)) {
			System.out.println("Anna uusi salasana: ");
			String uusiSalasana = input.nextLine();
			System.out.println("Anna uusi salasana uudestaan: ");
			String toistoSalasana = input.nextLine();

			if (toistoSalasana.equals(uusiSalasana)) {
				admin.setSalasana(toistoSalasana);
			} else {
				System.out.println("Salasanat eiv‰t t‰sm‰‰");
			}

		} else {
			System.out.println("V‰‰r‰ vanha salasana");
		}
	}

	public void aja() {
		int valinta = -1;
		do {
			System.out.println("1) Muuta k‰ytt‰j‰tunnusta");
			System.out.println("2) Muuta salasanaa");
			System.out.println("0) Lopeta");
			System.out.println("Valitse: ");
			valinta = input.nextInt();
			input.nextLine();
			switch (valinta) {
			case 1:
				MuutaTunnus();
				break;
			case 2:
				MuutaSalasana();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Virheellinen valinta, yrit‰ uudelleen");
				break;
			}
		} while (valinta != 0);
	}

	public static void main(String[] args) {
		SalasanaAdmin ohj = new SalasanaAdmin();
		ohj.aja();

	}

}
