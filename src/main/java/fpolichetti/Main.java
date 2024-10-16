package fpolichetti;

/**
 * Die Hauptklasse zum Starten der Anwendung.
 */
public class Main {
    /**
     * Der Einstiegspunkt der Anwendung.
     *
     * @param args Die Befehlszeilenargumente.
     */
    public static void main(String[] args) {
        WortTrainer trainer = new WortTrainer();
        trainer.ladeDaten();

        if (trainer.getEintraege() == null || trainer.getEintraege().isEmpty()) {
            trainer.addEintrag(new WortEintrag("Serbien", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Serbia_in_Europe_%28claimed_hatched%29.svg/324px-Serbia_in_Europe_%28claimed_hatched%29.svg.png"));
            trainer.addEintrag(new WortEintrag("Bosnien", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Bosnia_and_Herzegovina_in_Europe.svg/324px-Bosnia_and_Herzegovina_in_Europe.svg.png"));
            System.out.println("Standard-Worteinträge wurden hinzugefügt.");
        }

        View view = new View();
        Controller controller = new Controller(trainer, view);
        controller.starte();
    }
}
