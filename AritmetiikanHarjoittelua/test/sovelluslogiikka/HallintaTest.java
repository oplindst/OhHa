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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tilastotPitavatKirjaaOikein() {
        try {
            hallinta = new Hallinta(10, 100, 200, true, true, true, true, "+-*/", false);
            hallinta.oikein(null);
            hallinta.vaarin(null);
            assertEquals("1 oikein, 1 väärin.", hallinta.tilastot());
        } catch (Exception e) {
        }
    }
    
    @Test
    public void eiLaskutoimituksia() {
        try {
            hallinta = new Hallinta(10, 100, 200, true, true, true, true, "", false);
            assertEquals("1", "2");
        } catch (Exception e) {
            assertEquals("", "");
        }
    }
    
    @Test
    public void liikaaKysymyksia() {
        try {
            hallinta = new Hallinta(21, 100, 200, true, true, true, true, "", false);
            assertEquals("1", "2");
        } catch (Exception e) {
            assertEquals("", "");
        }
    }
    
    @Test
    public void liianVahanKysymyksia() {
        try {
            hallinta = new Hallinta(0, 100, 200, true, true, true, true, "", false);
            assertEquals("1", "2");
        } catch (Exception e) {
            assertEquals("", "");
        }
    }
    
    @Test
    public void tarkistaaOikein() throws Exception{
        hallinta = new Hallinta(5, 100, 200, true, true, true, true, "+-/*", false);
        assertEquals(true, hallinta.tarkista(8, 30, new Luku(4, 15)));
        assertEquals(true, hallinta.tarkista(-9, 3772, new Luku(9 ,-3772)));
    }
    
    @Test
    public void tarkistaaVaarin() throws Exception {
        hallinta = new Hallinta(5, 100, 200, true, true, true, true, "+-/*", false);
        assertEquals(false, hallinta.tarkista(7, 5, new Luku(15 ,10)));
    }
    
    @Test
    public void toimiiPienillaLuvuilla() {
        try {
            hallinta = new Hallinta(20, 1, 1, true, true, true, true, "+-*/", false);
            assertEquals("1","1");
        }
        catch (Exception e) {
            assertEquals("2","1");
        }
    }
}