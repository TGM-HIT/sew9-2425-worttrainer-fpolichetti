package fpolichetti;

/**
 * Die Klasse Statistik verwaltet die Statistik der richtigen und falschen Versuche.
 */
public class Statistik {
    private int richtigeVersuche;
    private int falscheVersuche;

    /**
     * Konstruktor für Statistik.
     */
    public Statistik() {
        this.richtigeVersuche = 0;
        this.falscheVersuche = 0;
    }

    /**
     * Konstruktor für Statistik mit vorgegebenen Werten.
     *
     * @param richtigeVersuche Anzahl der richtigen Versuche.
     * @param falscheVersuche  Anzahl der falschen Versuche.
     */
    public Statistik(int richtigeVersuche, int falscheVersuche) {
        this.richtigeVersuche = richtigeVersuche;
        this.falscheVersuche = falscheVersuche;
    }

    /**
     * Gibt die Anzahl der richtigen Versuche zurück.
     *
     * @return Anzahl der richtigen Versuche.
     */
    public int getRichtigeVersuche() {
        return richtigeVersuche;
    }

    /**
     * Gibt die Anzahl der falschen Versuche zurück.
     *
     * @return Anzahl der falschen Versuche.
     */
    public int getFalscheVersuche() {
        return falscheVersuche;
    }

    /**
     * Aktualisiert die Statistik basierend auf dem Ergebnis.
     *
     * @param korrekt true, wenn der Versuch korrekt war, sonst false.
     */
    public void aktualisiere(boolean korrekt) {
        if (korrekt) {
            richtigeVersuche++;
        } else {
            falscheVersuche++;
        }
    }

    /**
     * Gibt die Statistik als formatierte Zeichenkette zurück.
     *
     * @return Die Statistik.
     */
    public String getStatistik() {
        int gesamtVersuche = richtigeVersuche + falscheVersuche;
        return String.format("Statistik:\nInsgesamt: %d\nRichtig: %d\nFalsch: %d",
                gesamtVersuche, richtigeVersuche, falscheVersuche);
    }
}
