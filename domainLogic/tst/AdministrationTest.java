import contract.Audio;
import contract.MediaContent;
import contract.MediaObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdministrationTest {
    private Administration administration;
    private AudioClass audioClass;

    @BeforeEach void setUp() {
        this.administration = new Administration();
        this.audioClass = new AudioClass();
    }

    @Test
    void addToListNull() {
        assertFalse(administration.addToList(null));
    }

    @Test
    void addToListPlusOne() {
        int list1size  = administration.getAdministrationList().size();
        administration.addToList(audioClass);

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
        assertFalse(administration.remove(audioClass));
    }


    @Test
    void remove() {
        administration.addToList(audioClass);
        int list1size = administration.getAdministrationList().size();

        administration.remove(audioClass);

        ArrayList<MediaObjects> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }

    @Test
    void remove_mock() {
        administration.addToList(audioClass);
        int list1size = administration.getAdministrationList().size();
        AudioClass audio = mock(AudioClass.class);
        when(audio.getSize()).thenReturn(1000L);
        administration.remove(audio);

        ArrayList<MediaObjects> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }


    @Test
    void updateNull() {
        assertFalse(administration.update(null));
    }

    @Test
    void updateAccessCounter() {
        int mediaContentAccessCount1 = audioClass.getAccessCount();

        administration.update(audioClass);

        int mediaContentAccessCount2 = audioClass.getAccessCount();

        assertEquals(mediaContentAccessCount1 + 1, mediaContentAccessCount2);
    }


}