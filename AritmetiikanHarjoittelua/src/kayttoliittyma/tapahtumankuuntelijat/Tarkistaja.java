/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import sovelluslogiikka.Hallinta;
import sovelluslogiikka.Luku;

/**
 *
 * @author O-P
 */
public class Tarkistaja implements ActionListener {

    private JLabel kysymys;
    private JTextField osoittaja;
    private JTextField nimittaja;
    private JLabel vastaus;
    private Hallinta hallinta;
    private Luku tulos;
    private JLabel tilastot;
    private boolean tarkistettu;

    public Tarkistaja(Hallinta hallinta, JLabel kysymys, JTextField osoittaja, JTextField nimittaja, JLabel vastaus, Luku tulos, JLabel tulokset) {
        this.kysymys = kysymys;
        this.hallinta = hallinta;
        this.osoittaja = osoittaja;
        this.nimittaja = nimittaja;
        this.vastaus = vastaus;
        this.tulos = tulos;
        tarkistettu = false;

        tilastot = tulokset;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!tarkistettu) {
            try {
                int osoitt = Integer.parseInt(osoittaja.getText());

                int nimitt;
                if (nimittaja == null) {
                    nimitt = 1;
                }
                else {
                    nimitt = Integer.parseInt(nimittaja.getText());
                }
                boolean oikein = hallinta.tarkista(osoitt, nimitt, tulos);
                if (oikein) {
                    vastaus.setText("Oikein");
                } else {
                    vastaus.setText("Väärin: " + kysymys.getText() + tulos);
                }
                tarkistettu = true;
                paivitaTilastot();
            } catch (Exception ex) {
                System.out.println("Syötä kokonaisluku");
            }
        }
    }

    public void paivitaTilastot() {
        tilastot.setText(hallinta.tilastot());
    }
}
