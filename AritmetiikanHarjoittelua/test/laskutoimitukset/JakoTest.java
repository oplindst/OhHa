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
public class JakoTest {
    
    Jako jako;
    
    public JakoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void nayttaaKokonaisluvunOikein() {
        Luku eka = new Luku(6,1);
        Luku toka = new Luku(2,1);
        Luku tulos = jako.laske(eka, toka);
        assertEquals("3", tulos);
    }
}