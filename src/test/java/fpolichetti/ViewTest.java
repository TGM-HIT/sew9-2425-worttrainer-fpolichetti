package fpolichetti;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.ImageIcon;

/**
 * Testklasse für die Klasse View.
 */
public class ViewTest {

    /**
     * Testet die Methode zeigeNachricht.
     */
    @Test
    void testZeigeNachricht() {
        View view = new View();
        String nachricht = "Hallo, Welt!";
        view.zeigeNachricht(nachricht);

        assertEquals(nachricht, view.getLetzteNachricht());
    }

    /**
     * Testet die Methode zeigeBild.
     */
    @Test
    void testZeigeBild() {
        View view = new View();
        String nachricht = "Bildanzeige";
        ImageIcon icon = new ImageIcon();

        view.zeigeBild(nachricht, icon);

        assertEquals(nachricht, view.getLetzteNachricht());
    }

    /**
     * Testet die Methode holeBenutzereingabe.
     */
    @Test
    void testHoleBenutzereingabe() {
        View view = new View();
        String nachricht = "Bitte geben Sie etwas ein:";
        String erwarteteEingabe = "Testeingabe";
        view.setTestEingabe(erwarteteEingabe);

        String eingabe = view.holeBenutzereingabe(nachricht, null);

        assertEquals(erwarteteEingabe, eingabe);
        assertEquals(nachricht, view.getLetzteNachricht());
    }
}
