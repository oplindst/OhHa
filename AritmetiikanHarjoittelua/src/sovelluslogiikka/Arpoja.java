/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.Random;
import laskutoimitukset.Jako;
import laskutoimitukset.Kerto;
import laskutoimitukset.Laskutoimitus;
import laskutoimitukset.Miinus;
import laskutoimitukset.Plus;

/**
 *
 * @author O-P
 */
public class Arpoja {
    
    private Random arpoja;
    
    public Arpoja() {
        arpoja = new Random();
    }
    
    public Laskutoimitus arvoLaskutoimitus(String laskutoimitukset) {
        int laskutoimitus = arpoja.nextInt(4);
        if (laskutoimitus == 0 && laskutoimitukset.contains("+")) {
            Plus plus = new Plus();
            return plus;
        } else if (laskutoimitus == 1 && laskutoimitukset.contains("-")) {
            Miinus miinus = new Miinus();
            return miinus;
        } else if (laskutoimitus == 2 && laskutoimitukset.contains("*")) {
            Kerto kerto = new Kerto();
            return kerto;
        } else if (laskutoimitus == 3 && laskutoimitukset.contains("/")) {
            Jako jako = new Jako();
            return jako;
        }
        return arvoLaskutoimitus(laskutoimitukset);

    }

    public Luku arvoLuku(boolean nega, boolean rationaali, int koko) {
        if (!nega & !rationaali) {
            return arvoLuonnollinenLuku(koko);
        }
        if (!rationaali) {
            return arvoKokonaisluku(koko);
        }
        if (!nega) {
            return arvoMurtoluku(true, koko);
        }
        return arvoMurtoluku(false, koko);
    }

    public Luku arvoLuonnollinenLuku(int koko) {
        int yla = arvoLuonnollinenInt(koko);
        Luku luku = new Luku(yla, 1);
        return luku;
    }

    public Luku arvoKokonaisluku(int koko) {
        int yla = arvoKokonaisInt(koko);
        Luku luku = new Luku(yla, 1);
        return luku;
    }

    public int arvoLuonnollinenInt(int koko) {
        return arpoja.nextInt(koko + 1);
    }

    public int arvoKokonaisInt(int koko) {
        return arpoja.nextInt(koko * 2 + 1) - koko;
    }

    public Luku arvoMurtoluku(boolean positiivinen, int koko) {
        int yla;
        int ala;
        if (positiivinen) {
            yla = arvoLuonnollinenInt(koko);
            ala = arvoLuonnollinenInt(koko);
        } else {
            yla = arvoKokonaisInt(koko);
            ala = arvoKokonaisInt(koko);
        }
        Luku luku = new Luku(yla, ala);
        return luku;
    }
}
