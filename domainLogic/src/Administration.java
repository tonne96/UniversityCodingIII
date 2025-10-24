import contract.AudioVideo;
import contract.MediaContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaContent> administrationList = new ArrayList<>();
    public ArrayList<MediaContent> getAdministrationList() {
        return administrationList;
    }


    public boolean addToList(MediaContent mediaContent) {
        // Null‑Check
        if (mediaContent == null) {
            return false;
        }
        administrationList.add(mediaContent);
        return true;
    }

    public List<MediaContent> listItems() {
        return Collections.unmodifiableList(administrationList);    // gibt Liste zurück aber nicht veränderbar
    }

    public boolean remove(MediaContent mediaContent) {
        // Null‑Check
        if (mediaContent == null) {
            return false;
        }
        return administrationList.remove(mediaContent);
    }

    public boolean update(MediaContent mediaContent) {
        // Null‑Check
        if (mediaContent == null) return false;
        /* for (MediaContent object: administrationList) {
            if (Objects.equals(object.getAddress(), mediaContent.getAddress())) {
                administrationList.remove(object);
                administrationList.add(mediaContent);
            } else return false;
        }
         */
        mediaContent.getAddress();
        return true;
    }


}
