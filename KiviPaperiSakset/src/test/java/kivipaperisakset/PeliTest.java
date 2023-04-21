package kivipaperisakset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PeliTest {

	@Mock
	Pelaaja pelaaja1;
	
	@Mock
	Pelaaja pelaaja2;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void tarkistaVoittajaTest() {
		Peli peli = new Peli(pelaaja1, pelaaja2);
		
		when(pelaaja1.getValinta())
			.thenReturn("kivi");
		when(pelaaja2.getValinta())
			.thenReturn("kivi");
		peli.tarkistaVoittaja();
		assertNull(peli.getVoittaja());
		
		when(pelaaja1.getValinta())
			.thenReturn("kivi");
		when(pelaaja2.getValinta())
			.thenReturn("paperi");
		peli.tarkistaVoittaja();
		assertEquals(peli.getVoittaja(), pelaaja2);
		
		when(pelaaja1.getValinta())
		.thenReturn("kivi");
		when(pelaaja2.getValinta())
			.thenReturn("sakset");
		peli.tarkistaVoittaja();
		assertEquals(peli.getVoittaja(), pelaaja1);
		
		when(pelaaja1.getValinta())
			.thenReturn("paperi");
		when(pelaaja2.getValinta())
			.thenReturn("kivi");
		peli.tarkistaVoittaja();
		assertEquals(peli.getVoittaja(), pelaaja1);
		
		when(pelaaja1.getValinta())
			.thenReturn("paperi");
		when(pelaaja2.getValinta())
			.thenReturn("paperi");
		peli.tarkistaVoittaja();
		assertNull(peli.getVoittaja());
		
		when(pelaaja1.getValinta())
			.thenReturn("paperi");
		when(pelaaja2.getValinta())
			.thenReturn("sakset");
		peli.tarkistaVoittaja();
		assertEquals(peli.getVoittaja(), pelaaja2);
		
		when(pelaaja1.getValinta())
			.thenReturn("sakset");
		when(pelaaja2.getValinta())
			.thenReturn("kivi");
		peli.tarkistaVoittaja();
		assertEquals(peli.getVoittaja(), pelaaja2);
		
		when(pelaaja1.getValinta())
			.thenReturn("sakset");
		when(pelaaja2.getValinta())
			.thenReturn("paperi");
		peli.tarkistaVoittaja();
		assertEquals(peli.getVoittaja(), pelaaja1);
		
		when(pelaaja1.getValinta())
			.thenReturn("sakset");
		when(pelaaja2.getValinta())
			.thenReturn("sakset");
		peli.tarkistaVoittaja();
		assertNull(peli.getVoittaja());
	}
	
	@Test
	void tallennaTulosTest() {
		Peli peli = new Peli(pelaaja1, pelaaja2);
		
		peli.setVoittaja(null);
		peli.tallennaTulos();
		assertEquals(1, peli.getTasapelit(), "Tasapelien määrä on väärin.");
		
		peli.setVoittaja(pelaaja1);
		peli.tallennaTulos();
		verify(pelaaja1).lisaaVoitto();
		
		peli.setVoittaja(pelaaja2);
		peli.tallennaTulos();
		verify(pelaaja2).lisaaVoitto();
	}
}
