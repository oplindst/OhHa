/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import kayttoliittyma.KayttoLiittyma;
import kayttoliittyma.valikot.ValikkoTyyppi;
import sovelluslogiikka.Hallinta;

public class ValikonVaihtaja implements ActionListener {

    private JFrame frame;
    private ValikkoTyyppi tyyppi;
    private JComponent[] komponentit;
    private Hallinta hallinta;

    public ValikonVaihtaja(JFrame frame, ValikkoTyyppi type, JComponent... komponentit) {
        tyyppi = type;
        this.frame = frame;
        this.komponentit = komponentit;
    }

    public ValikonVaihtaja(JFrame frame, ValikkoTyyppi type, Hallinta hallinta) {
        this.frame = frame;
        tyyppi = type;
        this.hallinta = hallinta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        if (tyyppi == ValikkoTyyppi.AUTOMAATTIKYSYMYS) {
            try {
                Hallinta uusiHallinta = new Hallinta(10, 100, 200, false, true, true, false, "+-*/", false);
                KayttoLiittyma.teeKysymysvalikko(uusiHallinta, tyyppi, komponentit[0]);
            } catch (Exception ex) {
                System.out.println("tarkista syötteesi");
            }
        } else if (tyyppi == ValikkoTyyppi.KYSYMYS) {
            try {
                JTextComponent ekakomp = (JTextComponent) komponentit[0];
                int eka = Integer.parseInt(ekakomp.getText());
                JTextComponent tokakomp = (JTextComponent) komponentit[1];
                int toka = Integer.parseInt(tokakomp.getText());
                JTextComponent kolmaskomp = (JTextComponent) komponentit[2];
                int kolmas = Integer.parseInt(kolmaskomp.getText());
                JCheckBox neljaskomp = (JCheckBox) komponentit[3];
                boolean neljas = neljaskomp.isSelected();
                JCheckBox viideskomp = (JCheckBox) komponentit[4];
                boolean viides = viideskomp.isSelected();
                JCheckBox kuudeskomp = (JCheckBox) komponentit[5];
                boolean kuudes = kuudeskomp.isSelected();
                JCheckBox ykstoistakomp = (JCheckBox) komponentit[6];
                boolean ykstoista = ykstoistakomp.isSelected();
                String laskutoim = "";
                JCheckBox seiskakomp = (JCheckBox) komponentit[7];
                JCheckBox kasikomp = (JCheckBox) komponentit[8];
                JCheckBox ysikomp = (JCheckBox) komponentit[9];
                JCheckBox kymppikomp = (JCheckBox) komponentit[10];
                JCheckBox kakstoistakomp = (JCheckBox) komponentit[11];
                laskutoim = lisaaLaskutoimituksiin(laskutoim, seiskakomp);
                laskutoim = lisaaLaskutoimituksiin(laskutoim, kasikomp);
                laskutoim = lisaaLaskutoimituksiin(laskutoim, ysikomp);
                laskutoim = lisaaLaskutoimituksiin(laskutoim, kymppikomp);
                boolean kakstoista = kakstoistakomp.isSelected();
                Hallinta uusiHallinta = new Hallinta(eka, toka, kolmas, neljas, viides, kuudes, ykstoista, laskutoim, kakstoista);
                KayttoLiittyma.teeKysymysvalikko(uusiHallinta, tyyppi, komponentit);
            } catch (Exception ex) {
                System.out.println("tarkista syötteesi");
                frame.setVisible(true);
            }
        } else if (tyyppi == ValikkoTyyppi.PAAVALIKKO) {

            KayttoLiittyma.teePaavalikko();
        } else if (tyyppi == ValikkoTyyppi.JATKO) {
            if (hallinta.getKysymystenMaara() == hallinta.getOikeat() + hallinta.getVaarat()) {
                try {
                    int maara = hallinta.getKysymystenMaara();
                    boolean murto = hallinta.rationaalilukuja();
                    boolean nega = hallinta.negatiivisiaLukuja();
                    boolean negaratk = hallinta.ratkaisutNegatiivisia();
                    boolean murtoratk = hallinta.ratkaisutMurtolukuja();
                    int lukukoko = hallinta.lukujenKoko();
                    int ratkkoko = hallinta.ratkaisujenKoko();
                    boolean kolme = hallinta.kolmeLukua();
                    String laskutoimitukset = "";
                    if (hallinta.hyvinMenee()) {
                        lukukoko *= 2;
                        ratkkoko *= 2;
                        laskutoimitukset = "+-*/";
                    }
                    else {
                        if (!hallinta.plusSujuu()) {
                            laskutoimitukset= laskutoimitukset + "+";
                        }
                        if (!hallinta.miinusSujuu()) {
                            laskutoimitukset= laskutoimitukset + "-";
                        }
                        if (!hallinta.kertoSujuu()) {
                            laskutoimitukset= laskutoimitukset + "*";
                        }
                        if (!hallinta.jakoSujuu()) {
                            laskutoimitukset= laskutoimitukset + "/";
                        }
                    }

                    Hallinta uusiHallinta = new Hallinta(maara, lukukoko, ratkkoko, murto, nega, negaratk, murtoratk, laskutoimitukset, kolme);
                    KayttoLiittyma.teeKysymysvalikko(uusiHallinta, tyyppi, komponentit);
                } catch (Exception ex) {
                    System.out.println("tarkista syötteesi");
                }
            } else {
                frame.setVisible(true);
            }
        } else {

            KayttoLiittyma.teeAsetusvalikko();
        }
    }

    public String lisaaLaskutoimituksiin(String laskutoim, JCheckBox box) {
        if (box.isSelected()) {
            return laskutoim + box.getText();
        }
        return laskutoim;
    }
}
