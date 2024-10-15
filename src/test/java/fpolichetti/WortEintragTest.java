package fpolichetti;

import org.junit.Test;
import static org.junit.Assert.*;

public class WortEintragTest {

    @Test
    public void testKonstruktorMitGueltigenWerten() {
        WortEintrag eintrag = new WortEintrag("Hund", "http://example.com/hund.jpg");
        assertEquals("Hund", eintrag.getWort());
        assertEquals("https://example.com/hund.jpg", eintrag.getBildUrl());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKonstruktorMitUngueltigemWort() {
        new WortEintrag(null, "https://example.com/hund.jpg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKonstruktorMitUngueltigerUrl() {
        new WortEintrag("Hund", "ungültige_url");
    }
}
