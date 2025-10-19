import contract.AudioVideo;

import java.util.ArrayList;

public class Administration {

    // Liste wo alles drin gespeichert wird
    private final ArrayList<Audio> administrationList = new ArrayList<>();

    public ArrayList<Audio> getAdministrationList() {
        return administrationList;
    }

    // Quelle fuer Generics : https://www.w3schools.com/java/java_generics.asp
    public <T extends Audio> boolean addToList(T object) {
        // Null‑Check
        if (object == null) {
            return false;
        }

        // aktuelle Groese merken
        int startSize = administrationList.size();

        // Element hinzufügen
        administrationList.add(object);

        // pruefen, ob Groesse +1
        return administrationList.size() == startSize + 1;
    }

    public void listItems() {
        for (AudioVideo object: administrationList) {
            System.out.println(object.getClass().getSimpleName() + object.getTags());   // https://www.geeksforgeeks.org/java/class-getsimplename-method-in-java-with-examples/
        }
    }

    public boolean remove(Audio audio) {
        // Null‑Check
        if (audio == null) {
            return false;
        }
        // empty list check
        if (administrationList.isEmpty()) return false;

        int startSize = administrationList.size();

        administrationList.remove(audio);

        return administrationList.size() == startSize - 1;
    }

    public boolean update(Audio updateAudio, String newTitle) {
        // Null‑Check
        if (updateAudio == null) {
            return false;
        }
        // empty string check
        if (newTitle.isEmpty()) return false;

        String updatedTitle = "";

        // update Audio
        for (Audio audio: administrationList) {
            if (audio == updateAudio) {
                audio.setTitle(newTitle);
                updatedTitle = audio.getTitle();
            } else return false;
        }
        return newTitle.equals(updatedTitle);
    }
}
