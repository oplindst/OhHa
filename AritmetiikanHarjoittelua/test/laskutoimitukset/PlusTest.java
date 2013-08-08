/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutoimitukset;

import sovelluslogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author O-P
 */
public class PlusTest {
    
    Plus plus;
    
    public PlusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        plus = new Plus();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void laskeeKokonaislukujaOikein() {
        Luku eka = new Luku(1,1);
        Luku toka = new Luku(-1,1);
        Luku tulos = plus.laske(eka, toka);
        assertEquals("0", tulos.toString());
    }
    
    public void kayttaaNollaaOikein() {
        Luku eka = new Luku(3,2);
        Luku toka = new Luku(0,2);
        Luku tulos = plus.laske(eka, toka);
        assertEquals("3/2", tulos.toString());
    }
}