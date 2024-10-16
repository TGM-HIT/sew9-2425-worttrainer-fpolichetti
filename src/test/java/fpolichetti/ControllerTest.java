package fpolichetti;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testklasse für die Klasse Controller.
 */
public class ControllerTest {

    /**
     * Testet die Initialisierung des Controllers.
     */
    @Test
    public void testControllerInitialisierung() {
        WortTrainer trainer = new WortTrainer();
        View view = new View();
        Controller controller = new Controller(trainer, view);

        assertNotNull(controller);
    }
}
