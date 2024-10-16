package fpolichetti;

import javax.swing.ImageIcon;
import java.net.URL;

/**
 * Die Klasse Controller verbindet das Modell (WortTrainer) mit der View.
 */
public class Controller {
    private WortTrainer wortTrainer;
    private View view;

    public Controller(WortTrainer wortTrainer, View view) {
        this.wortTrainer = wortTrainer;
        this.view = view;
    }

    /**
     * Startet die Anwendung.
     */
    public void starte() {
        wortTrainer.ladeDaten();

        while (true) {
            WortEintrag aktuellerEintrag = wortTrainer.waehleZufaelligenEintrag();
            if (aktuellerEintrag == null) {
                view.zeigeNachricht("Keine Worteinträge verfügbar.");
                break;
            }

            String statistik = wortTrainer.getStatistik().getStatistik();

            ImageIcon image = null;
            try {
                URL url = new URL(aktuellerEintrag.getBildUrl());
                image = new ImageIcon(url);
            } catch (Exception e) {
                view.zeigeNachricht("Bild konnte nicht geladen werden: " + e.getMessage());
                break;
            }

            String eingabe = view.holeBenutzereingabe(statistik, image);

            if (eingabe == null || eingabe.trim().isEmpty()) {
                break;
            }

            boolean korrekt = aktuellerEintrag.getWort().equalsIgnoreCase(eingabe.trim());
            wortTrainer.getStatistik().aktualisiere(korrekt);

            if (korrekt) {
                view.zeigeNachricht("Richtig!");
            } else {
                view.zeigeNachricht("Falsch! Versuche es noch einmal.");
            }
        }

        wortTrainer.speichereDaten();
        view.zeigeNachricht("Anwendung beendet. Daten wurden gespeichert.");
    }
}
