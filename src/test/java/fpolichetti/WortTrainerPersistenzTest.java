package fpolichetti;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class WortTrainerPersistenzTest {

    @Test
    public void testSpeichereUndLadeDaten() {
        WortTrainer trainer = new WortTrainer();
        trainer.setPfad("test_worttrainer.json");

        WortEintrag eintrag = new WortEintrag("Hund", "http://example.com/hund.jpg");
        trainer.addEintrag(eintrag);
        trainer.getStatistik().aktualisiere(true);

        trainer.speichereDaten();

        WortTrainer geladenerTrainer = new WortTrainer();
        geladenerTrainer.setPfad("test_worttrainer.json");
        geladenerTrainer.ladeDaten();

        assertEquals(1, geladenerTrainer.getEintraege().size());
        assertEquals("Hund", geladenerTrainer.getEintraege().get(0).getWort());
        assertEquals(1, geladenerTrainer.getStatistik().getRichtigeVersuche());

        File file = new File("test_worttrainer.json");
        if (file.exists()) {
            file.delete();
        }
    }
}
