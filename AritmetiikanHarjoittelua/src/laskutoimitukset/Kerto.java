/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutoimitukset;

import sovelluslogiikka.Luku;

/**
 *
 * @author O-P
 */
public class Kerto extends Laskutoimitus{

    private KaytettyLaskutoimitus kerto = KaytettyLaskutoimitus.KERTO;
    
    /**
 * Metodi laskee syotelukujen tulon
 *
 * @param   eka   Ensimmäinen luku
 * @param   toka  Toinen luku
 * 
 * @return lukujen tulo
 */
    @Override
    public Luku laske(Luku eka, Luku toka) {
        Luku uusi = new Luku(eka.getOsoittaja()*toka.getOsoittaja(), eka.getNimittaja()*toka.getNimittaja());
        uusi.setLaskutoimitus(kerto);
        return uusi;
    }
    
           /**
 * Metodi antaa kertolaskun symbolin *
 *
 * @return symboli *
 */
    
    @Override
    public String toString() {
        return "*";
    }
}
