/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.HashMap;
import laskutoimitukset.*;

/**
 * Hallinta laatii kysymyksiä ja tarkistaa käyttäjän antamien vastauksien oikeellisuuden
 * 
 */
public class Hallinta {

    private int lukujenKoko;
    private int ratkaisujenKoko;
    private boolean rationaalilukuja;
    private boolean negatiivisiaLukuja;
    private boolean ratkaisutNegatiivisia;
    private boolean ratkaisutRationaalisia;
    private Arpoja arpoja;
    private Tilastot tilastot;
       /**
 * Kysymyksissä esiintyy vain laskutoimituksia, jotka tämä merkkijono sisältää. Ainakin yhden seuraavista
 * on löydyttävä merkkijonosta: +, -, *, /
 */
    private String laskutoimitukset;
    private int kysymystenMaara;
       /**
 * Kertoo, onko kysymyksissä kolme lukua vai kaksi
 */
    private boolean kolmeLukua;
    
   /**
 * Konstruktori heittää virheen käyttöliittymälle, jos parametrit ovat virheellisiä
 */
    
    public Hallinta(int maara, int lukukoko, int ratkkoko, boolean q, boolean z, boolean negaratk, boolean ratiratk, String laskutoimitukset, boolean kolme) throws Exception {

        kysymystenMaara = maara;
        arpoja = new Arpoja();
        lukujenKoko = lukukoko;
        ratkaisujenKoko = ratkkoko;
        rationaalilukuja = q;
        negatiivisiaLukuja = z;
        ratkaisutNegatiivisia = negaratk;
        ratkaisutRationaalisia = ratiratk;
        this.laskutoimitukset = laskutoimitukset;
        kolmeLukua = kolme;
        if (laskutoimitukset.equals("") || kysymystenMaara < 1 || kysymystenMaara > 20 || lukujenKoko <= 4 || ratkaisujenKoko <= 9 || lukujenKoko > 1000 || ratkaisujenKoko > 2000) {
            throw new IllegalArgumentException("tarkista syötteesi");
        }
        tilastot = new Tilastot();

    }

    public int getKysymystenMaara() {
        return kysymystenMaara;
    }

    public int lukujenKoko() {
        return lukujenKoko;
    }

