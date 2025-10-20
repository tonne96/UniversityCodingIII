import contract.AudioVideo;
import contract.MediaContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<MediaContent> administrationList = new ArrayList<>();

    public ArrayList<MediaContent> getAdministrationList() {
        return administrationList;
    }

    // Quelle fuer Generics : https://www.w3schools.com/java/java_generics.asp
    public boolean addToList(MediaContent mediaContent) {
        // Null‑Check
        if (mediaContent == null) {
            return false;
        }

        administrationList.add(mediaContent);
        return true;
    }

    public boolean add(MediaContent mediaContent) {

        return false;
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

    public boolean update(MediaContent object, String newTitle) {
        // Null‑Check
        if (object == null) {
            return false;
        }
        // empty string check
        if (newTitle.isEmpty()) return false;

        String updatedTitle = "";

        // update Audio
        /*
        for (MediaContent media: administrationList) {
            if (media == object) {
                media.(newTitle);
                updatedTitle = media.getTitle();
            } else return false;
        }
         */
        return newTitle.equals(updatedTitle);
    }


}
