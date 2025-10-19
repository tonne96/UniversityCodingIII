import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdministrationTest {

    private final Administration administration = new Administration();
    private final Audio audio = new Audio();

    @Test
    void addToListNull() {
        assertFalse(administration.addToList(null));
    }

    @Test
    void addToListPlusOne() {
        int list1size  = administration.getAdministrationList().size();

        administration.addToList(audio);

        ArrayList<Audio> list2 = administration.getAdministrationList();

        assertEquals(list1size + 1, list2.size());
    }

    @Test
    void listItems() {
        fail();
    }


    @Test
    void removeNull() {
        assertFalse(administration.remove(null));
    }

    @Test
    void removeEmptyList() {
        assertFalse(administration.remove(audio));
    }


    @Test
    void remove() {
        administration.addToList(audio);
        int list1size = administration.getAdministrationList().size();

        administration.remove(audio);

        ArrayList<Audio> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }

    @Test
    void updateAccessCounter() {

        int audio1counter = audio.getAccessCount();

        administration.addToList(audio);
        administration.update(audio, "Test");

        int audio2counter = audio.getAccessCount();
        assertEquals(audio1counter + 1, audio2counter);
    }

    @Test
    void updateNameIsEmpty() {
        assertFalse(administration.update(audio, ""));
    }

    @Test
    void updateName() {
        String oldTitle = "old title";
        audio.setTitle(oldTitle);

        String newTitle = "new title";
        administration.addToList(audio);
        administration.update(audio, newTitle);

        assertEquals(newTitle, audio.getTitle());
    }

}