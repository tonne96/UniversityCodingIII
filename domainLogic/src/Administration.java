import contract.MediaObject;
import contract.Uploader;

import java.util.*;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaObject> administrationList = new ArrayList<>();
    private final List<Uploader> uploaderList = new ArrayList<>();

    public List<MediaObject> getAdministrationList() {
        return administrationList;
    }

    public List<Uploader> getUploaderList() {
        return uploaderList;
    }

    public boolean addMediaobjectToList(MediaObject mediaObject) {
        if (mediaObject != null
                && checkIfMediaobjectBelongsToExistingUploader(mediaObject)
                && checkMaxMediaSize(mediaObject)
                && checkIfAddressIsUnique(mediaObject)) {
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
        return mediaObject.getSize() < mediaObject.getMaxSize();
    }

    public boolean checkIfAddressIsUnique(MediaObject mediaObject) {
        for (MediaObject m : administrationList) {
            if (Objects.equals(mediaObject.getAddress(), m.getAddress())) return false;
        }
        return true;
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
