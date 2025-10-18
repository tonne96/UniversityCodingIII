import java.util.ArrayList;

public class Verwaltung {

    private final ArrayList<Audio> verwaltungsListe = new ArrayList<>();

    // getter und setter

    public ArrayList<Audio> getVerwaltungsListe() {
        return verwaltungsListe;
    }

    public boolean einfuegen(Audio audio) {
        // check audio = null
        if (audio == null) return false;
        // audio hinzufügen und pruefen ob Laenge liste + 1
        //int ursprungListenLaenge = verwaltungsListe.size();
        verwaltungsListe.add(audio);
        // if (verwaltungsListe.size() > ursprungListenLaenge) return true;
        return false;
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
