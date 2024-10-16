package fpolichetti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

/**
 * Die Klasse WortTrainer verwaltet die Liste der Worteinträge und die aktuelle Auswahl.
 */
public class WortTrainer {
    private List<WortEintrag> eintraege;
    private WortEintrag auswahl;
    private Statistik statistik;
    private String pfad;

    /**
     * Konstruktor für WortTrainer.
     */
    public WortTrainer() {
        eintraege = new ArrayList<>();
        auswahl = null;
        statistik = new Statistik();
        pfad = "worttrainer.json";
    }

    /**
     * Gibt die Statistik zurück.
     *
     * @return Die Statistik.
     */
    public Statistik getStatistik() {
        return statistik;
    }

    /**
     * Gibt die Liste der Worteinträge zurück.
     *
     * @return Die Liste der Worteinträge.
     */
    public List<WortEintrag> getEintraege() {
        return new ArrayList<>(eintraege);
    }

    /**
     * Setzt die Liste der Worteinträge.
     *
     * @param eintraege Die neue Liste der Worteinträge.
     */
    public void setEintraege(List<WortEintrag> eintraege) {
        if (eintraege == null) {
            throw new IllegalArgumentException("Die Liste der Worteinträge darf nicht null sein.");
        }
        this.eintraege = new ArrayList<>(eintraege);
    }

    /**
     * Wählt einen zufälligen Worteintrag aus.
     *
     * @return Der zufällig ausgewählte Worteintrag.
     */
    public WortEintrag waehleZufaelligenEintrag() {
        if (eintraege.isEmpty()) {
            auswahl = null;
            return null;
        }
        Random rand = new Random();
        int index = rand.nextInt(eintraege.size());
        auswahl = eintraege.get(index);
        return auswahl;
    }

    /**
     * Wählt einen spezifischen Worteintrag anhand des Index aus.
     *
     * @param index Der Index des Worteintrags.
     * @return Der ausgewählte Worteintrag.
     */
    public WortEintrag waehleEintrag(int index) {
        if (index < 0 || index >= eintraege.size()) {
            throw new IndexOutOfBoundsException("Ungültiger Index.");
        }
        auswahl = eintraege.get(index);
        return auswahl;
    }

    /**
     * Fügt einen Worteintrag zur Liste hinzu.
     *
     * @param eintrag Der hinzuzufügende Worteintrag.
     */
    public void addEintrag(WortEintrag eintrag) {
        if (eintrag == null) {
            throw new IllegalArgumentException("Der Worteintrag darf nicht null sein.");
        }
        eintraege.add(eintrag);
    }

    /**
     * Entfernt einen Worteintrag aus der Liste.
     *
     * @param eintrag Der zu entfernende Worteintrag.
     */
    public void removeEintrag(WortEintrag eintrag) {
        eintraege.remove(eintrag);
    }

    /**
     * Gibt den aktuell ausgewählten Worteintrag zurück.
     *
     * @return Der aktuell ausgewählte Worteintrag.
     */
    public WortEintrag getAuswahl() {
        return auswahl;
    }

    /**
     * Setzt den aktuell ausgewählten Worteintrag.
     *
     * @param eintrag Der auszuwählende Worteintrag.
     */
    public void setAuswahl(WortEintrag eintrag) {
        this.auswahl = eintrag;
    }

    /**
     * Setzt den Pfad für die Persistenzdatei.
     *
     * @param pfad Der Dateipfad.
     */
    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    /**
     * Gibt den Pfad der Persistenzdatei zurück.
     *
     * @return Der Dateipfad.
     */
    public String getPfad() {
        return pfad;
    }

    /**
     * Speichert die Daten in eine JSON-Datei.
     */
    public void speichereDaten() {
        try (FileWriter writer = new FileWriter(pfad)) {
            Gson gson = new Gson();
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt die Daten aus einer JSON-Datei.
     */
    public void ladeDaten() {
        try (FileReader reader = new FileReader(pfad)) {
            Gson gson = new Gson();
            WortTrainer geladen = gson.fromJson(reader, WortTrainer.class);
            this.eintraege = geladen.eintraege;
            this.statistik = geladen.statistik;
            this.auswahl = geladen.auswahl;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Löscht die Persistenzdatei.
     */
    public void loeschePersistenz() {
        java.io.File file = new java.io.File(pfad);
        if (file.exists()) {
            file.delete();
        }
    }
}
