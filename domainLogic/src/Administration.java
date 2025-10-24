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
        if (mediaContent != null) {
            administrationList.add(mediaContent);
        }
        return false;
    }

    public List<MediaContent> listItems() {
        return Collections.unmodifiableList(administrationList);    // gibt Liste zurück aber nicht veränderbar
    }

    public boolean remove(MediaContent mediaContent) {
        if (mediaContent != null) {
            return administrationList.remove(mediaContent);
        }
        return false;
    }

    public boolean update(MediaContent mediaContent) {
        if (mediaContent == null) return false;

        if (mediaContent instanceof Audio audio) {
            audio.incrementAccessCount();
        }
        return true;
    }
}
