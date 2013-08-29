/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.valikot;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import kayttoliittyma.tapahtumankuuntelijat.ValikonVaihtaja;
import kayttoliittyma.tapahtumankuuntelijat.ViestinNayttaja;
import kayttoliittyma.tyokalut.SpringUtilities;
import sovelluslogiikka.Kokonaistilastot;

/**
 *
 * @author O-P
 */
public class Paavalikko extends Valikko{

    private JFrame frame;
    
    public Paavalikko() {
        super();
        frame = super.Valikko();
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void luoKomponentit(Container container) {
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        JLabel label = new JLabel("Aritmetiikan harjoittelua");
        container.add(label);
        JButton aloita = new JButton("Nopea aloitus");
        JButton muokkaa = new JButton("Tarkenna asetuksia");
        JButton tilastot = new JButton("Kokonaistilastot");
        ViestinNayttaja nayttaja = new ViestinNayttaja(Kokonaistilastot.tilastot());
        tilastot.addActionListener(nayttaja);
        ValikonVaihtaja vaihtaja = new ValikonVaihtaja(frame, ValikkoTyyppi.AUTOMAATTIKYSYMYS, new JLabel("tyhja"));
        ValikonVaihtaja toinenVaihtaja = new ValikonVaihtaja(frame, ValikkoTyyppi.ASETUKSET, new JLabel("tyhja"));
        aloita.addActionListener(vaihtaja);
        muokkaa.addActionListener(toinenVaihtaja);
        container.add(aloita);
        container.add(muokkaa);
        container.add(tilastot);
        SpringUtilities.asetaKomponentti(container, layout, label, 180, 10);
        SpringUtilities.asetaKomponentti(container, layout, aloita, 190, 50);
        SpringUtilities.asetaKomponentti(container, layout, muokkaa, 175, 100);
        SpringUtilities.asetaKomponentti(container, layout, tilastot, 185, 150);
        
    }
    
}
