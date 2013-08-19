/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author O-P
 */
public class Luku {

    private int osoittaja;
    private int nimittaja;

    public Luku(int yla, int ala) {
        osoittaja = yla;
        nimittaja = ala;
    }

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

    public boolean nolla() {
        if (osoittaja == 0) {
            return true;
        }
        return false;
    }

    public boolean maaritelty() {
        if (nimittaja == 0) {
            return false;
        }
        return true;
    }

    public boolean murtoluku() {
        if (!maaritelty()) {
            return false;
        }
        if (osoittaja % nimittaja == 0) {
            return false;
        }
        return true;
    }

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

    public boolean equals(Luku luku) {
        sievenna();
        luku.sievenna();
        if (this.toString().equals(luku.toString())) {
            return true;
        }
        return false;
    }

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

    private void jaa(int k) {
        if (osoittaja % k == 0 && nimittaja % k == 0) {
            osoittaja = osoittaja / k;
            nimittaja = nimittaja / k;
        }
    }
}
