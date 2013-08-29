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
    public void nolla() {
        Luku luku = new Luku(0, 42);
        assertEquals("0", luku.toString());
    }
    
    @Test
    public void nollaNimittajassa() {
        Luku luku = new Luku(5,0);
        assertEquals("ei määritelty", luku.toString());
    }
    
    @Test
    public void vertaileeKokonaislukujaOikein() {
        Luku eka = new Luku(14,7);
        Luku toka = new Luku(6,3);
        assertEquals(true, eka.equals(toka));
    }
    
    public void vertaileeMurtolukujaOikein() {
        Luku eka = new Luku(146, -4);
        Luku toka = new Luku(-584, 16);
        assertEquals(eka, toka);
        eka = new Luku(-4, 45);
        toka = new Luku(4, -45);
        assertEquals(eka, toka);
    }
    
    public void sieventaaKokonaisluvunOikein() {
        Luku luku = new Luku(1456, 728);
        luku.sievenna();
        assertEquals("2", luku);
    }
    
    public void sieventaaMurtoluvunOikein() {
        Luku luku = new Luku(2560, 300);
        luku.sievenna();
        assertEquals("128/15", luku);
    }
    
    
}