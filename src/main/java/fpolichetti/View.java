package fpolichetti;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Die Klasse View verwaltet die Benutzeroberfläche mit JOptionPane.
 * Sie zeigt Nachrichten und Bilder an und holt Benutzereingaben.
 */
public class View {
    private String letzteNachricht;
    private String letzteEingabe;
    private boolean testModus = false;
    private String testEingabe;

    /**
     * Zeigt eine Nachricht an.
     *
     * @param nachricht Die anzuzeigende Nachricht.
     */
    public void zeigeNachricht(String nachricht) {
        this.letzteNachricht = nachricht;
        JOptionPane.showMessageDialog(null, nachricht);
    }

    /**
     * Zeigt eine Nachricht mit einem Bild an.
     *
     * @param nachricht Die anzuzeigende Nachricht.
     * @param icon      Das anzuzeigende Bild.
     */
    public void zeigeBild(String nachricht, ImageIcon icon) {
        this.letzteNachricht = nachricht;
        JOptionPane.showMessageDialog(null, nachricht, "Bildanzeige", JOptionPane.PLAIN_MESSAGE, icon);
    }

    /**
     * Holt eine Benutzereingabe.
     *
     * @param nachricht Die Eingabeaufforderung.
     * @param icon      Das anzuzeigende Bild.
     * @return Die Benutzereingabe.
     */
    public String holeBenutzereingabe(String nachricht, ImageIcon icon) {
        this.letzteNachricht = nachricht;
        if (testModus) {
            this.letzteEingabe = testEingabe;
        } else {
            this.letzteEingabe = (String) JOptionPane.showInputDialog(null, nachricht, "Eingabe",
                    JOptionPane.PLAIN_MESSAGE, icon, null, "");
        }
        return letzteEingabe;
    }

    /**
     * Setzt die vordefinierte Eingabe für den Testmodus.
     *
     * @param eingabe Die vordefinierte Eingabe.
     */
    public void setTestEingabe(String eingabe) {
        this.testEingabe = eingabe;
        this.testModus = true;
    }

    /**
     * Gibt die zuletzt angezeigte Nachricht zurück.
     *
     * @return Die zuletzt angezeigte Nachricht.
     */
    public String getLetzteNachricht() {
        return letzteNachricht;
    }

    /**
     * Gibt die letzte Benutzereingabe zurück.
     *
     * @return Die letzte Benutzereingabe.
     */
    public String getLetzteEingabe() {
        return letzteEingabe;
    }
}