    public int ratkaisujenKoko() {
        return ratkaisujenKoko;
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

    public Tilastot getTilastot() {
        return tilastot;
    }

    public int getOikeat() {
        return tilastot.getOikeat();
    }

    public int getVaarat() {
        return tilastot.getVaarat();
    }

    public boolean hyvinMenee() {
        return tilastot.eiVaikeuksia();
    }

    public boolean plusSujuu() {
        return tilastot.plusSujuu();
    }

    public boolean miinusSujuu() {
        return tilastot.miinusSujuu();
    }

    public boolean kertoSujuu() {
        return tilastot.kertoSujuu();
    }

    public boolean jakoSujuu() {
        return tilastot.jakoSujuu();
    }

    public boolean kolmeLukua() {
        return kolmeLukua;
    }
    
       /**
 * Laatii kysymyksiä ja niiden vastauksia konstruktorille annetun arvon verran. 
 * 
 * @return hajautustaulu, jossa avaimina kysymyksiä ja arvoina kunkin vastaukset
 */

    public HashMap<String, Luku> kysy() {
        HashMap<String, Luku> kysymykset = new HashMap<>();
        for (int i = 0; i < kysymystenMaara; i++) {
            Luku eka = new Luku(1, 1);
            Luku toka = new Luku(1, 1);
            Luku kolmas = new Luku(1, 1);
            Laskutoimitus laskutoimitus = arvoLaskutoimitus();
            Laskutoimitus tokaLaskutoimitus = arvoLaskutoimitus();
            Luku tulos = new Luku(1, 0);
            while (-tulos.getOsoittaja() > ratkaisujenKoko || tulos.getOsoittaja() > ratkaisujenKoko || !tulos.maaritelty() || !eka.maaritelty() || !toka.maaritelty() || !kolmas.maaritelty()) {
                if (ratkaisutRationaalisia) {
                    eka = arvoLuku();
                    toka = arvoLuku();
                    kolmas = arvoLuku();
                }
                else if (!ratkaisutNegatiivisia && ratkaisutNegatiivisia) {
                    eka = arvoKokonaisluku();
                    toka = arvoKokonaisluku();
                    kolmas = arvoKokonaisluku();
                }
                else {
                    eka = arvoLuonnollinenLuku();
                    toka = arvoLuonnollinenLuku();
                    kolmas = arvoLuonnollinenLuku();
                }
                if (kolmeLukua) {
                    tulos = laskutoimitus.laske(eka, tokaLaskutoimitus.laske(toka, kolmas));
                } else {
                    tulos = laskutoimitus.laske(eka, toka);
                }
            }

            kysymykset.put(kysymys(eka, toka, kolmas, laskutoimitus, tokaLaskutoimitus), tulos);
        }
        return kysymykset;
    }

    /**
     * Metodi antaa merkkijonoesityksen kysymyksestä
     *
     * @param eka ensimmäinen luku
     * @param toka toinen luku
     * @param laskutoimitus kysymyksen laskutoimitus
     *
     * @return kysymyksen merkkijonoesitys
     */
    public String kysymys(Luku eka, Luku toka, Luku kolmas, Laskutoimitus laskutoimitus, Laskutoimitus tokaLaskutoimitus) {
        if (!kolmeLukua) {
            return "" + eka + " " + laskutoimitus + " " + toka + " = ";
        }
        return "" + eka + " " + laskutoimitus + " " + toka + " " + tokaLaskutoimitus + " " + kolmas + " = ";
    }

    /**
     * Metodi tarkistaa, onko käyttäjän antama luku (osoittaja/nimittäjä) sama,
     * kuin laskun ratkaisu
     *
     * @param osoittaja käyttäjän antaman luvun osoittaja
     * @param nimittaja käyttäjän antaman luvun nimittäjä
     * @param tulos laskun oikea vastaus
     *
     * @return true, jos käyttäjän antama luku on oikein, muuten false
     */
    public boolean tarkista(int osoittaja, int nimittaja, Luku tulos) {
        tulos.sievenna();
        Luku luku = new Luku(osoittaja, nimittaja);
        luku.sievenna();
        if (luku.equals(tulos)) {
            oikein(tulos.getLaskutoimitus());
            return true;
        }
        vaarin(tulos.getLaskutoimitus());
        return false;
    }

    public void vaarin(KaytettyLaskutoimitus lasku) {
        if (lasku == KaytettyLaskutoimitus.PLUS) {
            tilastot.plusVaarin();
        } else if (lasku == KaytettyLaskutoimitus.MIINUS) {
            tilastot.miinusVaarin();
        } else if (lasku == KaytettyLaskutoimitus.KERTO) {
            tilastot.kertoVaarin();
        } else {
            tilastot.jakoVaarin();
        }
    }

    public void oikein(KaytettyLaskutoimitus lasku) {
        if (lasku == KaytettyLaskutoimitus.PLUS) {
            tilastot.plusOikein();
        } else if (lasku == KaytettyLaskutoimitus.MIINUS) {
            tilastot.miinusOikein();
        } else if (lasku == KaytettyLaskutoimitus.KERTO) {
            tilastot.kertoOikein();
        } else {
            tilastot.jakoOikein();
        }
    }

    /**
     * Metodi arpoo laskutoimituksen
     *
     * @see Arpoja#arvoLaskutoimitus(String)
     */
    public Laskutoimitus arvoLaskutoimitus() {
        return arpoja.arvoLaskutoimitus(laskutoimitukset);
    }

    /**
     * Metodi antaa satunnaisen luvun
     *
     * @see Arpoja#arvoLuku(boolean, boolean, int)
     */
    public Luku arvoLuku() {
        return arpoja.arvoLuku(negatiivisiaLukuja, rationaalilukuja, lukujenKoko);
    }

    public Luku arvoKokonaisluku() {
        return arpoja.arvoKokonaisluku(lukujenKoko);
    }
    
    public Luku arvoLuonnollinenLuku() {
        return arpoja.arvoLuonnollinenLuku(lukujenKoko);
    }

    /**
     * Metodi antaa merkkijonoesityksenä oikeiden ja väärien vastausten määrät
     *
     * @return oikeat ja väärät vastaukset merkkijonona
     */
    public String tilastot() {
        String tulostus = "";
        if (tilastot.getOikeat() + tilastot.getVaarat() == kysymystenMaara) {
            tulostus = tulostus + "Valmis: ";
        }
        tulostus = tulostus + tilastot.getOikeat() + " oikein, " + tilastot.getVaarat() + " väärin.";
        return tulostus;
    }

    public String tarkemmatTilastot() {
        return tilastot.toString();
    }
}
