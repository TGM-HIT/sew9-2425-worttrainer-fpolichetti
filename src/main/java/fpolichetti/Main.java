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

        if (trainer.getEintraege().isEmpty()) {
            trainer.addEintrag(new WortEintrag("Hund", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwlg-OPbpkT7zE03pRLT9SoDe0kntjdv8W_w&s"));
            trainer.addEintrag(new WortEintrag("Katze", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Hauskatze_langhaar.jpg/1200px-Hauskatze_langhaar.jpg"));
            trainer.addEintrag(new WortEintrag("Serbien", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Serbia_in_Europe_%28claimed_hatched%29.svg/324px-Serbia_in_Europe_%28claimed_hatched%29.svg.png"));
            trainer.addEintrag(new WortEintrag("Serbien", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Kosovo_in_Europe_%28de-facto%29.svg/330px-Kosovo_in_Europe_%28de-facto%29.svg.png"));
            trainer.addEintrag(new WortEintrag("Serbien", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Bosnia_and_Herzegovina_Political.png/300px-Bosnia_and_Herzegovina_Political.png"));
        }

        View view = new View();
        Controller controller = new Controller(trainer, view);
        controller.starte();
    }
}
