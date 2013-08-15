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
    private Luku tulos;
    private int oikeita;
    private int vaaria;
    private String laskutoimitukset;

    public Hallinta(int koko, boolean q, boolean z, boolean negaratk, String laskutoimitukset) {
        arpoja = new Random();
        kokorajoitus = koko;
        rationaalilukuja = q;
        negatiivisiaLukuja = z;
        ratkaisutNegatiivisia = negaratk;
        this.laskutoimitukset = laskutoimitukset;
    }

    public void asetukset(int koko, boolean q, boolean z, boolean negaratk, String laskutoim) {
        kokorajoitus = koko;
        rationaalilukuja = q;
        negatiivisiaLukuja = z;
        ratkaisutNegatiivisia = negaratk;
        laskutoimitukset = laskutoim;
    }

    private void alusta() {
        oikeita = 0;
        vaaria = 0;
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
        Luku eka = arvoLuku();
        Luku toka = arvoLuku();
        Laskutoimitus laskutoimitus = arvoLaskutoimitus();
        tulos = laskutoimitus.laske(eka, toka);
        if (!ratkaisutNegatiivisia && tulos.negatiivinen()) {
            return kysy();
        }
        return kysymys(eka, toka, laskutoimitus);
    }

    public String kysymys(Luku eka, Luku toka, Laskutoimitus laskutoimitus) {
        return "" + eka + laskutoimitus + toka + " = ";
    }

    public boolean tarkista(int syote) {
        Luku luku = new Luku(syote, 1);
        if (luku.equals(tulos)) {
            oikein();
            return true;
        }
        vaarin();
        return false;
    }

    public Luku getTulos() {
        return tulos;
    }

    public void vaarin() {
        vaaria++;
    }

    public void oikein() {
        oikeita++;
    }

    public Laskutoimitus arvoLaskutoimitus() {
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
        return arvoLaskutoimitus();

    }

    public Luku arvoLuku() {
        if (!negatiivisiaLukuja & !rationaalilukuja) {
            return arvoLuonnollinenLuku();
        }
        if (!rationaalilukuja) {
            return arvoKokonaisluku();
        }
        if (!negatiivisiaLukuja) {
            return arvoMurtoluku(true);
        }
        return arvoMurtoluku(false);
    }

    public Luku arvoLuonnollinenLuku() {
        int yla = arvoLuonnollinenInt();
        Luku luku = new Luku(yla, 1);
        return luku;
    }

    public Luku arvoKokonaisluku() {
        int yla = arvoKokonaisInt();
        Luku luku = new Luku(yla, 1);
        return luku;
    }

    public int arvoLuonnollinenInt() {
        return arpoja.nextInt(kokorajoitus + 1);
    }

    public int arvoKokonaisInt() {
        return arpoja.nextInt(kokorajoitus * 2 + 1) - kokorajoitus;
    }

    public Luku arvoMurtoluku(boolean positiivinen) {
        int yla;
        int ala;
        if (positiivinen) {
            yla = arvoLuonnollinenInt();
            ala = arvoLuonnollinenInt();
        } else {
            yla = arvoKokonaisInt();
            ala = arvoKokonaisInt();
        }
        Luku luku = new Luku(yla, ala);
        return luku;
    }

    public String tilastot() {
        return "" + oikeita + " oikein, " + vaaria + " väärin";
    }
}
