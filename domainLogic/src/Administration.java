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
        // gibt Liste zurück aber nicht veränderbar
        // Quelle: https://www.geeksforgeeks.org/advance-java/collections-unmodifiablelist-method-in-java-with-examples/
        return Collections.unmodifiableList(administrationList);
    }

    public boolean remove(MediaObjects mediaObject) {
        if (mediaObject != null) {
            return administrationList.remove(mediaObject);
        }
        return false;
    }

    public boolean update(MediaObjects mediaObject) {
        if (mediaObject != null) {
            mediaObject.incrementAccessCounter();
        }
        return false;
    }
}
