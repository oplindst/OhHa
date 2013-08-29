package kayttoliittyma;

import javax.swing.*;


import sovelluslogiikka.Hallinta;
import kayttoliittyma.valikot.Asetusvalikko;
import kayttoliittyma.valikot.Kysymysvalikko;
import kayttoliittyma.valikot.Paavalikko;
import kayttoliittyma.valikot.Valikko;
import kayttoliittyma.valikot.ValikkoTyyppi;

/**
 *
 * @author O-P
 */
public class KayttoLiittyma implements Runnable {

    private static JFrame frame;
    private static Valikko valikko;

    public KayttoLiittyma() {
        frame = new JFrame("Aritmetiikan Harjoittelua");
    }

    @Override
    public void run() {
        teePaavalikko();
    }
    
    public static void teePaavalikko() {
        
        valikko = new Paavalikko();
    }
    
    public static void teeKysymysvalikko(Hallinta hallinta, ValikkoTyyppi tyyppi, JComponent... komponentit) {
        
        valikko = new Kysymysvalikko(hallinta, tyyppi, komponentit);
        
    }
    
    public static void teeAsetusvalikko() {
        valikko = new Asetusvalikko();
    }

    public JFrame getFrame() {
        return frame;
    }
}
