package CLI;

import CLI.CLIListener.AddListener;
import contract.MediaObject;
import contract.Tag;
import contract.Uploader;
import domainLogic.Administration;
import domainLogic.UploaderImpl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CLI {

    // erstellt Eventobjekt welches zum Typ der Eingabe passt mit Informationen hinterlegt
    // hat Handler für verschiedene CRUD
    // übergibt Event an passenden Handler

    private Handler addHandler, listHandler, removeHandler, updateHandler;

    public void setAddHandler(Handler handler) {
        this.addHandler = handler;
    }
    public void setListHandler(Handler handler) {
        this.listHandler = handler;
    }
    public void setRemoveHandler(Handler handler) {
        this.removeHandler = handler;
    }
    public void setUpdateHandler(Handler handler) {
        this.updateHandler = handler;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
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
            Event event = new Event(this, new UploaderImpl("TestUploader"), Collections.singleton(Tag.Music), 1024L, BigDecimal.valueOf(10), 44100);
            switch (enteredValue) {
                case ":c" : if (this.addHandler != null) {
                    addHandler.handle(event);
                } break;
                case ":r" : if (this.listHandler != null) listHandler.handle(event); break;
                case ":u" : if (this.updateHandler != null) updateHandler.handle(event); break;
                case ":d" : if (this.removeHandler != null) removeHandler.handle(event); break;
                case ":x" : System.exit(0); break;
                default : System.out.println("Ungueltige Eingabe" + "\n");
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
