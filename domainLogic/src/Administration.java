import contract.MediaContent;
import contract.MediaObject;
import contract.UniqueAddressCreator;
import contract.Uploader;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaObject> administrationList = new ArrayList<>();
    private final List<Uploader> uploaderList = new ArrayList<>();

    public List<MediaObject> getAdministrationList() {
        return new ArrayList<>(administrationList);
    }

    public List<Uploader> getUploaderList() {
        return uploaderList;
    }

    private String createAddress() {
        AtomicInteger index = new AtomicInteger(1);
        int id = index.getAndIncrement();
        return "media://ID=" + id;
    }

    // todo einfügenmethode mit übergebenen konstruktorwerten

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
        if (uploader != null && checkIfUploaderAlreadyExists(uploader)) {
            uploaderList.add(uploader);
            return true;
        }
        return false;
    }

    public boolean checkIfUploaderAlreadyExists (Uploader uploader) {
        for (Uploader other : uploaderList) {
            if (Objects.equals(other.getName(), uploader.getName())) return false;
        }
        return true;
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

    public List<MediaContent> listItems() {
        return new ArrayList<>(administrationList);
    }

    public boolean remove(MediaObject mediaObject) {
        if (mediaObject != null) {
            return administrationList.remove(mediaObject);
        }
        return false;
    }

    public boolean update(MediaObject mediaObject) {
        if (mediaObject != null) {
            for (MediaObject m : administrationList) {
                m.incrementAccessCount();
            }
            return true;
        }
        return false;
    }
}
