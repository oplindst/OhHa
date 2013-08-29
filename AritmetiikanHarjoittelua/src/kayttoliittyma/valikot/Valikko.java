/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.valikot;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author O-P
 */
public abstract class Valikko {
    
    private JFrame frame;
    
    public Valikko() {
        
    }
    
    public JFrame Valikko() {
        frame = new JFrame("Aritmetiikan Harjoittelua");
        frame.setPreferredSize(new Dimension(500, 250));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;

        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public abstract void luoKomponentit(Container container);
}
