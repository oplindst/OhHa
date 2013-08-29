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

/**
 *
 * @author O-P
 */
public class ViestinNayttaja implements ActionListener{

    private JFrame frame;
    private String viesti;
    
    public ViestinNayttaja(String viesti) {
        this.viesti = viesti;
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(1000, 100));

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
    }
    
    public void luoKomponentit(Container container) {
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        JLabel label = new JLabel(viesti);
        container.add(label);
        SpringUtilities.asetaKomponentti(container, layout, label, 10, 10);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(true);
    }
    
}
