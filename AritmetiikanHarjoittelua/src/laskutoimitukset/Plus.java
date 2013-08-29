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
public class Plus extends Laskutoimitus{

    private KaytettyLaskutoimitus plus = KaytettyLaskutoimitus.PLUS;
    
        /**
 * Metodi laskee syotelukujen summan
 *
 * @param   eka   Ensimmäinen luku
 * @param   toka  Toinen luku
 * 
 * @return lukujen summa
 */
    @Override
    public Luku laske(Luku eka, Luku toka) {
        Luku uusi = new Luku(eka.getOsoittaja()*toka.getNimittaja() + toka.getOsoittaja()*eka.getNimittaja(), eka.getNimittaja()*toka.getNimittaja());
        uusi.setLaskutoimitus(plus);
        return uusi;
    }
    
        /**
 * Metodi antaa plus-laskun symbolin +
 *
 * @return symboli +
 */
    
    @Override
    public String toString() {
        return "+";
    }
}
