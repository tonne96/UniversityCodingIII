package domainLogic;

import contract.MediaContent;
import contract.MediaObject;
import contract.Tag;
import contract.Uploader;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Administration {
    AtomicInteger index = new AtomicInteger(1);

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaObject> administrationList = new ArrayList<>();
    private final List<Uploader> uploaderList = new ArrayList<>();


    public List<Uploader> getUploaderList() {
        return new ArrayList<>(uploaderList);
    }

    private String createAddress() {
        int id = index.getAndIncrement();
        return "media://ID=" + id;
    }

    public boolean addMediaobjectToList(Uploader uploader, Collection<Tag> tags, long size, BigDecimal cost, int samplingRate) {
        if (uploader == null) return false;
        MediaObject mediaObject = new AudioImpl(uploader, tags, size, cost, samplingRate);
        mediaObject.setAddress(createAddress());
        if (isMediaObjectValid(mediaObject)) {
            administrationList.add(mediaObject);
            return true;
        }
        return false;
    }

    public boolean isMediaObjectValid(MediaObject mediaObject) {
        return checkIfMediaobjectBelongsToExistingUploader(mediaObject) && checkMaxMediaSize(mediaObject) && checkIfAddressIsUnique(mediaObject);
    }


    public boolean addUploaderToList(Uploader uploader) {
        if (uploader != null && checkIfUploaderAlreadyExists(uploader)) {
            uploaderList.add(uploader);
            return true;
        }
        return false;
    }

    public boolean checkIfUploaderAlreadyExists(Uploader uploader) {
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


    public boolean checkMaxMediaSize(MediaObject mediaObject) {
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

    public boolean remove(String address) {
        for (MediaObject mediaObject : administrationList) {
            if (mediaObject.getAddress().equals(address)) {
                administrationList.remove(mediaObject);
                return true;
            }
        }
        return false;
    }

    public boolean update(String address) {
        for (MediaObject mediaObject : administrationList) {
            if (mediaObject.getAddress().equals(address)) {
                mediaObject.incrementAccessCount();
                return true;
            }
        }
        return false;
    }
}
