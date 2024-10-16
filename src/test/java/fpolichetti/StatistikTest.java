package fpolichetti;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatistikTest {

    @Test
    public void testInitialeStatistik() {
        Statistik statistik = new Statistik();
        assertEquals(0, statistik.getRichtigeVersuche());
        assertEquals(0, statistik.getFalscheVersuche());
    }

    @Test
    public void testAktualisiereRichtig() {
        Statistik statistik = new Statistik();
        statistik.aktualisiere(true);
        assertEquals(1, statistik.getRichtigeVersuche());
        assertEquals(0, statistik.getFalscheVersuche());
    }

    @Test
    public void testAktualisiereFalsch() {
        Statistik statistik = new Statistik();
        statistik.aktualisiere(false);
        assertEquals(0, statistik.getRichtigeVersuche());
        assertEquals(1, statistik.getFalscheVersuche());
    }

    @Test
    public void testGetStatistik() {
        Statistik statistik = new Statistik();
        statistik.aktualisiere(true);
        statistik.aktualisiere(false);
        String erwarteteAusgabe = "Statistik:\nInsgesamt: 2\nRichtig: 1\nFalsch: 1";
        assertEquals(erwarteteAusgabe, statistik.getStatistik());
    }
}
