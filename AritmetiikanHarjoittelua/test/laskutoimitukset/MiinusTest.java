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
public class MiinusTest {
    
    Miinus miinus;
    
    public MiinusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        miinus = new Miinus();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void vahentaaNegatiivisiaLukujaOikein() {
        Luku eka = new Luku(10,1);
        Luku toka = new Luku(-55,1);
        Luku tulos = miinus.laske(eka, toka);
        assertEquals("65", tulos.toString());
    }
}