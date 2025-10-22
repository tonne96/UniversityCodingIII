import contract.MediaContent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdministrationTest {

    private final Administration administration = new Administration();
    private final MediaContent mediaContent = new Audio();

    @Test
    void addToListNull() {
        assertFalse(administration.addToList(null));
    }

    @Test
    void addToListPlusOne() {
        int list1size  = administration.getAdministrationList().size();

        administration.addToList(mediaContent);

        ArrayList<MediaContent> list2 = administration.getAdministrationList();

        assertEquals(list1size + 1, list2.size());
    }

    @Test
    void listItemsEmpty() {
        fail();
    }


    @Test
    void removeNull() {
        assertFalse(administration.remove(null));
    }

    @Test
    void removeEmptyList() {
        assertFalse(administration.remove(mediaContent));
    }


    @Test
    void remove() {
        administration.addToList(mediaContent);
        int list1size = administration.getAdministrationList().size();

        administration.remove(mediaContent);

        ArrayList<MediaContent> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }

    @Test
    void updateAccessCounter() {
        int mediaContentAccessCount1 = mediaContent.getAccessCount();

        administration.addToList(mediaContent);
        administration.update(mediaContent);

        int mediaContentAccessCount2 = mediaContent.getAccessCount();
        assertEquals(mediaContentAccessCount1 + 1, mediaContentAccessCount2);
    }

    @Test
    void updateName() {
        /*
        String oldTitle = "old title";
        audio.setTitle(oldTitle);

        String newTitle = "new title";
        administration.addToList(audio);
        administration.update(audio, newTitle);

        assertEquals(newTitle, audio.getTitle());
         */
    }

}