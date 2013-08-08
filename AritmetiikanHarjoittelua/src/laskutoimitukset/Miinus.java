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

    @Override
    public Luku laske(Luku eka, Luku toka) {
        Luku uusi = new Luku(eka.getOsoittaja()*toka.getNimittaja() - toka.getOsoittaja()*eka.getNimittaja(), eka.getNimittaja()*toka.getNimittaja());
        return uusi;
    }
    
    @Override
    public String toString() {
        return "-";
    }
}
