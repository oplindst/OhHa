/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author O-P
 */
public class Tilastot {

    private int plusOikeita;
    private int plusVaaria;
    private int miinusOikeita;
    private int miinusVaaria;
    private int kertoOikeita;
    private int kertoVaaria;
    private int jakoOikeita;
    private int jakoVaaria;

    public Tilastot() {
        plusOikeita = 0;
        plusVaaria = 0;
        miinusOikeita = 0;
        miinusVaaria = 0;
        kertoOikeita = 0;
        kertoVaaria = 0;
        jakoOikeita = 0;
        jakoVaaria = 0;
    }

    public int getOikeat() {
        return plusOikeita + miinusOikeita + kertoOikeita + jakoOikeita;
    }

    public int getVaarat() {
        return plusVaaria + miinusVaaria + kertoVaaria + jakoVaaria;
    }

    public int getOikeatPlus() {
        return plusOikeita;
    }

    public int getVaaratPlus() {
        return plusVaaria;
    }

    public void plusVaarin() {
        plusVaaria++;
        Kokonaistilastot.plusVaarin();
    }

    public void plusOikein() {
        plusOikeita++;
        Kokonaistilastot.plusOikein();
        
    }

    public int getOikeatMiinus() {
        return miinusOikeita;
    }

    public int getVaaratMiinus() {
        return miinusVaaria;
    }

    public void miinusVaarin() {
        miinusVaaria++;
        Kokonaistilastot.miinusVaarin();
    }

    public void miinusOikein() {
        miinusOikeita++;
        Kokonaistilastot.miinusOikein();
    }

    public int getOikeatKerto() {
        return kertoOikeita;
    }

    public int getVaaratKerto() {
        return kertoVaaria;
    }

    public void kertoVaarin() {
        kertoVaaria++;
        Kokonaistilastot.kertoVaarin();
    }

    public void kertoOikein() {
        kertoOikeita++;
        Kokonaistilastot.kertoOikein();
    }

    public int getOikeatJako() {
        return jakoOikeita;
    }

    public int getVaaratJako() {
        return jakoVaaria;
    }

    public void jakoVaarin() {
        jakoVaaria++;
        Kokonaistilastot.jakoVaarin();
    }

    public void jakoOikein() {
        jakoOikeita++;
        Kokonaistilastot.jakoOikein();
    }
    
    public boolean plusSujuu() {
        return (plusOikeita >= 4*plusVaaria);
    }
    public boolean miinusSujuu() {
        return (miinusOikeita >= 4*miinusVaaria);
    }
    public boolean kertoSujuu() {
        return (kertoOikeita >= 4*kertoVaaria);
    }
    public boolean jakoSujuu() {
        return (jakoOikeita >= 4*jakoVaaria);
    }
    
    public boolean eiVaikeuksia() {
        return (plusSujuu()&&miinusSujuu())&&(kertoSujuu()&&jakoSujuu());
    }

    @Override
    public String toString() {
        return "Yhteenlaskuja " + plusOikeita + " oikein, " + plusVaaria + " väärin. "
                + "\nVähennyslaskuja " + miinusOikeita + " oikein, " + miinusVaaria + " väärin. "
                + "\nKertolaskuja " + kertoOikeita + " oikein, " + kertoVaaria + " väärin. "
                + "\nJakolaskuja " + jakoOikeita + " oikein, " + jakoVaaria + " väärin. "
                + "\nYhteensä " + getOikeat() + " oikein, " + getVaarat() + " väärin.";
                
        
    }
    
    public String mitenMenee() {
        String mitenMenee = "Seuraavissa laskutoimituksissa on vaikeuksia: ";
        if (!plusSujuu()) {
            mitenMenee = mitenMenee + "plus, ";
        }
        if (!miinusSujuu()) {
            mitenMenee = mitenMenee + "miinus, ";
        }
        if (!kertoSujuu()) {
            mitenMenee = mitenMenee + "kerto, ";
        }
        if (!jakoSujuu()) {
            mitenMenee = mitenMenee + "jako, ";
        }
        return mitenMenee;
        
        
    }
}
