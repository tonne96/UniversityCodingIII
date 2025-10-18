import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VerwaltungTest {

    @org.junit.jupiter.api.Test
    void einfuegenNull() {
        Verwaltung verwaltung = new Verwaltung();
        Audio audio = null;

        verwaltung.einfuegen(audio);
        boolean r = verwaltung.einfuegen(audio);
        assertEquals(false, r);
    }

    @org.junit.jupiter.api.Test
    void einfuegenPlusOne() {
        Verwaltung verwaltung = new Verwaltung();
        Audio audio = new Audio();
        int list1size  = verwaltung.getVerwaltungsListe().size();

        verwaltung.einfuegen(audio);

        ArrayList<Audio> list2 = verwaltung.getVerwaltungsListe();

        assertEquals(list1size + 1, list2.size());
    }

    @org.junit.jupiter.api.Test
    void einfuegenInListe() {
        fail();
    }

    @org.junit.jupiter.api.Test
    void auflisten() {
        fail();
    }

    @org.junit.jupiter.api.Test
    void entfernen() {
        fail();
    }

    @org.junit.jupiter.api.Test
    void aendern() {
        Verwaltung verwaltung = new Verwaltung();
        Audio audio = new Audio();
        int audio1counter = audio.getAccressCount();

        verwaltung.aendern(audio);

        int audio2counter = audio.getAccressCount();
        assertEquals(audio1counter + 1, audio2counter);
    }

}