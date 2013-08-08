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
    
    @Override
    public Luku laske(Luku eka, Luku toka) {
        Luku uusi = new Luku(eka.getOsoittaja()*toka.getNimittaja(), eka.getNimittaja()*toka.getOsoittaja());
        return uusi;
    }
    
    @Override
    public String toString() {
        return "/";
    }
    
}
