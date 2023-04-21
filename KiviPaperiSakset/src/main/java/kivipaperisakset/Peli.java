package kivipaperisakset;
/**
 *
 * @author Ira Dook
 */
public class Peli {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja voittaja;
    private int pelatutPelit = 0;           // Pelattujen pelien lkm
    private int tasapelit = 0;              // Tasapelien lkm
    
    public Peli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
    	this.pelaaja1 = pelaaja1;
    	this.pelaaja2 = pelaaja2;
    }
   
    /**
     * Käynnistä automaattinen "kivi, paperi, sakset"-peli.
     */
    public void kaynnistaPeli() {
    	while ((pelaaja1.getVoitot() < 3) && (pelaaja2.getVoitot() < 3)) {
    		pelaaja1.teeValinta();
    		pelaaja2.teeValinta();
    		
    		tulostaPelitilanne();
    		
    		tarkistaVoittaja();
    		
    		tulostaVoittaja();
    		
    		tallennaTulos();
            
            pelatutPelit++;
        }
    	
    	System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
    }
    
    /**
     * Tulosta eränumero, tasapelien määrä ja molempien pelaajien voitot sekä viimeisin valinta.
     */
    private void tulostaPelitilanne() {
    	System.out.println("Erä: "
                + (pelatutPelit + 1) + " =====================\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
        System.out.println("Pelaaja 1: " + pelaaja1.getValinta()
                + "\n\t Pelaaja 1:llä koossa " + pelaaja1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + pelaaja2.getValinta()
                + "\n\t Pelaaja 2:lla koossa " + pelaaja2.getVoitot() + " voittoa.\n");
	}
    
    /**
     * Tarkista kumpi pelaaja voitti, ja aseta se voittaja-muuttujaan.
     */
    public void tarkistaVoittaja() {
    	if ((pelaaja1.getValinta().equals("kivi")) && (pelaaja2.getValinta().equals("paperi"))) {
            voittaja = pelaaja2;
        } else if ((pelaaja1.getValinta().equals("paperi")) && (pelaaja2.getValinta().equals("kivi"))) {
        	voittaja = pelaaja1;
        } else if ((pelaaja1.getValinta().equals("kivi")) && (pelaaja2.getValinta().equals("sakset"))) {
        	voittaja = pelaaja1;
        } else if ((pelaaja1.getValinta().equals("sakset")) && (pelaaja2.getValinta().equals("kivi"))) {
        	voittaja = pelaaja2;
        } else if ((pelaaja1.getValinta().equals("sakset")) && (pelaaja2.getValinta().equals("paperi"))) {
        	voittaja = pelaaja1;
        } else if ((pelaaja1.getValinta().equals("paperi")) && (pelaaja2.getValinta().equals("sakset"))) {
        	voittaja = pelaaja2;
        }
        if (pelaaja1.getValinta() == pelaaja2.getValinta()) {
            voittaja = null;
        }
    }
    
    /*
     * Tulosta voittajan nimi.
     */
    private void tulostaVoittaja() {
    	if (voittaja != null) {
			System.out.println(voittaja.getNimi() + " voittaa.\n");
		} else {
			System.out.println("Tasapeli.\n");
		}
    }
    
    /**
     * Kasvata voittajan voitot-muuttujaa tai tasapelit-muuttujaa.
     */
    public void tallennaTulos() {
    	if (voittaja != null) {
        	voittaja.lisaaVoitto();
        } else {
        	tasapelit++;
        }
    }
    
    public Pelaaja getVoittaja() {
    	return voittaja;
    }
    
    public void setVoittaja(Pelaaja voittaja) {
    	this.voittaja = voittaja;
    }
    
    public int getTasapelit() {
    	return tasapelit;
    }
}
