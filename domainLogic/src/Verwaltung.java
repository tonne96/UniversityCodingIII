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
        int startSize = verwaltungsListe.size();

        // Element hinzufügen
        verwaltungsListe.add(audio);

        // pruefen, ob Groesse +1
        return verwaltungsListe.size() == startSize + 1;
    }

    public void auflisten() {
        for (Audio audio: verwaltungsListe) {
            System.out.println(audio.toString());
        }
    }

    public boolean entfernen(Audio audio) {
        // Null‑Check
        if (audio == null) {
            return false;
        }

        int startSize = verwaltungsListe.size();
        // entfernen
        verwaltungsListe.remove(audio);


        return verwaltungsListe.size() == startSize - 1;
    }

    public boolean aendern(Audio audio) {
        return false;
    }

    public String toString() {
        return null;
    }
}
