import contract.MediaObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaObjects> administrationList = new ArrayList<>();

    public ArrayList<MediaObjects> getAdministrationList() {
        return administrationList;
    }


    public boolean addToList(MediaObjects mediaObject) {
        if (mediaObject != null) {
            administrationList.add(mediaObject);
        }
        return false;
    }

    public List<MediaObjects> listItems() {
        return Collections.unmodifiableList(administrationList);    // gibt Liste zurück aber nicht veränderbar
    }

    public boolean remove(MediaObjects mediaObject) {
        if (mediaObject != null) {
            return administrationList.remove(mediaObject);
        }
        return false;
    }

    public boolean update(MediaObjects mediaObject) {
        if (mediaObject == null) return false;
        mediaObject.incrementAccessCounter();
        return true;
    }
}
