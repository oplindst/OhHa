/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.valikot;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import kayttoliittyma.tapahtumankuuntelijat.ValikonVaihtaja;
import kayttoliittyma.tyokalut.SpringUtilities;

/**
 *
 * @author O-P
 */
public class Asetusvalikko extends Valikko{

    private JFrame frame;
    
    public Asetusvalikko() {
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
        JLabel ekaTeksti = new JLabel("Montako kysymystä? (1-20)");
        JTextField kysymystenMaara = new JTextField("");
        JLabel tokaTeksti = new JLabel("Anna yläraja laskettavien lukujen suuruuksille (5-1000)");
        JTextField lukujenSuuruus = new JTextField("");
        JLabel kolmasTeksti = new JLabel("Anna yläraja ratkaisujen suuruuksille (10-2000)");
        JTextField vastaustenSuuruus = new JTextField("");
        JCheckBox negatiivisia = new JCheckBox("Lasketaan negatiivisilla luvuilla");
        JCheckBox murtolukuja = new JCheckBox("Lasketaan murtoluvuilla");
        JCheckBox vastauksetNegatiivisia = new JCheckBox("Vastaukset negatiivisia");
        JCheckBox vastauksetMurtolukuja = new JCheckBox("Vastaukset murtolukuja");
        JCheckBox kolmeLukua = new JCheckBox("Lasketaan kolmella luvulla");
        JLabel laskutoimitukset = new JLabel("Valitse laskutoimitukset (vähintään yksi)");
        JCheckBox plus = new JCheckBox("+ (plus)");
        JCheckBox miinus = new JCheckBox("- (miinus)");
        JCheckBox kerto = new JCheckBox("* (kerto)");
        JCheckBox jako = new JCheckBox("/ (jako)");
        JButton takaisin = new JButton("Takaisin");
        JButton aloita = new JButton("Aloita");
        JLabel tyhjaa = new JLabel("");
        ValikonVaihtaja takas = new ValikonVaihtaja(frame, ValikkoTyyppi.PAAVALIKKO, new JLabel("tyhjä"));
        ValikonVaihtaja alota = new ValikonVaihtaja(frame, ValikkoTyyppi.KYSYMYS, kysymystenMaara, lukujenSuuruus, vastaustenSuuruus, murtolukuja, negatiivisia, vastauksetNegatiivisia, vastauksetMurtolukuja, plus, miinus, kerto, jako, kolmeLukua);
        takaisin.addActionListener(takas);
        aloita.addActionListener(alota);
        
        container.add(laskutoimitukset);
        container.add(plus);
        container.add(miinus);
        container.add(kerto);
        container.add(jako);
        container.add(ekaTeksti);
        container.add(kysymystenMaara);
        container.add(tokaTeksti);
        container.add(lukujenSuuruus);
        container.add(kolmasTeksti);
        container.add(vastaustenSuuruus);
        container.add(negatiivisia);
        container.add(murtolukuja);
        container.add(vastauksetNegatiivisia);
        container.add(vastauksetMurtolukuja);
        container.add(kolmeLukua);
        container.add(tyhjaa);
        container.add(aloita);
        container.add(takaisin);
        
        getFrame().setPreferredSize(new Dimension(400, 560));
        
        SpringUtilities.makeCompactGrid(container,
                19, 1,
                6, 6,
                6, 6);
        
    }
    
}
