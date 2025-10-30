import contract.MediaObject;
import contract.Tag;
import contract.Uploader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdministrationTest {

    //________________________MEDIAOBJECTS_TO_LIST____________________________

    @Test
    void addMediaobjectToListNull() {
        Administration administration = new Administration();
        assertFalse(administration.addMediaobjectToList(null));
    }

    @Test
    void addValidMediaobjectToList () {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.singleton(Tag.Animal), uploader);

        administration.addUploaderToList(uploader);

        assertTrue(administration.addMediaobjectToList(audio));
    }

    @Test
    void addMediaobjectToListPlusOne() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.singleton(Tag.Animal), uploader);
        administration.addUploaderToList(uploader);

        int list1size  = administration.getAdministrationList().size();

        administration.addMediaobjectToList(audio);

        ArrayList<MediaObject> list2 = administration.getAdministrationList();

        assertEquals(list1size + 1, list2.size());
    }

    //________________________MEDIAOBJECT_MAX_SIZE____________________________

    @Test
    void checkMaxMediaSizeOversizedMedia() {
        Administration administration = new Administration();
        AudioImpl audio = mock(AudioImpl.class);

        when(audio.getSize()).thenReturn(2L * 1024 * 1024 * 1024);

        assertTrue(administration.checkMaxMediaSize(audio));
    }

    @Test
    void addMediaobjectToListCheckExistingUploader() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.singleton(Tag.Animal), uploader);

        assertFalse(administration.checkIfMediaobjectBelongsToExistingUploader(audio));
    }

    //________________________MEDIAOBJECTS_EXISTING_UPLOADER____________________________

    @Test
    void checkIfMediaobjectBelongsToExistingUploader() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.singleton(Tag.Animal), uploader);

        assertFalse(administration.addMediaobjectToList(audio));
    }

    //________________________MEDIAOBJECTS_UNIQUE_ADDRESS____________________________

    @Test
    void checkIfAddressIsUnique() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio1 = new AudioImpl("Test", Collections.singleton(Tag.Animal), uploader);
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(audio1);

        AudioImpl audio2 = mock(AudioImpl.class);
        when(audio2.getAddress()).thenReturn(audio1.getAddress());

        assertTrue(administration.checkIfAddressIsUnique(audio2));
    }

    //________________________UPLOADER____________________________

    @Test
    void addUploaderToListNull() {
        Administration administration = new Administration();
        assertFalse(administration.addUploaderToList(null));
    }

    @Test
    void addUploaderToListPlusOne() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        int list1size  = administration.getUploaderList().size();
        administration.addUploaderToList(uploader);


        administration.addUploaderToList(uploader);

        ArrayList<Uploader> list2 = administration.getUploaderList();

        assertEquals(list1size + 1, list2.size());
    }

    @Test
    void addUploaderWhichAlreadyExists() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader1);

        UploaderImpl uploader2 = new UploaderImpl("TestUploader");

        assertFalse(administration.addUploaderToList(uploader2));
    }

    @Test
    void checkIfUploaderAlreadyExistsUniqueUploader() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        assertTrue(administration.addUploaderToList(uploader));
    }

    @Test
    void checkIfUploaderAlreadyExistsDuplicate() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");
        UploaderImpl uploader2 = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader1);

        assertFalse(administration.addUploaderToList(uploader2));
    }

    //________________________LIST_ITEMS____________________________

    @Test
    void listItemsReturnsList() {
        Administration administration = new Administration();

        List<MediaObject> result = new ArrayList<>();

        administration.listItems();

        assertNotNull(result);
    }

    //________________________REMOVE_ITEMS____________________________

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
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl("Test", Collections.singleton(Tag.Animal), uploader);
        administration.addUploaderToList(uploader);

        administration.addMediaobjectToList(audio);
        int list1size = administration.getAdministrationList().size();

        administration.remove(audio);

        ArrayList<MediaObject> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }

    //________________________UPDATE_MEDIAOBJECT____________________________

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