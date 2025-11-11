package domainLogic;

import CLI.eventSystem.events.FeedbackEvent;
import CLI.eventSystem.handler.FeedbackHandler;
import CLI.eventSystem.observer.Observable;
import CLI.eventSystem.observer.Observer;
import contract.MediaContent;
import contract.MediaObject;
import contract.Tag;
import contract.Uploader;


import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Administration implements Model, Observable {
    AtomicInteger index = new AtomicInteger(1);
    private final ArrayList<MediaObject> administrationList = new ArrayList<>();
    private final List<Uploader> uploaderList = new ArrayList<>();

    // Feedback Eventsystem
    private FeedbackHandler feedbackHandler;

    public void setFeedbackHandler(FeedbackHandler feedbackHandler) {
        this.feedbackHandler = feedbackHandler;
    }
    // Observersystem
    private final List<Observer> observerList = new LinkedList<>();
    String status;

    @Override
    public void attachObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void detachObserver(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void notifyObservers(String status) {
        this.status = status;
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public String getStatus() {
        return status;
    }


    // ___________________Uploader________________________

    public List<Uploader> getUploaderList() {
        return new ArrayList<>(uploaderList);
    }

    public boolean addUploaderToList(Uploader uploader) {
        if (uploader != null && checkIfUploaderAlreadyExists(uploader)) {
            uploaderList.add(uploader);
            printStatus(uploader.getName() + " wurde erfolgreich hinzugefügt");
            return true;
        }
        if (uploader != null) printStatus(uploader.getName() + " konnte nicht hinzugefügt werden");
        return false;
    }

    private boolean checkIfUploaderAlreadyExists(Uploader uploader) {
        for (Uploader other : uploaderList) {
            if (Objects.equals(other.getName(), uploader.getName())) return false;
        }
        return true;
    }

    // ___________________Adding Mediaobjects________________________

    public boolean addMediaobjectToList(String uploaderName, Collection<Tag> tags, long size, BigDecimal cost, int samplingRate) {
        MediaObject mediaObject = new AudioImpl(new UploaderImpl(uploaderName), tags, size, cost, samplingRate);
        mediaObject.setAddress(createAddress());
        if (isMediaObjectValid(mediaObject)) {
            administrationList.add(mediaObject);
            printStatus("Mediaobjekt wurde hinzugefügt");
            return true;
        } else {
            printStatus("Mediaobjekt konnte nicht hinzugefügt werden");
            return false;
        }
    }

    private String createAddress() {
        int id = index.getAndIncrement();
        return "media://ID=" + id;
    }

    private boolean isMediaObjectValid(MediaObject mediaObject) {
        return checkIfMediaobjectBelongsToExistingUploader(mediaObject)
                && checkMaxMediaSize(mediaObject)
                && checkIfAddressIsUnique(mediaObject);
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

    private boolean checkIfAddressIsUnique(MediaObject mediaObject) {
        for (MediaObject m : administrationList) {
            if (Objects.equals(mediaObject.getAddress(), m.getAddress())) return false;
        }
        return true;
    }

    // ___________________List Mediaobjects________________________

    public List<MediaContent> listItems() {
        return new ArrayList<>(administrationList);
    }

    // ___________________Remove Mediaobjects________________________

    public boolean remove(String address) {
        for (MediaObject mediaObject : administrationList) {
            if (mediaObject.getAddress().equals(address)) {
                administrationList.remove(mediaObject);
                printStatus("Mediaobjekt wurde gelöscht");
                return true;
            }
        }
        printStatus("Mediaobjekt konnte nicht gelöscht werden");
        return false;
    }

    // ___________________Update Mediaobjects________________________

    public boolean update(String address) {
        for (MediaObject mediaObject : administrationList) {
            if (mediaObject.getAddress().equals(address)) {
                mediaObject.incrementAccessCount();
                printStatus("Mediaobjekt wurde geupdatet");
            }
        }
        printStatus("Mediaobjekt konnte nicht geupdatet werden");
        return false;
    }

    // FeedbackEvent erstellen & Observer benachrichtigen
    @Override
    public void printStatus(String message) {
        feedbackHandler.handle(new FeedbackEvent(this, "Eventsystem meldet: " + message));
        notifyObservers("Observable meldet: " + message);
    }
}
