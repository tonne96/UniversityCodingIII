package CLI;

import domainLogic.eventSystem.events.*;
import domainLogic.eventSystem.handler.*;
import domainLogic.eventSystem.listener.FeedbackListener;

import java.util.Scanner;

public class CLI implements FeedbackListener {


    /*
    todo
    erstellt Eventobjekt welches zum Typ der Eingabe passt mit Informationen hinterlegt
    hat Handler für verschiedene CRUD
    übergibt AddEvent an passenden Handler
    verschiedene Eventtypen für CRUD
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
                case ":c" -> addHandler.handle(new AddEvent(this));
                case ":r" -> listHandler.handle(new ListEvent(this));
                case ":u" -> updateHandler.handle(new UpdateEvent(this, "media://ID=1"));
                case ":d" -> removeHandler.handle(new RemoveEvent(this, "media://ID=1"));
                case ":x" -> System.exit(0);
                default -> System.out.println("Ungueltige Eingabe" + "\n");
            }
        }
    }

    @Override
    public void onFeedback(FeedbackEvent feedbackEvent) {
        System.out.println("Administration meldet: "+ feedbackEvent.getFeedbackMessage());
    }
}
