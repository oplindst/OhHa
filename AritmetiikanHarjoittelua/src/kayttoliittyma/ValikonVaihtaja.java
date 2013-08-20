/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import sovelluslogiikka.Hallinta;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.SpringLayout;
import sovelluslogiikka.Luku;

public class ValikonVaihtaja implements ActionListener {

    private JFrame frame;
    private String valikko;
    private Hallinta hallinta;
    
    public ValikonVaihtaja(JFrame frame, String valikko) {
        this.frame = frame;
        this.valikko = valikko;
        this.hallinta = new Hallinta(100, 200, false, true, true, false, "+-*/");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        frame = new JFrame("Aritmetiikan harjoittelua");
        frame.setPreferredSize(new Dimension(500, 250));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        container.setLayout(new SpringLayout());
        HashMap<String, Luku> kysymykset = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            kysymykset.put(hallinta.kysy(), hallinta.getTulos());
        }

        for (String kysymys : kysymykset.keySet()) {
            JLabel kys = new JLabel(kysymys, JLabel.TRAILING);
            JTextField textField = new JTextField(10);
            JButton tarkista = new JButton("Tarkista");
            JLabel vastaus = new JLabel("                                        ");
            Tarkistaja tarkistaja = new Tarkistaja(hallinta, kys, textField, vastaus, kysymykset.get(kysymys));
            tarkista.addActionListener(tarkistaja);
            container.add(kys);
            container.add(textField);
            container.add(tarkista);
            container.add(vastaus);
        }

        frame.setPreferredSize(new Dimension(400, 400));

        SpringUtilities.makeCompactGrid(container,
                10, 4,
                6, 6,
                6, 6);
    }
    
}
