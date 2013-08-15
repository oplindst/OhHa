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
        if (nimittaja==0) {
            return "ei määritelty";
        }
        if (osoittaja == 0) {
            return "0";
        }
        if (osoittaja%nimittaja==0) {
            if (negatiivinen()) {
                return "(" + osoittaja/nimittaja + ")";
            }
            return "" + osoittaja/nimittaja;
        }
        return "("+osoittaja + "/" + nimittaja+")";
    }
    
    public boolean negatiivinen() {
        if (osoittaja*nimittaja < 0) {
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
        if (this.toString().equals(luku.toString())) {
            return true;
        }
        return false;
    }
}
