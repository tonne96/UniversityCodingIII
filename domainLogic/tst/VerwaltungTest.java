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
        String[] list = verwaltung.auflisten();

        verwaltung.einfuegen(audio);

        String[] list2 = verwaltung.auflisten();
        assertEquals(list.length + 1, list2.length);
    }

    void einfuegenInListe() {

    }

    @org.junit.jupiter.api.Test
    void auflisten() {
    }

    @org.junit.jupiter.api.Test
    void entfernen() {
    }

    @org.junit.jupiter.api.Test
    void aendern() {
    }

}