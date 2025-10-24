import contract.MediaObjects;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AdministrationTest {

    @Test
    void addToListNull() {
        Administration administration = new Administration();
        assertFalse(administration.addToList(null));
    }

    @Test
    void addToListPlusOne() {
        Administration administration = new Administration();
        AudioImpl audio = new AudioImpl();
        int list1size  = administration.getAdministrationList().size();

        administration.addToList(audio);

        ArrayList<MediaObjects> list2 = administration.getAdministrationList();

        assertEquals(list1size + 1, list2.size());
    }

    @Test
    void listItemsReturnsList() {
        Administration administration = new Administration();

        List<MediaObjects> result = new ArrayList<>();

        administration.listItems();

        assertNotNull(result);
    }


    @Test
    void removeNull() {
        Administration administration = new Administration();

        assertFalse(administration.remove(null));
    }

    @Test
    void removeEmptyList() {
        Administration administration = new Administration();
        AudioImpl audio = new AudioImpl();

        assertFalse(administration.remove(audio));
    }


    @Test
    void removeListMinusOne() {
        Administration administration = new Administration();
        AudioImpl audio = new AudioImpl();

        administration.addToList(audio);
        int list1size = administration.getAdministrationList().size();

        administration.remove(audio);

        ArrayList<MediaObjects> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }


    @Test
    void updateNull() {
        Administration administration = new Administration();

        assertFalse(administration.update(null));
    }

    @Test
    void updateAccessCounter() {
        Administration administration = new Administration();
        AudioImpl audio = new AudioImpl();

        int mediaContentAccessCount1 = audio.getAccessCount();

        administration.update(audio);

        int mediaContentAccessCount2 = audio.getAccessCount();

        assertEquals(mediaContentAccessCount1 + 1, mediaContentAccessCount2);
    }


}