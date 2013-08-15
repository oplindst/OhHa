package sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class HallintaTest {
    
    Hallinta hallinta;
    
    public HallintaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hallinta = new Hallinta(100, true, true, true, "+-*/");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tilastotPitavatKirjaaOikein() {
        hallinta.oikein();
        hallinta.vaarin();
        assertEquals("1 oikein, 1 väärin", hallinta.tilastot());
    }
    
}