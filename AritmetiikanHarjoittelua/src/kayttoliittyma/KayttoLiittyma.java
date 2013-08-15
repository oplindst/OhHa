/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import sovelluslogiikka.*;
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
        
        hallinta = teeUusiHallinta();
        System.out.println("Kuinka monta kysymystä?");
        int maara = lukija.nextInt();

        for (int i = 1; i <= maara; i++) {
            kysy();
        }
        tilastot();
    }
    
    public Hallinta teeUusiHallinta() {
        boolean n;
        boolean q;
        boolean nega;
        System.out.println("Mitkä laskutoimitukset mukana?");
        String laskutoimitukset = lukija.nextLine();
        
        System.out.println("Kuinka suurilla luvuilla lasketaan?");
        int koko = lukija.nextInt();
        
        System.out.println("Lasketaanko negatiivisilla luvuilla? (1=kyllä/2=ei)");
        int eka = lukija.nextInt();
        
        System.out.println("Lasketaanko murtoluvuilla? (1=kyllä/2=ei)");
        int toka = lukija.nextInt();
        
        System.out.println("Saavatko ratkaisut olla negatiivisia? (1=kyllä/2=ei)");
        int kolmas = lukija.nextInt();
        
        if (tarkistaVastaus(eka)) {
            n = true;
        }
        else {
            n = false;
        }
        
        if (tarkistaVastaus(toka)) {
            q = true;
        }
        else {
            q = false;
        }
        
        if (tarkistaVastaus(kolmas)) {
            nega = true;
        }
        else {
            nega = false;
        }
        
        return new Hallinta(koko, q, n, nega, laskutoimitukset);
    }
    
    public boolean tarkistaVastaus(int vastaus) {
        if (vastaus==1) {
            return true;
        }
        return false;
    }
    
    public void kysy() {
        String kysymys = hallinta.kysy();
        System.out.print(kysymys);
        int vastaus = lukija.nextInt();
        if (hallinta.tarkista(vastaus)) {
            System.out.println("Oikein!");
        }
        else {
            System.out.println("Väärin! \n" + kysymys + hallinta.getTulos());
        }
    }
    
    public void tilastot() {
        System.out.println(hallinta.tilastot());
    }
}
