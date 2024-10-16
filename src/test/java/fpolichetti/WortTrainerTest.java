package fpolichetti;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class WortTrainerTest {

    @Test
    void testKonstruktorMitGueltigenEintraegen() {
        WortEintrag eintrag1 = new WortEintrag("Hund", "http://example.com/hund.jpg");
        WortEintrag eintrag2 = new WortEintrag("Katze", "http://example.com/katze.jpg");
        WortTrainer trainer = new WortTrainer();
        trainer.setEintraege(Arrays.asList(eintrag1, eintrag2));

        assertEquals(2, trainer.getEintraege().size());
    }

    @Test
    void testSetEintraegeMitNull() {
        WortTrainer trainer = new WortTrainer();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            trainer.setEintraege(null);
        });
        assertEquals("Die Liste der Worteinträge darf nicht null sein.", exception.getMessage());
    }

    @Test
    void testAddEintrag() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag eintrag = new WortEintrag("Vogel", "http://example.com/vogel.jpg");
        trainer.addEintrag(eintrag);

        assertTrue(trainer.getEintraege().contains(eintrag));
    }

    @Test
    void testRemoveEintrag() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag eintrag = new WortEintrag("Fisch", "http://example.com/fisch.jpg");
        trainer.addEintrag(eintrag);
        trainer.removeEintrag(eintrag);

        assertFalse(trainer.getEintraege().contains(eintrag));
    }

    @Test
    void testGetAuswahl() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag eintrag = new WortEintrag("Hund", "http://example.com/hund.jpg");
        trainer.setAuswahl(eintrag);

        assertEquals(eintrag, trainer.getAuswahl());
    }
}
