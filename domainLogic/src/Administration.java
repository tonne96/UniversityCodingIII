import contract.MediaObject;
import contract.Uploader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaObject> administrationList = new ArrayList<>();
    private final ArrayList<Uploader> uploaderList = new ArrayList<>();

    public ArrayList<MediaObject> getAdministrationList() {
        return administrationList;
    }

    public ArrayList<Uploader> getUploaderList() {
        return uploaderList;
    }

    public boolean addMediaobjectToList(MediaObject mediaObject) {
        if (mediaObject != null
                && checkIfUploaderAlreadyExists(mediaObject.getUploader())
                && checkIfMediaobjectBelongsToExistingUploader(mediaObject)
                && !checkMaxMediaSize(mediaObject)
                && !checkIfAddressIsUnique(mediaObject)) {
            administrationList.add(mediaObject);
            return true;
        }
        return false;
    }

    public boolean addUploaderToList(Uploader uploader) {
        if (uploader != null && !checkIfUploaderAlreadyExists(uploader)) {
            uploaderList.add(uploader);
            return true;
        }
        return false;
    }

    public boolean checkIfUploaderAlreadyExists (Uploader uploader) {
        for (Uploader other : uploaderList) {
            if (Objects.equals(other.getName(), uploader.getName())) return true;
        }
        return false;
    }

    public boolean checkIfMediaobjectBelongsToExistingUploader(MediaObject mediaObject) {
        for (Uploader uploader : uploaderList) {
            if (Objects.equals(mediaObject.getUploader().getName(), uploader.getName())) return true;
        }
        return false;
    }


    public boolean checkMaxMediaSize (MediaObject mediaObject) {
        return mediaObject.getSize() > mediaObject.getMaxSize();
    }

    public boolean checkIfAddressIsUnique(MediaObject mediaObject) {
        for (MediaObject m : administrationList) {
            if (Objects.equals(mediaObject.getAddress(), m.getAddress())) return true;
        }
        return false;
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
