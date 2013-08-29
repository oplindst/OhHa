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
public class Miinus extends Laskutoimitus{

    private KaytettyLaskutoimitus miinus = KaytettyLaskutoimitus.MIINUS;
    
    /**
 * Metodi laskee syotelukujen erotuksen
 *
 * @param   eka   Ensimmäinen luku
 * @param   toka  Toinen luku
 * 
 * @return lukujen erotus
 */
    @Override
    public Luku laske(Luku eka, Luku toka) {
        Luku uusi = new Luku(eka.getOsoittaja()*toka.getNimittaja() - toka.getOsoittaja()*eka.getNimittaja(), eka.getNimittaja()*toka.getNimittaja());
        uusi.setLaskutoimitus(miinus);
        return uusi;
    }
    
           /**
 * Metodi antaa miinus-laskun symbolin -
 *
 * @return symboli -
 */
    
    @Override
    public String toString() {
        return "-";
    }
}
