package fpolichetti;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testklasse für die Klasse View.
 */
public class ViewTest {

    /**
     * Testet die Methode zeigeNachricht.
     */
    @Test
    public void testZeigeNachricht() {
        View view = new View();
        String nachricht = "Hallo, Welt!";
        view.zeigeNachricht(nachricht);

        assertEquals(nachricht, view.getLetzteNachricht());
    }
}
