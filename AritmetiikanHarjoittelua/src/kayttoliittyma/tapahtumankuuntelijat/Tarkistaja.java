/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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
    private boolean tarkistettu;

    public Tarkistaja(Hallinta hallinta, JLabel kysymys, JTextField osoittaja, JLabel vastaus, Luku tulos) {
        this.kysymys = kysymys;
        this.hallinta = hallinta;
        this.osoittaja = osoittaja;
        this.vastaus = vastaus;
        this.tulos = tulos;
        tarkistettu = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!tarkistettu) {
            try {
                int osoitt = Integer.parseInt(osoittaja.getText());
            
            
            int nimitt = 1;
            boolean oikein = hallinta.tarkista(osoitt, nimitt, tulos);
            if (oikein) {
                vastaus.setText("Oikein");
            } else {
                vastaus.setText("Väärin: " + kysymys.getText() + tulos);
            }
            tarkistettu = true;
            }
            catch(Exception ex) {
                System.out.println("Syötä kokonaisluku");
            }
        }
    }
}
