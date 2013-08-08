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

    @Override
    public Luku laske(Luku eka, Luku toka) {
        Luku uusi = new Luku(eka.getOsoittaja()*toka.getOsoittaja(), eka.getNimittaja()*toka.getNimittaja());
        return uusi;
    }
    
    @Override
    public String toString() {
        return "*";
    }
}
