import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyFloat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mockesimerkki.*;

class TilaustenKäsittelyMockitoTest {

	@Mock
	IHinnoittelija hinnoittelijaMock;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testaaKäsittelijäKunHintaAlle100() {
		// Arrange
		float alkuSaldo = 100.0f;
		float listaHinta = 30.0f;
		float alennus = 20.0f;
		float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
		Asiakas asiakas = new Asiakas(alkuSaldo);
		Tuote tuote = new Tuote("TDD in Action", listaHinta);
		
		// Record
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
			.thenReturn(alennus);

		// Act
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
		käsittelijä.setHinnoittelija(hinnoittelijaMock);
		käsittelijä.käsittele(new Tilaus(asiakas, tuote));
		
		// Assert
		assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
		verify(hinnoittelijaMock, times(2)).getAlennusProsentti(asiakas, tuote);
		verify(hinnoittelijaMock, never()).setAlennusProsentti(any(Asiakas.class), anyFloat());
	}
	
	@Test
	public void testaaKäsittelijäKunHintaYli100() {
		// Arrange
		float alkuSaldo = 100.0f;
		float listaHinta = 120.0f;
		float alennus = 20.0f;
		float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
		Asiakas asiakas = new Asiakas(alkuSaldo);
		Tuote tuote = new Tuote("TDD in Action", listaHinta);
		
		// Record
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote))
			.thenReturn(alennus);
		
		// Act
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
		käsittelijä.setHinnoittelija(hinnoittelijaMock);
		käsittelijä.käsittele(new Tilaus(asiakas, tuote));
		
		// Assert
		assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
		verify(hinnoittelijaMock, times(2)).getAlennusProsentti(asiakas, tuote);
		verify(hinnoittelijaMock).setAlennusProsentti(asiakas, alennus + 5);
	}
}
