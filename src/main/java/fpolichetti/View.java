package fpolichetti;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Die Klasse View verwaltet die Benutzeroberfläche mit JOptionPane.
 * Sie zeigt Nachrichten und Bilder an.
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
     * Gibt die zuletzt angezeigte Nachricht zurück.
     *
     * @return Die zuletzt angezeigte Nachricht.
     */
    public String getLetzteNachricht() {
        return letzteNachricht;
    }
}
