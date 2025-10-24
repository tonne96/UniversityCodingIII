import contract.Audio;
import contract.MediaContent;
import contract.MediaObjects;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdministrationTest {
    //no ok
    private final Administration administration = new Administration();
    private final MediaObjects mediaObjects = new AudioClass();

    @Test
    void addToListNull() {
        assertFalse(administration.addToList(null));
    }

    @Test
    void addToListPlusOne() {
        int list1size  = administration.getAdministrationList().size();
        administration.addToList(mediaObjects);

        ArrayList<MediaObjects> list2 = administration.getAdministrationList();

        assertEquals(list1size + 1, list2.size());
    }

    @Test
    void listItems() {
        List<MediaContent> result = new ArrayList<>();

        administration.listItems();

        assertNotNull(result);
    }


    @Test
    void removeNull() {
        assertFalse(administration.remove(null));
    }

    @Test
    void removeEmptyList() {
        assertFalse(administration.remove(mediaObjects));
    }


    @Test
    void remove() {
        administration.addToList(mediaObjects);
        int list1size = administration.getAdministrationList().size();

        administration.remove(mediaObjects);

        ArrayList<MediaObjects> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }

    @Test
    void remove_mock() {
        administration.addToList(mediaObjects);
        int list1size = administration.getAdministrationList().size();
        AudioClass audio = mock(AudioClass.class);
        when(audio.getSize()).thenReturn(1000L);
        administration.remove(mediaObjects);

        ArrayList<MediaObjects> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }


    @Test
    void updateNull() {
        assertFalse(administration.update(null));
    }

    @Test
    void updateAccessCounter() {
        int mediaContentAccessCount1 = mediaObjects.getAccessCount();

        administration.update(mediaObjects);

        int mediaContentAccessCount2 = mediaObjects.getAccessCount();

        assertEquals(mediaContentAccessCount1 + 1, mediaContentAccessCount2);
    }


}