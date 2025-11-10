package domainLogic;

import contract.MediaContent;
import contract.MediaObject;
import contract.Tag;
import contract.Uploader;
import domainLogic.eventSystem.events.FeedbackEvent;
import domainLogic.eventSystem.listener.FeedbackListener;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Administration {
    AtomicInteger index = new AtomicInteger(1);


    private final ArrayList<MediaObject> administrationList = new ArrayList<>();
    private final List<Uploader> uploaderList = new ArrayList<>();
    private final List<FeedbackListener> feedbackListenersList = new ArrayList<>();

    public void addFeedbackListener(FeedbackListener listener) {
        feedbackListenersList.add(listener);
    }

    public void removeFeedbackListener(FeedbackListener listener) {
        feedbackListenersList.remove(listener);
    }

    private void notifyFeedbackListeners(String message) {
        FeedbackEvent event = new FeedbackEvent(this, message);
        for (FeedbackListener l : feedbackListenersList) {
            l.onFeedback(event);
        }
    }

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
            notifyFeedbackListeners("Mediaobjekt hinzugefügt");
            return true;
        } else {
            notifyFeedbackListeners("Mediaobjekt nicht hinzugefügt");
            return false;
        }
    }

    private boolean isMediaObjectValid(MediaObject mediaObject) {
        return checkIfMediaobjectBelongsToExistingUploader(mediaObject)
                && checkMaxMediaSize(mediaObject)
                && checkIfAddressIsUnique(mediaObject);
    }


    public boolean addUploaderToList(Uploader uploader) {
        if (uploader != null && checkIfUploaderAlreadyExists(uploader)) {
            uploaderList.add(uploader);
            return true;
        }
        return false;
    }

    private boolean checkIfUploaderAlreadyExists(Uploader uploader) {
        for (Uploader other : uploaderList) {
            if (Objects.equals(other.getName(), uploader.getName())) return false;
        }
        return true;
    }

    private boolean checkIfMediaobjectBelongsToExistingUploader(MediaObject mediaObject) {
        for (Uploader uploader : uploaderList) {
            if (Objects.equals(mediaObject.getUploader().getName(), uploader.getName())) return true;
        }
        return false;
    }


    private boolean checkMaxMediaSize(MediaObject mediaObject) {
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
                notifyFeedbackListeners("Mediaobjekt erfolgreich gelöscht");
                return true;
            }
        }
        notifyFeedbackListeners("Meidaobjekt konnte nicht gelöscht werden");
        return false;
    }

    public boolean update(String address) {
        for (MediaObject mediaObject : administrationList) {
            if (mediaObject.getAddress().equals(address)) {
                mediaObject.incrementAccessCount();
                notifyFeedbackListeners("Mediaobjekt erfolgreich geupdatet");
                return true;
            }
        }
        notifyFeedbackListeners("Mediaobjekt konnte nicht geupdatet werden");
        return false;
    }
}
