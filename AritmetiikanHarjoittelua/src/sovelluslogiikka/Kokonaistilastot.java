/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 * Kokonaistilastot pitävät kirjaa koko ohjelman suorituksen aikana saaduista oikeista ja vääristä vastauksista
 * 
 */
public class Kokonaistilastot {
    
    private static int plusOikeita;
    private static int plusVaaria;
    private static int miinusOikeita;
    private static int miinusVaaria;
    private static int kertoOikeita;
    private static int kertoVaaria;
    private static int jakoOikeita;
    private static int jakoVaaria;

    public Kokonaistilastot() {
        plusOikeita = 0;
        plusVaaria = 0;
        miinusOikeita = 0;
        miinusVaaria = 0;
        kertoOikeita = 0;
        kertoVaaria = 0;
        jakoOikeita = 0;
        jakoVaaria = 0;
    }

    public static int getOikeat() {
        return plusOikeita + miinusOikeita + kertoOikeita + jakoOikeita;
    }

    public static int getVaarat() {
        return plusVaaria + miinusVaaria + kertoVaaria + jakoVaaria;
    }

    public static int getOikeatPlus() {
        return plusOikeita;
    }

    public static int getVaaratPlus() {
        return plusVaaria;
    }

    public static void plusVaarin() {
        plusVaaria++;
    }

    public static void plusOikein() {
        plusOikeita++;
        
    }

    public static int getOikeatMiinus() {
        return miinusOikeita;
    }

    public static int getVaaratMiinus() {
        return miinusVaaria;
    }

    public static void miinusVaarin() {
        miinusVaaria++;
    }

    public static void miinusOikein() {
        miinusOikeita++;
    }

    public static int getOikeatKerto() {
        return kertoOikeita;
    }

    public static int getVaaratKerto() {
        return kertoVaaria;
    }

    public static void kertoVaarin() {
        kertoVaaria++;
    }

    public static void kertoOikein() {
        kertoOikeita++;
    }

    public static int getOikeatJako() {
        return jakoOikeita;
    }

    public static int getVaaratJako() {
        return jakoVaaria;
    }

    public static void jakoVaarin() {
        jakoVaaria++;
    }

    public static void jakoOikein() {
        jakoOikeita++;
    }
    
    
    public static String tilastot() {
        return "Yhteenlaskuja " + plusOikeita + " oikein, " + plusVaaria + " väärin. "
                + "\nVähennyslaskuja " + miinusOikeita + " oikein, " + miinusVaaria + " väärin. "
                + "\nKertolaskuja " + kertoOikeita + " oikein, " + kertoVaaria + " väärin. "
                + "\nJakolaskuja " + jakoOikeita + " oikein, " + jakoVaaria + " väärin. "
                + "\nYhteensä " + getOikeat() + " oikein, " + getVaarat() + " väärin.";
                
        
    }
}
