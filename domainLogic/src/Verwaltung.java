import java.util.ArrayList;

public class Verwaltung {

    private final ArrayList<Audio> verwaltungsListe = new ArrayList<>();

    // getter und setter

    public ArrayList<Audio> getVerwaltungsListe() {
        return verwaltungsListe;
    }

    public boolean einfuegen(Audio audio) {
        // Null‑Check
        if (audio == null) {
            return false;
        }

        // aktuelle Groese merken
        int anfangsGroesse = verwaltungsListe.size();

        // Element hinzufügen
        verwaltungsListe.add(audio);

        // pruefen, ob Groesse +1
        return verwaltungsListe.size() == anfangsGroesse + 1;
    }

    public void auflisten() {
        for (Audio audio: verwaltungsListe) {
            System.out.println(audio.toString());
        }
    }

    public boolean entfernen(Audio audio) {
        return false;
    }

    public boolean aendern(Audio audio) {
        return false;
    }

    public String toString() {
        return null;
    }
}
