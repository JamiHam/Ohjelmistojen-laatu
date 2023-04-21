package kivipaperisakset;



/**
 *
 * @author Ira Dook
 */
public class Pelaaja {
	
	private String nimi;
    private int voitot;
    private String valinta;
    
    public Pelaaja(String nimi) {
    	this.nimi = nimi;
    	voitot = 0;
    	valinta = "";
    }

    /**
     * Aseta valinta-muuttujaan satunnaisesti "kivi", "paperi" tai "sakset".
     */
    public void teeValinta() {
    	int satunnaisluku = (int) (Math.random() * 3);
        switch (satunnaisluku) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
    }
    
    /**
     * Kasvata voitot-muuttujaa yhdellä.
     */
    public void lisaaVoitto() {
        voitot++;
    }
    
    public String getValinta() {
    	return valinta;
    }

    public int getVoitot() {
        return voitot;
    }
    
    public String getNimi() {
    	return nimi;
    }
}
