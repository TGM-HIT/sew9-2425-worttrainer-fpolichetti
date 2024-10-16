package fpolichetti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WortEintragTest {

    @Test
    void testKonstruktorMitGueltigenWerten() {
        WortEintrag eintrag = new WortEintrag("Hund", "https://example.com/hund.jpg");
        assertEquals("Hund", eintrag.getWort());
        assertEquals("https://example.com/hund.jpg", eintrag.getBildUrl());
    }

    @Test
    void testKonstruktorMitUngueltigemWort() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WortEintrag(null, "https://example.com/hund.jpg");
        });
        assertEquals("Das Wort darf nicht null oder leer sein.", exception.getMessage());
    }

    @Test
    void testKonstruktorMitUngueltigerUrl() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WortEintrag("Hund", "ungültige_url");
        });
        assertEquals("Die Bild-URL ist ungültig.", exception.getMessage());
    }
}
