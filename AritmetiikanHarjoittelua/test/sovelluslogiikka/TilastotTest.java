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
public class TilastotTest {
    
    private Tilastot tilastot;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tilastot = new Tilastot();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sujuuEiVastattuVielä() {
        assertEquals(true, tilastot.plusSujuu());
        assertEquals(true, tilastot.miinusSujuu());
        assertEquals(true, tilastot.kertoSujuu());
        assertEquals(true, tilastot.jakoSujuu());
    }
    
    @Test
    public void sujuuJuuriJaJuuri() {
        for (int i = 0; i < 16; i++) {
            tilastot.plusOikein();
        }
        for (int i = 0; i < 4; i++) {
            tilastot.plusVaarin();
        }
        assertEquals(true, tilastot.plusSujuu());
    }
    
    @Test
    public void eiSujuJosNollaOikeinJaVaaria() {
        tilastot.plusVaarin();
        tilastot.miinusVaarin();
        tilastot.kertoVaarin();
        tilastot.jakoVaarin();
        assertEquals(false, tilastot.plusSujuu());
        assertEquals(false, tilastot.miinusSujuu());
        assertEquals(false, tilastot.kertoSujuu());
        assertEquals(false, tilastot.jakoSujuu());
    }
    
}