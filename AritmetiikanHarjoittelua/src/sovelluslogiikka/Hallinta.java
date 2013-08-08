/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import laskutoimitukset.*;
import java.util.Random;

/**
 *
 * @author O-P
 */
public class Hallinta {

    private int kokorajoitus;
    private boolean rationaalilukuja;
    private boolean negatiivisiaLukuja;
    private boolean ratkaisutNegatiivisia;
    private Random arpoja;
    private Luku eka;
    private Luku toka;
    private Luku tulos;
    private Luku syote;
    private Laskutoimitus laskutoimitus;
    private int oikeita;
    private int vaaria;

    public Hallinta(int koko, boolean q, boolean z, boolean negaratk) {
        kokorajoitus = koko;
        rationaalilukuja = q;
        negatiivisiaLukuja = z;
        ratkaisutNegatiivisia = negaratk;
        arpoja = new Random();
    }
    
    public int kokorajoitus() {
        return kokorajoitus;
    }
    
    public boolean rationaalilukuja() {
        return rationaalilukuja;
    }
    
    public boolean negatiivisiaLukuja() {
        return negatiivisiaLukuja;
    }
    
    public boolean ratkaisutNegatiivisia() {
        return ratkaisutNegatiivisia;
    }

    public String kysy() {
        eka = arvoLuku();
        toka = arvoLuku();
        laskutoimitus = arvoLaskutoimitus();
        tulos = laskutoimitus.laske(eka, toka);
        return kysymys();
    }
    
    public String kysymys() {
        return "" + eka + laskutoimitus + toka + " = ";
    }
    
    public boolean tarkista() {
        if (syote.equals(tulos)) {
            return true;
        }
        return false;
    }
    
    public void setSyote(int syote) {
        Luku uusi = new Luku(syote, 1);
        this.syote = uusi;
    }
    
    public String vaaraVastaus() {
        vaarin();
        return "Väärin! \n" + kysymys() + tulos;
    }
    
    public void vaarin() {
        vaaria++;
    }
    
    public void oikein() {
        oikeita++;
    }
    
    public Luku getEka() {
        return eka;
    }
    
    public Luku getToka() {
        return toka;
    }

    public Laskutoimitus arvoLaskutoimitus() {
        int laskutoimitus = arpoja.nextInt(4);
        if (laskutoimitus == 0) {
            Plus plus = new Plus();
            return plus;
        } else if (laskutoimitus == 1) {
            Miinus miinus = new Miinus();
            return miinus;
        } else if (laskutoimitus == 2) {
            Kerto kerto = new Kerto();
            return kerto;
        }
        Jako jako = new Jako();
        return jako;

    }

    public Luku arvoLuku() {
        if (!negatiivisiaLukuja) {
            return arvoLuonnollinenLuku();
        }
        if (!rationaalilukuja) {
            return arvoKokonaisluku();
        }
        return arvoMurtoluku();
    }

    public Luku arvoLuonnollinenLuku() {
        int yla = arpoja.nextInt(kokorajoitus + 1);
        Luku luku = new Luku(yla, 1);
        return luku;
    }

    public Luku arvoKokonaisluku() {
        int yla = arpoja.nextInt(kokorajoitus * 2 + 1) - kokorajoitus;
        Luku luku = new Luku(yla, 1);
        return luku;
    }

    public Luku arvoMurtoluku() {
        int yla = arpoja.nextInt(kokorajoitus * 2 + 1) - kokorajoitus;
        int ala = 0;
        while (ala == 0) {
            ala = arpoja.nextInt(kokorajoitus * 2 + 1) - kokorajoitus;
        }
        Luku luku = new Luku(yla, ala);
        return luku;
    }
    
    public String tilastot() {
        return "" + oikeita + " oikein, " + vaaria + " väärin";
    }
}
