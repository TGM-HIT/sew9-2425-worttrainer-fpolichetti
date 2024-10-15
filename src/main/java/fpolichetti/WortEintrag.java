package fpolichetti;
/**
 * Die Klasse WortEintrag repräsentiert einen Datensatz mit Wort und zugehöriger Bild-URL.
 */
public class WortEintrag {
    private String wort;
    private String bildUrl;

    /**
     * Konstruktor für WortEintrag.
     *
     * @param wort    Das zugeordnete Wort.
     * @param bildUrl Die URL des zugehörigen Bildes.
     * @throws IllegalArgumentException Wenn Wort oder URL ungültig sind.
     */
    public WortEintrag(String wort, String bildUrl) {
        setWort(wort);
        setBildUrl(bildUrl);
    }

    /**
     * Setzt das Wort.
     *
     * @param wort Das Wort.
     * @throws IllegalArgumentException Wenn das Wort ungültig ist.
     */
    public void setWort(String wort) {
        if (!checkWort(wort)) {
            throw new IllegalArgumentException("Das Wort darf nicht null oder leer sein.");
        }
        this.wort = wort;
    }

    /**
     * Überprüft, ob das gegebene Wort gültig ist.
     *
     * @param wort Das zu überprüfende Wort.
     * @return true, wenn gültig, sonst false.
     */
    public boolean checkWort(String wort) {
        return wort != null && !wort.trim().isEmpty();
    }

    /**
     * Setzt die Bild-URL.
     *
     * @param bildUrl Die Bild-URL.
     * @throws IllegalArgumentException Wenn die URL ungültig ist.
     */
    public void setBildUrl(String bildUrl) {
        if (!checkBildUrl(bildUrl)) {
            throw new IllegalArgumentException("Die Bild-URL ist ungültig.");
        }
        this.bildUrl = bildUrl;
    }

    /**
     * Überprüft, ob die gegebene Bild-URL gültig ist.
     *
     * @param bildUrl Die zu überprüfende URL.
     * @return true, wenn gültig, sonst false.
     */
    public boolean checkBildUrl(String bildUrl) {
        try {
            new java.net.URL(bildUrl).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gibt das Wort zurück.
     *
     * @return Das Wort.
     */
    public String getWort() {
        return wort;
    }

    /**
     * Gibt die Bild-URL zurück.
     *
     * @return Die Bild-URL.
     */
    public String getBildUrl() {
        return bildUrl;
    }

    @Override
    public String toString() {
        return "WortEintrag [wort=" + wort + ", bildUrl=" + bildUrl + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WortEintrag other = (WortEintrag) obj;
        return wort.equals(other.wort) && bildUrl.equals(other.bildUrl);
    }
}
