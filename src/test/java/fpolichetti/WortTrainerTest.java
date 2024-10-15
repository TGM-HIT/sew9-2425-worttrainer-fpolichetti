package fpolichetti;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class WortTrainerTest {

    @Test
    public void testKonstruktorMitGueltigenEintraegen() {
        WortEintrag eintrag1 = new WortEintrag("Hund", "http://example.com/hund.jpg");
        WortEintrag eintrag2 = new WortEintrag("Katze", "http://example.com/katze.jpg");
        WortTrainer trainer = new WortTrainer();
        trainer.setEintraege(Arrays.asList(eintrag1, eintrag2));

        assertEquals(2, trainer.getEintraege().size());
    }

    @Test
    public void testSetEintraegeMitNull() {
        WortTrainer trainer = new WortTrainer();
        try {
            trainer.setEintraege(null);
            fail("Erwartete eine IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertEquals("Die Liste der Worteinträge darf nicht null sein.", e.getMessage());
        }
    }

    @Test
    public void testAddEintrag() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag eintrag = new WortEintrag("Vogel", "http://example.com/vogel.jpg");
        trainer.addEintrag(eintrag);

        assertTrue(trainer.getEintraege().contains(eintrag));
    }

    @Test
    public void testRemoveEintrag() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag eintrag = new WortEintrag("Fisch", "http://example.com/fisch.jpg");
        trainer.addEintrag(eintrag);
        trainer.removeEintrag(eintrag);

        assertFalse(trainer.getEintraege().contains(eintrag));
    }

    @Test
    public void testGetAuswahl() {
        WortTrainer trainer = new WortTrainer();
        WortEintrag eintrag = new WortEintrag("Hund", "http://example.com/hund.jpg");
        trainer.setAuswahl(eintrag);

        assertEquals(eintrag, trainer.getAuswahl());
    }
}
