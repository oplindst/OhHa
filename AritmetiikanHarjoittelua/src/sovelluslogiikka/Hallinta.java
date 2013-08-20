/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import laskutoimitukset.*;

/**
 *
 * @author O-P
 */
public class Hallinta {

    private int lukujenKoko;
    private int ratkaisujenKoko;
    private boolean rationaalilukuja;
    private boolean negatiivisiaLukuja;
    private boolean ratkaisutNegatiivisia;
    private boolean ratkaisutRationaalisia;
    private Arpoja arpoja;
    private Luku tulos;
    private int oikeita;
    private int vaaria;
    private String laskutoimitukset;

    public Hallinta(int lukukoko, int ratkkoko, boolean q, boolean z, boolean negaratk, boolean ratiratk, String laskutoimitukset) {
        arpoja = new Arpoja();
        lukujenKoko = lukukoko;
        ratkaisujenKoko = ratkkoko;
        rationaalilukuja = q;
        negatiivisiaLukuja = z;
        ratkaisutNegatiivisia = negaratk;
        ratkaisutRationaalisia = ratiratk;
        this.laskutoimitukset = laskutoimitukset;
    }

    private void alusta() {
        oikeita = 0;
        vaaria = 0;
    }

    public int lukujenKoko() {
        return lukujenKoko;
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
    
    public boolean ratkaisutMurtolukuja() {
        return ratkaisutRationaalisia;
    }

    public String kysy() {
        Luku eka = new Luku(1,1);
        Luku toka = new Luku(1,1);
        Laskutoimitus laskutoimitus = arvoLaskutoimitus();
        tulos = new Luku(1,0);
        while (-tulos.getOsoittaja()>ratkaisujenKoko || tulos.getOsoittaja()>ratkaisujenKoko || (!ratkaisutNegatiivisia && tulos.negatiivinen()) || (!ratkaisutRationaalisia && tulos.murtoluku()) || !tulos.maaritelty()) {
            eka = arvoLuku();
            toka = arvoLuku();
            tulos = laskutoimitus.laske(eka, toka);
        }
        
        return kysymys(eka, toka, laskutoimitus);
    }

    public String kysymys(Luku eka, Luku toka, Laskutoimitus laskutoimitus) {
        return "" + eka + " " + laskutoimitus + " " + toka + " = ";
    }

    public boolean tarkista(int osoittaja, int nimittaja, Luku tulos) {
        tulos.sievenna();
        Luku luku = new Luku(osoittaja, nimittaja);
        luku.sievenna();
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
        return arpoja.arvoLaskutoimitus(laskutoimitukset);
    }

    public Luku arvoLuku() {
        return arpoja.arvoLuku(negatiivisiaLukuja, rationaalilukuja, lukujenKoko);
    }

    public String tilastot() {
        return "" + oikeita + " oikein, " + vaaria + " väärin";
    }
}
