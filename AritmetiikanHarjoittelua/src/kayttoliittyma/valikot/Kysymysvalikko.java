/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma.valikot;

import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import kayttoliittyma.tapahtumankuuntelijat.Tarkistaja;
import kayttoliittyma.tapahtumankuuntelijat.TilastojenNayttaja;
import kayttoliittyma.tapahtumankuuntelijat.ValikonVaihtaja;
import kayttoliittyma.tapahtumankuuntelijat.ViestinNayttaja;
import kayttoliittyma.tyokalut.SpringUtilities;
import sovelluslogiikka.Hallinta;
import sovelluslogiikka.Luku;
import sovelluslogiikka.Tilastot;

/**
 *
 * @author O-P
 */
public class Kysymysvalikko extends Valikko {

    private JFrame frame;
    private Hallinta hallinta;
    private JComponent[] komponenttilista;
    private ValikkoTyyppi tyyppi;

    public Kysymysvalikko(Hallinta hallinta, ValikkoTyyppi tyyppi, JComponent... lista) {
        super();
        frame = super.Valikko();
        this.hallinta = hallinta;
        this.tyyppi = tyyppi;
        komponenttilista = lista;
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private boolean murtoluvut() {
        return hallinta.ratkaisutMurtolukuja();
    }
    

    @Override
    public void luoKomponentit(Container container) {
        container.setLayout(new SpringLayout());
        HashMap<String, Luku> ratkaisut = hallinta.kysy();
        JLabel tulokset = new JLabel(hallinta.tilastot());


        for (String kysymys : ratkaisut.keySet()) {
            JLabel kys = new JLabel(kysymys, JLabel.TRAILING);
            JTextField osoittaja = new JTextField(5);
            JButton tarkista = new JButton("Tarkista");
            JLabel vastaus = new JLabel("");
            Tarkistaja tarkistaja = new Tarkistaja(hallinta, kys, osoittaja, null, vastaus, ratkaisut.get(kysymys), tulokset);
            container.add(kys);
            container.add(osoittaja);
            if (murtoluvut()) {
                JLabel jako = new JLabel("/");
                JTextField nimittaja = new JTextField(5);
                tarkistaja = new Tarkistaja(hallinta, kys, osoittaja, nimittaja, vastaus, ratkaisut.get(kysymys), tulokset);
                container.add(jako);
                container.add(nimittaja);
            }
            tarkista.addActionListener(tarkistaja);
            container.add(tarkista);
            container.add(vastaus);
        }
        JLabel tyhja1 = new JLabel("");
        JLabel tyhja2 = new JLabel("");
        JLabel tyhja3 = new JLabel("");
        JButton tilastot = new JButton("Tilastot");
        TilastojenNayttaja tilasto = new TilastojenNayttaja(hallinta.getTilastot());
        tilastot.addActionListener(tilasto);
        JButton uudestaan = new JButton("Uudestaan");
        JLabel tyhja9 = new JLabel("");
        JButton takaisin = new JButton("Takaisin");
        JButton jatka = new JButton("Jatka");
        ValikonVaihtaja jatko = new ValikonVaihtaja(frame, ValikkoTyyppi.JATKO, hallinta);
        jatka.addActionListener(jatko);
        ValikonVaihtaja restart;
        restart = new ValikonVaihtaja(getFrame(), tyyppi, komponenttilista);
        ValikonVaihtaja boot = new ValikonVaihtaja(getFrame(), ValikkoTyyppi.PAAVALIKKO, new JLabel("tyhja"));
        uudestaan.addActionListener(restart);
        takaisin.addActionListener(boot);

        container.add(tulokset);
        if (murtoluvut()) {
            JLabel tyhja4 = new JLabel("");
            JLabel tyhja5 = new JLabel("");
            container.add(tyhja4);
            container.add(tyhja5);
        }
        container.add(tyhja9);
        container.add(uudestaan);
        container.add(takaisin);

        container.add(tyhja1);
        container.add(tyhja2);
        
        if (murtoluvut()) {
            JLabel tyhja6 = new JLabel("");
            JLabel tyhja7 = new JLabel("");
            container.add(tyhja6);
            container.add(tyhja7);
        }
        container.add(jatka);
        container.add(tilastot);


        getFrame().setPreferredSize(new Dimension(1000 + hallinta.lukujenKoko() / 1000, 100 + 33 * hallinta.getKysymystenMaara()));

        int leveys = 4;
        if (murtoluvut()) {
            leveys = 6;
        }
        SpringUtilities.makeCompactGrid(container,
                hallinta.getKysymystenMaara() + 2, leveys,
                6, 6,
                6, 6);
    }
}
