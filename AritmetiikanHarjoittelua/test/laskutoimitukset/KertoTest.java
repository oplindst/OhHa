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
public class KertoTest {
    
    Kerto kerto;
    
    public KertoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kerto = new Kerto();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void nollallaKertominen() {
        Luku eka = new Luku(4,1);
        Luku toka = new Luku(0,1);
        assertEquals("0", kerto.laske(eka, toka).toString());
    }
    
}