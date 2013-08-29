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
public abstract class Laskutoimitus {
    
    /**
 * Metodi antaa syotelukujen tuloksen laskutoimituksesta riippuen
 *
 * @param   eka   Ensimmäinen luku
 * @param   toka  Toinen luku
 * 
 * @return lukujen ja laskutoimituken antama tulos
 */
    public abstract Luku laske(Luku eka, Luku toka);
}
