/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import sovelluslogiikka.*;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class AritmetiikanHarjoittelua {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        HashMap<Integer, String> muuntaja = new HashMap<>();
        Random arpoja = new Random();
        muuntaja.put(0, "+");
        muuntaja.put(1, "-");
        muuntaja.put(2, "*");
        muuntaja.put(3, "/");
        Kirjanpitaja kirjanpito = new Kirjanpitaja();
        int tulos;

        for (int i = 1; i <= 10; i++) {
            String laskutoimitus = muuntaja.get(arvoLuonnollinenLuku(arpoja, 3));
            int eka = arvoLuonnollinenLuku(arpoja, 100);
            int toka = arvoLuonnollinenLuku(arpoja, 100);
            tulostaKysymys(eka, toka, laskutoimitus);
            tulos = laske(laskutoimitus, eka, toka);
            int luku = lukija.nextInt();
            if (luku == tulos) {
                System.out.println("Oikein!");
                kirjanpito.oikein();
            } else {
                System.out.println("Väärin!");
                tulostaKysymys(eka, toka, laskutoimitus);
                System.out.print(tulos);
                kirjanpito.vaarin();
                System.out.println();
            }
        }


        System.out.println(kirjanpito);

    }
    
    public static void tulostaKysymys(int eka, int toka, String laskutoimitus) {
        if (laskutoimitus.equals("/")) {
            eka = toka * (eka/toka);
        }
        System.out.print(eka + " " + laskutoimitus + " " + toka + " = ");
    }
    
    public static int arvoLuonnollinenLuku(Random arpoja,int koko) {
        if (koko >= 0) {
            return arpoja.nextInt(koko+1);
        }
        return 0;
    }
    
    public static int laske(String laskutoimitus, int ekaLuku, int tokaLuku) {
        if (laskutoimitus.equals("+")) {
            return ekaLuku+tokaLuku;
        }
        else if (laskutoimitus.equals("-")) {
            return ekaLuku-tokaLuku;
        }
        else if (laskutoimitus.equals("*")) {
            return ekaLuku*tokaLuku;
        }
        else {
            return ekaLuku/tokaLuku;
        }
    }

}
