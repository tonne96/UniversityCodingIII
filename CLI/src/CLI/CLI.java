package CLI;

import CLI.eventSystem.events.*;
import CLI.eventSystem.handler.*;
import CLI.eventSystem.listener.*;
import domainLogic.Model;

import java.util.EventObject;
import java.util.Scanner;

public class CLI implements Model {

    private Handler<AddMediaobjectListener, AddMediaobjectEvent> addMediaobjectHandler;
    private Handler<AddUploaderListener, AddUploaderEvent> addUploaderHandler;
    private Handler<ListListener, ListEvent> listHandler;
    private Handler<RemoveListener, RemoveEvent> removeHandler;
    private Handler<UpdateListener, UpdateEvent> updateHandler;
    private Handler<FeedbackListener<? extends Model>, FeedbackEvent> feedbackHandler;

    public void setAddMediaobjectHandler(Handler<AddMediaobjectListener, AddMediaobjectEvent> addMediaobjectHandler) {
        this.addMediaobjectHandler = addMediaobjectHandler;
    }
    public void setListHandler(Handler<ListListener, ListEvent> listHandler) {
        this.listHandler = listHandler;
    }
    public void setRemoveHandler(Handler<RemoveListener, RemoveEvent> removeHandler) {
        this.removeHandler = removeHandler;
    }
    public void setUpdateHandler(Handler<UpdateListener, UpdateEvent> updateHandler) {
        this.updateHandler = updateHandler;
    }
    public void setFeedbackHandler(Handler<FeedbackListener<? extends Model>, FeedbackEvent> feedbackHandler) {
        this.feedbackHandler = feedbackHandler;
    }
    public void setUploaderHandler(Handler<AddUploaderListener, AddUploaderEvent> uploaderHandler) {
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
                        // Untermenü zum einfügen von Uploader oder Mediaobject
                        // wie in Anforderungen ein vordefinierter Uploader und ein vordefiniertes Mediaobjekt
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
