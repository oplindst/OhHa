/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author O-P
 */
public class Kirjanpitaja {
    
    private int oikeat;
    private int vaarat;
    
    public Kirjanpitaja() {
        oikeat = 0;
        vaarat = 0;
    }
    
    public void oikein() {
        oikeat++;
    }
    
    public void vaarin() {
        vaarat++;
    }
    
    public int getOikeat() {
        return oikeat;
    }
    
    public int getVaarat() {
        return vaarat;
    }
    
    @Override
    public String toString() {
        return oikeat + " oikein, " + vaarat + " väärin";
    }
    
    public void alusta() {
        oikeat = 0;
        vaarat = 0;
    }
}
