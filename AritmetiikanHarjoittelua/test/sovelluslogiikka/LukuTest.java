/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

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
public class LukuTest {
    
    public LukuTest() {
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
    public void konstruktoriAsettaaLuvutOikein() {
        Luku luku = new Luku(3,2);
        String tulostus = luku.toString();
        assertEquals("3/2", tulostus);
    }
    
    @Test
    public void lukuTietaaOlevansaKokonaisluku() {
        Luku luku = new Luku(6,2);
        String tulostus = luku.toString();
        assertEquals("3", tulostus);
    }
    
    @Test
    public void nollallaNimittajassa() {
        Luku luku = new Luku(5,0);
        assertEquals("ei määritelty", luku.toString());
    }
    
    @Test
    public void vertailuOikein() {
        Luku eka = new Luku(14,7);
        Luku toka = new Luku(6,3);
        assertEquals(true, eka.equals(toka));
    }
}