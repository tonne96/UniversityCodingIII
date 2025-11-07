import contract.MediaObject;
import contract.Tag;
import contract.Uploader;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdministrationTest {

    //________________________MEDIAOBJECTS_TO_LIST____________________________

    // Mediaobject ist null
    @Test
    void addMediaobjectToListNull() {
        Administration administration = new Administration();

        assertFalse(administration.addMediaobjectToList(null));
    }

    // nach hinzufuegen ist Liste um 1 gewachsen
    @Test
    void addMediaobjectToListPlusOne() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        administration.addUploaderToList(uploader);

        int list1size  = administration.getAdministrationList().size();

        administration.addMediaobjectToList(audio);

        List<MediaObject> list2 = administration.getAdministrationList();

        assertEquals(list1size + 1, list2.size());
    }


    // Mediaobject gehoert zu nicht bekannten Uploader
    @Test
    void addMediaobjectToListNotExistingUploaderFromMediaobject() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");

        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertFalse(administration.addMediaobjectToList(audio));
    }

    // Mediaobject hat gleiche Adresse
    @Test
    void addMediaobjectToListAddressNotUnique() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader);

        AudioImpl audio1 = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        administration.addMediaobjectToList(audio1);

        AudioImpl audio2 = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100) {

            @Override
            public String getAddress() {return audio1.getAddress(); }
        };

        assertFalse(administration.addMediaobjectToList(audio2));
    }

    // Mediaobject ist zu groß
    @Test
    void addMediaobjectToListFileToLarge() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader);
        AudioImpl test = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100) {
            @Override
            public long getSize() { return getMaxSize() + 1; }
        };

        assertFalse(administration.addMediaobjectToList(test));
    }

    //________________________MEDIAOBJECT_MAX_SIZE____________________________

    // Mediaobject hat eine zu große Groesse
    @Test
    void checkMaxMediaSizeOversizedMedia() {
        Administration administration = new Administration();
        AudioImpl audio = mock(AudioImpl.class);
        long currentSize = audio.getSize();
        when(audio.getSize()).thenReturn(currentSize + 1);

        assertFalse(administration.checkMaxMediaSize(audio));
    }

    //________________________MEDIAOBJECTS_EXISTING_UPLOADER____________________________

    // Leere Uploader liste
    @Test
    void checkIfMediaobjectBelongsToExistingUploaderEmptyList() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertFalse(administration.checkIfMediaobjectBelongsToExistingUploader(audio));
    }

    // hinzugefuegtes Meidaobject gehoert zu keinem Uploader in der Uploaderliste
    @Test
    void checkIfMediaobjectBelongsToExistingUploaderNotExisting() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader1);

        UploaderImpl uploader2 = new UploaderImpl("TestUploader2");
        AudioImpl audio = new AudioImpl(uploader2, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertFalse(administration.checkIfMediaobjectBelongsToExistingUploader(audio));
    }

    // hinzugefuegtes Meidaobject gehoert zu einem Uploader in der Uploaderliste
    @Test
    void checkIfMediaobjectBelongsToExistingUploaderExists() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader);
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertTrue(administration.checkIfMediaobjectBelongsToExistingUploader(audio));
    }



    //________________________MEDIAOBJECTS_UNIQUE_ADDRESS____________________________

    // testet zwei Objekte mit gleicher Adresse
    @Test
    void checkIfAddressIsUniqueUniqueAddress() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio1 = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(audio1);

        AudioImpl audio2 = mock(AudioImpl.class);
        when(audio2.getAddress()).thenReturn(audio1.getAddress());

        assertFalse(administration.checkIfAddressIsUnique(audio2));
    }

    // testet zwei Objekte mit ungleicher Adresse
    @Test
    void checkIfAddressIsUniqueDifferentAddresses() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio1 = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        AudioImpl audio2 = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(audio1);

        assertTrue(administration.checkIfAddressIsUnique(audio2));
    }

    //________________________UPLOADER____________________________

    // Uploader ist null
    @Test
    void addUploaderToListNull() {
        Administration administration = new Administration();

        assertFalse(administration.addUploaderToList(null));
    }

    // Prueft ob nach hinzufuegen Liste plus 1 groesser ist
    @Test
    void addUploaderToListPlusOne() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        int list1size  = administration.getUploaderList().size();
        administration.addUploaderToList(uploader);

        administration.addUploaderToList(uploader);

        List<Uploader> list2 = administration.getUploaderList();

        assertEquals(list1size + 1, list2.size());
    }

    // checkt dass keine gleichen Uploader hinzugefuegt werden koennen
    @Test
    void addUploaderWhichAlreadyExists() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader1);

        UploaderImpl uploader2 = new UploaderImpl("TestUploader");

        assertFalse(administration.addUploaderToList(uploader2));
    }

    // Liste ist leer
    @Test
    void checkIfUploaderAlreadyExistsEmptyList() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");

        assertTrue(administration.checkIfUploaderAlreadyExists(uploader));
    }

    // Liste beinhaltet schon den Uploader
    @Test
    void checkIfUploaderAlreadyExistsAlreadyInList() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader1);
        UploaderImpl uploader2 = new UploaderImpl("TestUploader");

        assertFalse(administration.checkIfUploaderAlreadyExists(uploader2));
    }

    // Liste beinhaltet Uploader noch nicht und fuegt ein
    @Test
    void checkIfUploaderAlreadyExistsNotInList() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader1);
        UploaderImpl uploader2 = new UploaderImpl("TestUploader2");

        assertTrue(administration.checkIfUploaderAlreadyExists(uploader2));
    }

    //________________________LIST_ITEMS____________________________

    // checkt ob die Methode eine Liste returned
    @Test
    void listItemsReturnsList() {
        Administration administration = new Administration();

        List<MediaObject> result = new ArrayList<>();

        administration.listItems();

        assertNotNull(result);
    }

    //________________________REMOVE_ITEMS____________________________

    // liste ist null wenn entfernen
    @Test
    void removeNull() {
        Administration administration = new Administration();

        assertFalse(administration.remove(null));
    }

    // Liste ist leer
    @Test
    void removeEmptyList() {
        Administration administration = new Administration();
        AudioImpl audio = new AudioImpl();

        assertFalse(administration.remove(audio));
    }

    // check ob Liste kleiner wird nach remove
    @Test
    void removeListMinusOne() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(audio);

        int list1size = administration.getAdministrationList().size();

        administration.remove(audio);

        List<MediaObject> list2 = administration.getAdministrationList();

        assertEquals(list1size- 1, list2.size());
    }

    //________________________UPDATE_MEDIAOBJECT____________________________

    // Mediaobject ist null
    @Test
    void updateNull() {
        Administration administration = new Administration();

        assertFalse(administration.update(null));
    }

    // checkt ob counter erhöht wird
    @Test
    void updateAccessCounter() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        int mediaContentAccessCount1 = audio.getAccessCount();

        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(audio);

        administration.update(audio);

        int mediaContentAccessCount2 = audio.getAccessCount();

        assertEquals(mediaContentAccessCount1 + 1, mediaContentAccessCount2);
    }


}