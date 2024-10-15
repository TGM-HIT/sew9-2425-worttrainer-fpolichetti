package fpolichetti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Die Klasse WortTrainer verwaltet die Liste der Worteinträge und die aktuelle Auswahl.
 */
public class WortTrainer {
    private List<WortEintrag> eintraege;
    private WortEintrag auswahl;

    /**
     * Konstruktor für WortTrainer.
     */
    public WortTrainer() {
        eintraege = new ArrayList<>();
        auswahl = null;
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
}
