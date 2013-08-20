package kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import javax.swing.SpringLayout;


import sovelluslogiikka.Hallinta;
import java.util.Scanner;

/**
 *
 * @author O-P
 */
public class KayttoLiittyma implements Runnable {

    private Hallinta hallinta;
    private Scanner lukija;
    private JFrame frame;

    public KayttoLiittyma() {
        lukija = new Scanner(System.in);
    }

    @Override
    public void run() {
        teePaavalikko();
        int joio = lukija.nextInt();
        

        while (true) {
            hallinta = teeUusiHallinta();
            System.out.println("Kuinka monta kysymystä?");
            int maara = syotaLuku(true);
            for (int i = 1; i <= maara; i++) {
                kysy();
            }
            tilastot();
            String uudestaan = lukija.nextLine();
            if (!uudestaan.equals("joo")) {
                break;
            }
        }
        System.out.println("Kiitos!");
    }
    
    public void teePaavalikko() {
        frame = new JFrame("Aritmetiikan harjoittelua");
        frame.setPreferredSize(new Dimension(500, 250));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoAloitusKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoAloitusKomponentit(Container container) {
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        JLabel label = new JLabel("Aritmetiikan harjoittelua");
        container.add(label);
        JButton aloita = new JButton("Nopea aloitus");
        ValikonVaihtaja vaihtaja = new ValikonVaihtaja(frame, "kysymys");
        aloita.addActionListener(vaihtaja);
        container.add(aloita);
        asetaKomponentti(container, layout, label, 180, 10);
        asetaKomponentti(container, layout, aloita, 190, 50);
        
    }
    
    private void asetaKomponentti(Container container, SpringLayout layout, JComponent component, int west, int north) {
        layout.putConstraint(SpringLayout.WEST, component,
                west,
                SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, component,
                north,
                SpringLayout.NORTH, container);
    }

    public void luoKysymyskomponentit(Container container) {
        container.setLayout(new SpringLayout());
        String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
        int kysymystenMaara = labels.length;

        for (int i = 0; i < kysymystenMaara; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            container.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            container.add(textField);
            JButton tarkista = new JButton("Tarkista");
            container.add(tarkista);
        }

        frame.setPreferredSize(new Dimension(kysymystenMaara * 70, 200));

        SpringUtilities.makeCompactGrid(container,
                kysymystenMaara, 3,
                6, 6,
                6, 6);
    }

    public JFrame getFrame() {
        return frame;
    }

    private int syotaLuku(boolean positiivinen) {
        while (true) {
            try {
                while (true) {
                    int luku = Integer.parseInt(lukija.nextLine());
                    if (luku < 1 && positiivinen) {
                        System.out.println("Syötä positiivinen luku");
                    } else {
                        return luku;
                    }
                }
            } catch (Exception e) {
                System.out.println("Syötä kokonaisluku");
            }
        }
    }

    private String syotaMerkkijono() {
        while (true) {
            try {
                String mjono = lukija.nextLine();
                return mjono;
            } catch (Exception e) {
                System.out.println("Syötä merkkijono");
            }
        }
    }

    private Hallinta teeUusiHallinta() {
        boolean n;
        boolean q;
        boolean nega;
        boolean rati;
        System.out.println("Mitkä laskutoimitukset mukana?");
        String laskutoimitukset = syotaMerkkijono();

        System.out.println("Yläraja lukujen koolle?");
        int koko = syotaLuku(true);

        System.out.println("Lasketaanko negatiivisilla luvuilla? (1=kyllä/2=ei)");
        int eka = syotaLuku(false);

        System.out.println("Lasketaanko murtoluvuilla? (1=kyllä/2=ei)");
        int toka = syotaLuku(false);

        System.out.println("Saavatko ratkaisut olla negatiivisia? (1=kyllä/2=ei)");
        int kolmas = syotaLuku(false);

        System.out.println("Saavatko ratkaisut olla murtolukuja? (1=kyllä/2=ei)");
        int neljas = syotaLuku(false);



        if (tarkistaVastaus(eka)) {
            n = true;
        } else {
            n = false;
        }

        if (tarkistaVastaus(toka)) {
            q = true;
        } else {
            q = false;
        }

        if (tarkistaVastaus(kolmas)) {
            nega = true;
        } else {
            nega = false;
        }

        if (tarkistaVastaus(neljas)) {
            rati = true;
        } else {
            rati = false;
        }

        return new Hallinta(koko, 2 * koko, q, n, nega, rati, laskutoimitukset);
    }

    private boolean tarkistaVastaus(int vastaus) {
        if (vastaus == 1) {
            return true;
        }
        return false;
    }

    private void kysy() {
        String kysymys = hallinta.kysy();

        int osoittaja = 1;
        int nimittaja = 1;
        if (!hallinta.ratkaisutMurtolukuja()) {
            osoittaja = syotaLuku(false);

        } else {
            osoittaja = syotaLuku(false);
            System.out.print("/");
            nimittaja = syotaLuku(false);
        }
    }

    private void tilastot() {
        System.out.println(hallinta.tilastot());
    }
}
