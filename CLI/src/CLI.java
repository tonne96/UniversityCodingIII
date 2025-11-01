import contract.MediaObject;

import java.util.List;
import java.util.Scanner;

public class CLI {

    public void start(MediaObject mediaObject) {
        Administration administration = new Administration();
        Scanner scanner = new Scanner(System.in);
        administration.addUploaderToList(mediaObject.getUploader());
        while (true) {
            System.out.println("""
                Waehlen Sie eine der folgenden Operationen:
                :c Wechsel in den Einfuegemodus
                :r Wechsel in den Anzeigemodus
                :u Wechsel in den Aenderungsmodus
                :d Wechsel in den Loeschmodus
                :x beendet die Anwendung
                """);
            String enteredValue = scanner.nextLine();
            switch (enteredValue) {
                case ":c" : administration.addMediaobjectToList(mediaObject); break;
                case ":r" : listItems(administration.getAdministrationList()); break;
                case ":u" : administration.update(mediaObject); break;
                case ":d" : administration.remove(mediaObject); break;
                case ":x" : System.exit(0); break;
            }
        }
    }

    public void listItems(List<MediaObject> mediaObjectList) {
        for (MediaObject m : mediaObjectList) {
            System.out.println(
                    "Medientyp: " + m.getClass().getSimpleName() + " |"
                    + " Uploader: " + m.getUploader().getName() + " |"
                    + " Tag: " + m.getTags()
            );
        }
    }
}
