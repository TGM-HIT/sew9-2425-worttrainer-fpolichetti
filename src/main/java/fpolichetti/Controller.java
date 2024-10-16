package fpolichetti;

import javax.swing.ImageIcon;
import java.net.URL;

/**
 * Die Klasse Controller verbindet das Modell (WortTrainer) mit der View.
 */
public class Controller {
    /**
     * Das Modell, das die Daten verwaltet.
     */
    private WortTrainer wortTrainer;

    /**
     * Die View zur Interaktion mit dem Benutzer.
     */
    private View view;

    /**
     * Konstruktor für Controller.
     *
     * @param wortTrainer Das Modell.
     * @param view        Die View.
     */
    public Controller(WortTrainer wortTrainer, View view) {
        this.wortTrainer = wortTrainer;
        this.view = view;
    }
}
