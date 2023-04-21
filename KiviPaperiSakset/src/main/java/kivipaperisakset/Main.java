package kivipaperisakset;

public class Main {

	public static void main(String[] args) {
		Pelaaja pelaaja1 = new Pelaaja("Pelaaja 1");
		Pelaaja pelaaja2 = new Pelaaja("Pelaaja 2");
		Peli peli = new Peli(pelaaja1, pelaaja2);
		
		peli.kaynnistaPeli();
	}
}
