import contract.MediaObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaObject> administrationList = new ArrayList<>();

    public ArrayList<MediaObject> getAdministrationList() {
        return administrationList;
    }


    public boolean addToList(MediaObject mediaObject) {
        if (mediaObject != null) {

            administrationList.add(mediaObject);
        }

        return false;
    }

    public boolean checkIfUploaderAlreadyExists (MediaObject mediaObject) {
        for (MediaObject m : administrationList) {
            if (Objects.equals(m.getUploader().getName(), mediaObject.getUploader().getName())) return true;
        }
        return false;
    }

    public boolean checkMaxMediaSize (MediaObject mediaObject) throws IOException {
        return mediaObject.getSize() > mediaObject.getMaxSize();
    }

    public List<MediaObject> listItems() {
        // gibt Liste zurück aber nicht veränderbar
        // Quelle: https://www.geeksforgeeks.org/advance-java/collections-unmodifiablelist-method-in-java-with-examples/
        return Collections.unmodifiableList(administrationList);
    }

    public boolean remove(MediaObject mediaObject) {
        if (mediaObject != null) {
            return administrationList.remove(mediaObject);
        }
        return false;
    }

    public boolean update(MediaObject mediaObject) {
        if (mediaObject != null) {
            mediaObject.incrementAccessCounter();
            return true;
        }
        return false;
    }
}
