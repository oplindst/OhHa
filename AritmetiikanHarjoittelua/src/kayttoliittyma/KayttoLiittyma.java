/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import sovelluslogiikka.Hallinta;
import java.util.Scanner;

/**
 *
 * @author O-P
 */
public class KayttoLiittyma {

    private Hallinta hallinta;
    private Scanner lukija;

    public KayttoLiittyma() {
        lukija = new Scanner(System.in);
    }

    public void suorita() {
        while (true) {
            hallinta = teeUusiHallinta();
            System.out.println("Kuinka monta kysymystä?");
            int maara = syotaLuku();
            for (int i = 1; i <= maara; i++) {
                kysy();
            }
            tilastot();
            String uudestaan = lukija.nextLine();
            if (!uudestaan.equals("joo")) {
                break;
            }
        }
        System.out.println("Kiitos!");
    }

    private int syotaLuku() {
        while (true) {
            try {
                while (true) {
                    int luku = Integer.parseInt(lukija.nextLine());
                    if (luku < 1) {
                        System.out.println("Syötä positiivinen luku");
                    } else {
                        return luku;
                    }
                }
            } catch (Exception e) {
                System.out.println("Syötä kokonaisluku");
            }
        }
    }
    
    private String syotaMerkkijono() {
        while (true) {
            try {
                String mjono = lukija.nextLine();
                return mjono;
            }
            catch(Exception e) {
                System.out.println("Syötä merkkijono");
            }
        }
    }

    private Hallinta teeUusiHallinta() {
        boolean n;
        boolean q;
        boolean nega;
        boolean rati;
        System.out.println("Mitkä laskutoimitukset mukana?");
        String laskutoimitukset = syotaMerkkijono();

        System.out.println("Yläraja lukujen koolle?");
        int koko = syotaLuku();

        System.out.println("Lasketaanko negatiivisilla luvuilla? (1=kyllä/2=ei)");
        int eka = syotaLuku();

        System.out.println("Lasketaanko murtoluvuilla? (1=kyllä/2=ei)");
        int toka = syotaLuku();

        System.out.println("Saavatko ratkaisut olla negatiivisia? (1=kyllä/2=ei)");
        int kolmas = syotaLuku();

        System.out.println("Saavatko ratkaisut olla murtolukuja? (1=kyllä/2=ei)");
        int neljas = syotaLuku();



        if (tarkistaVastaus(eka)) {
            n = true;
        } else {
            n = false;
        }

        if (tarkistaVastaus(toka)) {
            q = true;
        } else {
            q = false;
        }

        if (tarkistaVastaus(kolmas)) {
            nega = true;
        } else {
            nega = false;
        }

        if (tarkistaVastaus(neljas)) {
            rati = true;
        } else {
            rati = false;
        }

        return new Hallinta(koko, 2 * koko, q, n, nega, rati, laskutoimitukset);
    }

    private boolean tarkistaVastaus(int vastaus) {
        if (vastaus == 1) {
            return true;
        }
        return false;
    }

    private void kysy() {
        String kysymys = hallinta.kysy();
        System.out.print(kysymys);
        int osoittaja = 1;
        int nimittaja = 1;
        if (!hallinta.ratkaisutMurtolukuja()) {
            osoittaja = syotaLuku();

        } else {
            osoittaja = syotaLuku();
            System.out.print("/");
            nimittaja = syotaLuku();
        }
        if (hallinta.tarkista(osoittaja, nimittaja)) {
            System.out.println("Oikein!");
        } else {
            System.out.println("Väärin! \n" + kysymys + hallinta.getTulos());
        }
    }

    private void tilastot() {
        System.out.println(hallinta.tilastot());
    }
}
