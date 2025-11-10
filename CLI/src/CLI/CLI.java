package CLI;

import domainLogic.eventSystem.events.AddEvent;
import domainLogic.eventSystem.events.ListEvent;
import domainLogic.eventSystem.events.UpdateEvent;
import domainLogic.eventSystem.handler.*;
import domainLogic.eventSystem.events.RemoveEvent;

import java.util.Scanner;

public class CLI {

    // erstellt Eventobjekt welches zum Typ der Eingabe passt mit Informationen hinterlegt
    // hat Handler für verschiedene CRUD
    // übergibt AddEvent an passenden Handler
    // verschiedene Eventtypen für CRUD
    /*
    4 Events für CRUD

    4 Handler für CRUD
    4 Listener für CRUD
    Main
    create Handler, AddEvent, Listener
    setHandlers
    Listener bekommen ein Administrationsmodel welches in der Main instanziert wird
     */

    private AddHandler addHandler;
    private ListHandler listHandler;
    private RemoveHandler removeHandler;
    private UpdateHandler updateHandler;

    public void setAddHandler(AddHandler addHandler) {
        this.addHandler = addHandler;
    }
    public void setListHandler(ListHandler listHandler) {
        this.listHandler = listHandler;
    }
    public void setRemoveHandler(RemoveHandler removeHandler) {
        this.removeHandler = removeHandler;
    }
    public void setUpdateHandler(UpdateHandler updateHandler) {
        this.updateHandler = updateHandler;
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
            switch (enteredValue) {
                case ":c" : if (this.addHandler != null) addHandler.handle(new AddEvent(this,"Test")); break;
                case ":r" : if (this.listHandler != null) listHandler.handle(new ListEvent(this, "Test")); break;
                case ":u" : if (this.updateHandler != null) updateHandler.handle(new UpdateEvent(this, "Test")); break;
                case ":d" : if (this.removeHandler != null) removeHandler.handle(new RemoveEvent(this, "Address")); break;
                case ":x" : System.exit(0); break;
                default : System.out.println("Ungueltige Eingabe" + "\n");
            }
        }
    }


    /*
    public AddEvent handleTextInput(String string) {
        switch (string) {
            case ":c":
                return new AddEvent(this,"onMediaItemAdd");
            default:
                System.out.println("Ungueltige Eingabe" + "\n");
        }
        return new AddEvent(this,"onWrongInput");
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

     */
}
