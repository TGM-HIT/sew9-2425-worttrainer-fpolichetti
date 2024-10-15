package fpolichetti;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class WortEintragTest {

    @Test
    public void testKonstruktorMitGueltigenWerten() {
        WortEintrag eintrag = new WortEintrag("Hund", "https://example.com/hund.jpg");
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
