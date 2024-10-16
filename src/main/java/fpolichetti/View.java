package fpolichetti;

import javax.swing.JOptionPane;

/**
 * Die Klasse View verwaltet die Benutzeroberfläche mit JOptionPane.
 * Sie zeigt einfache Nachrichten an.
 */
public class View {

    /**
     * Die letzte angezeigte Nachricht.
     */
    private String letzteNachricht;

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
     * Gibt die zuletzt angezeigte Nachricht zurück.
     *
     * @return Die zuletzt angezeigte Nachricht.
     */
    public String getLetzteNachricht() {
        return letzteNachricht;
    }
}
