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
public class Jako extends Laskutoimitus{
    
    private KaytettyLaskutoimitus jako = KaytettyLaskutoimitus.JAKO;
    
    /**
 * Metodi laskee syotelukujen osamäärän
 *
 * @param   eka   Ensimmäinen luku
 * @param   toka  Toinen luku
 * 
 * @return lukujen osamäärä
 */
    @Override
    public Luku laske(Luku eka, Luku toka) {
        Luku uusi = new Luku(eka.getOsoittaja()*toka.getNimittaja(), eka.getNimittaja()*toka.getOsoittaja());
        uusi.setLaskutoimitus(jako);
        return uusi;
    }
    
           /**
 * Metodi antaa jakolaskun symbolin /
 *
 * @return symboli /
 */
    
    @Override
    public String toString() {
        return "/";
    }
    
}
