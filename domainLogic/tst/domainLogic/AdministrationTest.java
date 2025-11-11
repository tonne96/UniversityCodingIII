package domainLogic;

import contract.MediaContent;
import contract.MediaObject;
import contract.Tag;
import contract.Uploader;
import domainLogic.eventSystem.events.FeedbackEvent;
import domainLogic.eventSystem.listener.FeedbackListener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.descriptor.MethodBasedTestDescriptor;

import java.awt.event.ComponentListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdministrationTest {

    //________________________MEDIAOBJECTS_TO_LIST____________________________

    // Mediaobject ist null
    @Test
    void addMediaobjectToListNullUploaderNull() {
        Administration administration = new Administration();

        assertFalse(administration.addMediaobjectToList(null, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100));
    }

    // nach hinzufuegen ist Liste um 1 gewachsen
    @Test
    void addMediaobjectToListPlusOne() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader);

        int list1size = administration.listItems().size();

        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        List<MediaContent> list2 = administration.listItems();

        assertEquals(list1size + 1, list2.size());
    }

    @Test
    void addFeedbackListener() {
        Administration administration = new Administration();
        FeedbackListener feedbackListener = new FeedbackListener() {
            @Override
            public void onFeedback(FeedbackEvent feedbackEvent) {

            }
        };
        int lengthBefore = administration.getFeedbackListenersList().size();
        administration.addFeedbackListener(feedbackListener);

        assertEquals(lengthBefore + 1, administration.getFeedbackListenersList().size());
    }

    @Test
    void removeFeedbackListener() {
        Administration administration = new Administration();
        FeedbackListener feedbackListener = new FeedbackListener() {
            @Override
            public void onFeedback(FeedbackEvent feedbackEvent) {

            }
        };
        administration.addFeedbackListener(feedbackListener);
        int lengthBefore = administration.getFeedbackListenersList().size();

        administration.removeFeedbackListener(feedbackListener);

        assertEquals(lengthBefore - 1, administration.getFeedbackListenersList().size());
    }

    @Test
    public void testNotifyFeedbackListeners() {
        Administration admin = new Administration();

        FeedbackListener mockListener = mock(FeedbackListener.class);
        admin.addFeedbackListener(mockListener);

        Uploader uploader = new UploaderImpl("TestUploader");
        admin.addUploaderToList(uploader);


        // MediaObject mit gültigem Uploader hinzufügen, damit Event ausgelöst wird
        boolean added = admin.addMediaobjectToList(uploader, new ArrayList<>(), 100L, BigDecimal.valueOf(10), 44100);

        assertTrue(added);

        verify(mockListener, times(1)).onFeedback(any(FeedbackEvent.class));
    }

    // Mediaobject gehoert zu nicht bekannten Uploader
    @Test
    void addMediaobjectToListNotExistingUploader() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");


        assertFalse(administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100));
    }



    // Mediaobject ist zu groß
    @Test
    void addMediaobjectToListFileToLarge() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        MediaObject mediaObject = new AudioImpl();
        administration.addUploaderToList(uploader);

        assertFalse(administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), mediaObject.getMaxSize() + 1, BigDecimal.valueOf(10), 44100));
    }

    //________________________MEDIAOBJECT_MAX_SIZE____________________________

    // Mediaobject hat eine zu große Groesse
    /*
    @Test
    void checkMaxMediaSizeOversizedMedia() {
        Administration administration = new Administration();
        AudioImpl audio = mock(AudioImpl.class);
        long currentSize = audio.getSize();
        when(audio.getSize()).thenReturn(currentSize + 1);

        assertFalse(administration.checkMaxMediaSize(audio));
    }

     */

    //________________________MEDIAOBJECTS_EXISTING_UPLOADER____________________________

    // Leere Uploader liste
    /*
    @Test
    void checkIfMediaobjectBelongsToExistingUploaderEmptyList() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        AudioImpl audio = new AudioImpl(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertFalse(administration.checkIfMediaobjectBelongsToExistingUploader(audio));
    }

     */

    // hinzugefuegtes Meidaobject gehoert zu keinem Uploader in der Uploaderliste
    /*
    @Test
    void checkIfMediaobjectBelongsToExistingUploaderNotExisting() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader1);

        UploaderImpl uploader2 = new UploaderImpl("TestUploader2");
        AudioImpl audio = new AudioImpl(uploader2, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertFalse(administration.checkIfMediaobjectBelongsToExistingUploader(audio));
    }

     */

    // hinzugefuegtes Meidaobject gehoert zu keinem Uploader in der Uploaderliste

    @Test
    void checkIfMediaobjectBelongsToExistingDifferentName() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader);

        UploaderImpl uploader1 = new UploaderImpl("TestUploader2");

        assertFalse(administration.addMediaobjectToList(uploader1, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100));
    }




    //________________________MEDIAOBJECTS_UNIQUE_ADDRESS____________________________

    // testet ob true wenn Adresse noch nicht vergeben
    /*
    @Test
    void checkIfAddressIsUnique() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        MediaObject mediaObject = new AudioImpl();
        MediaObject mediaObject1 = new AudioImpl();
        mediaObject1.setAddress("media://ID=1");
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertTrue(administration.checkIfAddressIsUnique(mediaObject));
    }

     */



    // testet false wenn Adresse schon vergeben
    /*
    @Test
    void checkIfAddressIsUniqueDifferentAddresses() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        MediaObject mediaObject = new AudioImpl();
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        MediaContent mediaContent = administration.listItems().getFirst();

        mediaObject.setAddress(mediaContent.getAddress());

        assertFalse(administration.checkIfAddressIsUnique(mediaObject));
    }

     */

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
        int list1size = administration.getUploaderList().size();
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

    // checkt dass keine gleichen Uploader hinzugefuegt werden koennen
    @Test
    void addUploaderWhichDoesNotExist() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader1);

        UploaderImpl uploader2 = new UploaderImpl("TestUploader2");

        assertTrue(administration.addUploaderToList(uploader2));
    }

    // Liste ist leer
    /*
    @Test
    void checkIfUploaderAlreadyExistsEmptyList() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");

        assertTrue(administration.checkIfUploaderAlreadyExists(uploader));
    }

     */

    // Liste beinhaltet schon den Uploader
    /*
    @Test
    void checkIfUploaderAlreadyExistsAlreadyInList() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader1);
        UploaderImpl uploader2 = new UploaderImpl("TestUploader");

        assertFalse(administration.checkIfUploaderAlreadyExists(uploader2));
    }

     */

    // Liste beinhaltet Uploader noch nicht und fuegt ein
    /*
    @Test
    void checkIfUploaderAlreadyExistsNotInList() {
        Administration administration = new Administration();
        UploaderImpl uploader1 = new UploaderImpl("TestUploader");

        administration.addUploaderToList(uploader1);
        UploaderImpl uploader2 = new UploaderImpl("TestUploader2");

        assertTrue(administration.checkIfUploaderAlreadyExists(uploader2));
    }

     */

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


    // Liste ist leer
    @Test
    void removeObjectNotInList() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertFalse(administration.remove(""));
    }

    // check ob Liste kleiner wird nach remove
    @Test
    void removeListMinusOne() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        int listSizeBefore = administration.listItems().size();

        administration.remove(administration.listItems().getFirst().getAddress());

        assertEquals(listSizeBefore - 1, administration.listItems().size());
    }

    //________________________UPDATE_MEDIAOBJECT____________________________


    // checkt ob counter erhöht wird
    @Test
    void updateAccessCounter() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
        MediaContent mediaContent = administration.listItems().getFirst();
        int counterBefore = mediaContent.getAccessCount();

        administration.update(mediaContent.getAddress());

        assertEquals(counterBefore + 1, mediaContent.getAccessCount());
    }

    // Objekt ist nicht in Liste
    @Test
    void updateNotInList() {
        Administration administration = new Administration();
        UploaderImpl uploader = new UploaderImpl("TestUploader");
        administration.addUploaderToList(uploader);
        administration.addMediaobjectToList(uploader, Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);

        assertFalse(administration.update(""));
    }


}