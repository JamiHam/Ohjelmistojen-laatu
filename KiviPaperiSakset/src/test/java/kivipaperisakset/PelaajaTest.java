package kivipaperisakset;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PelaajaTest {
	Pelaaja pelaaja;
	
	@BeforeEach
	void setup() {
		pelaaja = new Pelaaja("Pelaaja");
	}

	@Test
	void teeValintaTest() {
		HashMap<String, Integer> vaihtoehdot = new HashMap<String, Integer>();
		vaihtoehdot.put("kivi", 0);
		vaihtoehdot.put("paperi", 0);
		vaihtoehdot.put("sakset", 0);
		
		for (int i = 0; i < 1000; i++) {
			pelaaja.teeValinta();
			String valinta = pelaaja.getValinta();
			vaihtoehdot.put(valinta, vaihtoehdot.get(valinta) + 1);
			
			assertTrue(vaihtoehdot.containsKey(valinta));
		}
		
		assertNotEquals(0, vaihtoehdot.get("kivi"), "Kiveä ei koskaan valittu.");
		assertNotEquals(0, vaihtoehdot.get("paperi"), "Paperia ei koskaan valittu.");
		assertNotEquals(0, vaihtoehdot.get("sakset"), "Saksia ei koskaan valittu.");
	}
	
	@Test
	void lisaaVoittoTest() {
		assertEquals(0, pelaaja.getVoitot(), "Voittojen alkuarvo on väärin.");
		
		pelaaja.lisaaVoitto();
		assertEquals(1, pelaaja.getVoitot(), "Voittojen määrä on väärin.");
		
		pelaaja.lisaaVoitto();
		assertEquals(2, pelaaja.getVoitot(), "Voittojen määrä on väärin.");
	}
}
