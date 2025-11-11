package CLI;

import CLI.eventSystem.events.*;
import CLI.eventSystem.handler.*;
import domainLogic.Model;

import java.util.Scanner;

public class CLI implements Model {


    /*
    todo
    erstellt Eventobjekt welches zum Typ der Eingabe passt mit Informationen hinterlegt
    hat Handler für verschiedene CRUD
    übergibt AddMediaobjectEvent an passenden Handler
    verschiedene Eventtypen für CRUD
    4 Events für CRUD
    4 Handler für CRUD
    4 Listener für CRUD
    Main
    create Handler, AddMediaobjectEvent, Listener
    setHandlers
    Listener bekommen ein Administrationsmodel welches in der Main instanziert wird
     */

    private AddMediaobjectHandler addMediaobjectHandler;
    private AddUploaderHandler addUploaderHandler;
    private ListHandler listHandler;
    private RemoveHandler removeHandler;
    private UpdateHandler updateHandler;
    private FeedbackHandler feedbackHandler;

    public void setAddMediaobjectHandler(AddMediaobjectHandler addMediaobjectHandler) {
        this.addMediaobjectHandler = addMediaobjectHandler;
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
    public void setFeedbackHandler(FeedbackHandler feedbackHandler) {
        this.feedbackHandler = feedbackHandler;
    }
    public void setUploaderHandler(AddUploaderHandler uploaderHandler) {
        this.addUploaderHandler = uploaderHandler;
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
                case ":c" : {
                    System.out.println("""
                            :u Uploader hinzufügen
                            :m Mediaobject hinzufügen
                            """);
                    String enteredValueAdding = scanner.nextLine();
                    switch (enteredValueAdding) {
                        case ":u" : addUploaderHandler.handle(new AddUploaderEvent(this, "TestUploader")); break;
                        case ":m" : addMediaobjectHandler.handle(new AddMediaobjectEvent(this)); break;
                        default:
                            System.out.println("Ungueltige Eingabe" + "\n");
                    } break;
                }
                case ":r" : {
                    listHandler.handle(new ListEvent(this));
                    break;
                }
                case ":u" : {
                    updateHandler.handle(new UpdateEvent(this, "media://ID=1"));
                    break;
                }
                case ":d" : {
                    removeHandler.handle(new RemoveEvent(this, "media://ID=1"));
                    break;
                }
                case ":x" : {
                    System.exit(0);
                }
                default : {
                    System.out.println("Ungueltige Eingabe" + "\n");
                }
            }
            printStatus("Entered: " + enteredValue);
        }
    }


    @Override
    public void printStatus(String message) {
        feedbackHandler.handle(new FeedbackEvent(this, "CLI: " + message));
    }
}
