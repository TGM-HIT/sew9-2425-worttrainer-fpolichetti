package fpolichetti;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Die Klasse WortTrainer verwaltet die WortEintraege und die Statistik.
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
        this.eintraege = new ArrayList<>();
        this.statistik = new Statistik();
        this.pfad = "worttrainer.json";
    }

    public List<WortEintrag> getEintraege() {
        return eintraege;
    }

    public void setEintraege(List<WortEintrag> eintraege) {
        if (eintraege == null) {
            throw new IllegalArgumentException("Die Liste der Worteinträge darf nicht null sein.");
        }
        this.eintraege = eintraege;
    }

    public WortEintrag getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(WortEintrag auswahl) {
        this.auswahl = auswahl;
    }

    public Statistik getStatistik() {
        return statistik;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    public String getPfad() {
        return pfad;
    }

    /**
     * Fügt einen neuen WortEintrag hinzu.
     *
     * @param eintrag Der hinzuzufügende WortEintrag.
     */
    public void addEintrag(WortEintrag eintrag) {
        if (eintrag == null) {
            throw new IllegalArgumentException("Der Worteintrag darf nicht null sein.");
        }
        eintraege.add(eintrag);
    }

    /**
     * Entfernt einen vorhandenen WortEintrag.
     *
     * @param eintrag Der zu entfernende WortEintrag.
     */
    public void removeEintrag(WortEintrag eintrag) {
        eintraege.remove(eintrag);
    }

    /**
     * Wählt zufällig einen WortEintrag aus.
     *
     * @return Der ausgewählte WortEintrag oder null, wenn keine Einträge vorhanden sind.
     */
    public WortEintrag waehleZufaelligenEintrag() {
        if (eintraege.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(eintraege.size());
        auswahl = eintraege.get(index);
        return auswahl;
    }

    /**
     * Speichert die Daten in eine JSON-Datei.
     */
    public void speichereDaten() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(pfad)) {
            gson.toJson(this, writer);
            System.out.println("Daten erfolgreich gespeichert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ladeDaten() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(pfad)) {
            WortTrainer geladen = gson.fromJson(reader, WortTrainer.class);
            if (geladen != null) {
                this.eintraege = geladen.eintraege != null ? geladen.eintraege : new ArrayList<>();
                this.statistik = geladen.statistik != null ? geladen.statistik : new Statistik();
            } else {
                this.eintraege = new ArrayList<>();
                this.statistik = new Statistik();
            }
            System.out.println("Daten erfolgreich geladen.");
        } catch (FileNotFoundException e) {
            System.out.println("Keine vorhandenen Daten gefunden. Neue Daten werden erstellt.");
            this.eintraege = new ArrayList<>();
            this.statistik = new Statistik();
        } catch (com.google.gson.JsonSyntaxException e) {
            System.out.println("Die Daten konnten nicht geladen werden (ungültiges Format). Neue Daten werden erstellt.");
            this.eintraege = new ArrayList<>();
            this.statistik = new Statistik();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Bewertet die Benutzereingabe und aktualisiert die Statistik.
     *
     * @param eingabe Die vom Benutzer eingegebene Antwort.
     * @return True, wenn die Eingabe korrekt ist; sonst false.
     */
    public boolean rateWort(String eingabe) {
        if (auswahl == null) {
            throw new IllegalStateException("Kein Wort-Eintrag ausgewählt.");
        }
        boolean korrekt = auswahl.getWort().equalsIgnoreCase(eingabe.trim());
        statistik.aktualisiere(korrekt);
        return korrekt;
    }
}