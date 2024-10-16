package fpolichetti;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die Klasse Controller.
 */
public class ControllerTest {

    /**
     * Testet die Initialisierung des Controllers.
     */
    @Test
    void testControllerInitialisierung() {
        WortTrainer trainer = new WortTrainer();
        View view = new View();
        Controller controller = new Controller(trainer, view);

        assertNotNull(controller);
    }
}
