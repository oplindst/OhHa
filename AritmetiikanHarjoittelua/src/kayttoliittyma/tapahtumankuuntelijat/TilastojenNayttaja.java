/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.tapahtumankuuntelijat;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import kayttoliittyma.tyokalut.SpringUtilities;
import sovelluslogiikka.Tilastot;

/**
 *
 * @author O-P
 */
public class TilastojenNayttaja implements ActionListener{

    private JFrame frame;
    private JLabel luvut;
    private JLabel ongelmat;
    private Tilastot tilastot;
    
    public TilastojenNayttaja(Tilastot tilastot) {
        
        this.tilastot = tilastot;
        frame = new JFrame("Tilastot");
        frame.setPreferredSize(new Dimension(1100, 100));

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
    }
    
    public void paivitaTilastot(Tilastot tilastot) {
        this.tilastot = tilastot;
    }
    
    
    public void luoKomponentit(Container container) {
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        luvut = new JLabel(tilastot.toString());
        ongelmat = new JLabel(tilastot.mitenMenee());
        
        container.add(luvut);
        container.add(ongelmat);
        SpringUtilities.asetaKomponentti(container, layout, luvut, 10, 10);
        SpringUtilities.asetaKomponentti(container, layout, ongelmat, 10, 30);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        luvut.setText(tilastot.toString());
        ongelmat.setText(tilastot.mitenMenee());
        frame.setVisible(true);
        
    }
    
}
