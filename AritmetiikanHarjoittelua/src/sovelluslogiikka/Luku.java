/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import laskutoimitukset.KaytettyLaskutoimitus;
import laskutoimitukset.Kerto;
import laskutoimitukset.Laskutoimitus;
import laskutoimitukset.Miinus;
import laskutoimitukset.Plus;

/**
 * Ohjelma pitää jokaisesta luvusta kirjaa muodossa osoittaja/nimittäjä. Jos
 * luku on kokonaisluku, nimittäjäksi asetetaan 1.
 *
 *
 */
public class Luku {

    private int osoittaja;
    private int nimittaja;
    private KaytettyLaskutoimitus laskutoimitus;

    public Luku(int yla, int ala) {
        osoittaja = yla;
        nimittaja = ala;
    }

    public void setLaskutoimitus(KaytettyLaskutoimitus laskutoim) {
        laskutoimitus = laskutoim;
    }

    public KaytettyLaskutoimitus getLaskutoimitus() {
        return laskutoimitus;
    }

    /**
     * Metodi antaa luvun esityksen tekstinä
     *
     * @return luvun tekstiesitys
     */
    @Override
    public String toString() {
        if (!maaritelty()) {
            return "ei määritelty";
        }
        if (nolla()) {
            return "0";
        }
        if (!murtoluku()) {

            return "" + osoittaja / nimittaja;
        }
        return "" + osoittaja + "/" + nimittaja;
    }

    /**
     * Metodi kertoo, onko luku nolla vai ei
     *
     * @return true, jos luku on nolla, muuten false
     */
    public boolean nolla() {
        if (osoittaja == 0) {
            return true;
        }
        return false;
    }

    /**
     * Metodi kertoo, jos lukua ei ole määritelty, eli yritetään jakaa nollalla.
     *
     * @return true, jos on määritelty, muuten false
     */
    public boolean maaritelty() {
        if (nimittaja == 0) {
            return false;
        }
        return true;
    }

    /**
     * Metodi kertoo, onko luku murtoluku, vai kokonaisluku
     *
     * @return true, jos luku on murtoluku, muuten false
     */
    public boolean murtoluku() {
        if (!maaritelty()) {
            return false;
        }
        if (osoittaja % nimittaja == 0) {
            return false;
        }
        return true;
    }

    /**
     * Metodi kertoo, onko luku negatiivinen
     *
     * @return true, jos luku on negatiivinen, muuten false
     */
    public boolean negatiivinen() {
        if (osoittaja * nimittaja < 0) {
            return true;
        }
        return false;
    }

    public int getOsoittaja() {
        return osoittaja;
    }

    public int getNimittaja() {
        return nimittaja;
    }

    /**
     * Metodi kertoo, ovatko kaksi lukua samat
     *
     * @return true, jos luvut ovat samat, muuten false
     */
    public boolean equals(Luku luku) {
        sievenna();
        luku.sievenna();
        if ((this.osoittaja == luku.osoittaja && this.nimittaja == luku.nimittaja) || (-this.osoittaja == luku.osoittaja && -this.nimittaja == luku.nimittaja)) {
            return true;
        }
        return false;
    }

    /**
     * Metodi sieventää murtoluvun
     *
     *
     */
    public void sievenna() {
        if (maaritelty()) {
            if (!murtoluku()) {
                osoittaja = osoittaja / nimittaja;
                nimittaja = 1;
            }
            if (osoittaja < 0 && nimittaja < 0) {
                osoittaja = osoittaja * -1;
                nimittaja = nimittaja * -1;
            } else {
                if (osoittaja > 0) {
                    for (int k = osoittaja; k >= 2; k--) {
                        jaa(k);
                    }
                } else {
                    for (int k = osoittaja; k <= -2; k++) {
                        jaa(k);
                    }
                }
            }
        }
    }

    /**
     * Metodi jakaa osoittajan ja nimittäjän syöteluvulla, jos molemmat ovat
     * jaollisia sillä.
     *
     * @param k luku, jolla jaetaan
     */
    private void jaa(int k) {
        if (osoittaja % k == 0 && nimittaja % k == 0) {
            osoittaja = osoittaja / k;
            nimittaja = nimittaja / k;
        }
    }
}
