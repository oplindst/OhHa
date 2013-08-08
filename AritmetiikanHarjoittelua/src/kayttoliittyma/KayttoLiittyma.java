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

    public KayttoLiittyma() {
    }

    public void suorita() {
        hallinta = new Hallinta(100, false, false, true);

        for (int i = 1; i <= 10; i++) {
            kysy();
        }
        tilastot();
    }
    
    public int syotaInt() {
        Scanner lukija = new Scanner(System.in);
        return lukija.nextInt();
    }
    
    public void kysy() {
        System.out.print(hallinta.kysy());
        if (!hallinta.rationaalilukuja()) {
            hallinta.setSyote(syotaInt());
        }
        boolean tarkistus = hallinta.tarkista();
        if (tarkistus) {
            System.out.println("Oikein!");
            hallinta.oikein();
        }
        else {
            System.out.println(hallinta.vaaraVastaus());
        }
    }
    
    public void tilastot() {
        System.out.println(hallinta.tilastot());
    }
}
