import CLI.CLI;
import CLI.eventSystem.events.*;
import CLI.eventSystem.handler.*;
import CLI.eventSystem.listener.*;
import CLI.eventSystem.observer.AdministrationObserver;
import domainLogic.Administration;
import domainLogic.Model;

public class CLIMain {
    public static void main(String[] args) {
        // create model
        Administration administration = new Administration();

        // create controller
        CLI cli = new CLI();

        // create handler
        Handler<AddMediaobjectListener, AddMediaobjectEvent> addMediaobjectHandler = new Handler<>();
        Handler<AddUploaderListener, AddUploaderEvent> addUploaderHandler = new Handler<>();
        Handler<ListListener, ListEvent> listHandler = new Handler<>();
        Handler<RemoveListener, RemoveEvent> removeHandler = new Handler<>();
        Handler<UpdateListener, UpdateEvent> updateHandler = new Handler<>();

        // create listener
        AddMediaobjectListener addMediaobjectListener = new AddMediaobjectListener(administration);
        AddUploaderListener addUploaderListener = new AddUploaderListener(administration);
        ListListener listListener = new ListListener(administration);
        RemoveListener removeListener = new RemoveListener(administration);
        UpdateListener updateListener = new UpdateListener(administration);

        // add listeners
        addMediaobjectHandler.addListener(addMediaobjectListener);
        addUploaderHandler.addListener(addUploaderListener);
        listHandler.addListener(listListener);
        removeHandler.addListener(removeListener);
        updateHandler.addListener(updateListener);  

        // set models
        cli.setAddMediaobjectHandler(addMediaobjectHandler);
        cli.setUploaderHandler(addUploaderHandler);
        cli.setListHandler(listHandler);
        cli.setRemoveHandler(removeHandler);
        cli.setUpdateHandler(updateHandler);

        // create Feebacklistener
        FeedbackListener<CLI> CLIfeedbackListener = new FeedbackListener<>(cli);
        FeedbackListener<Administration> adminFeedbackListener = new FeedbackListener<>(administration);

        // create Feedbackhandler
        FeedbackHandler adminFeedbackHandler = new FeedbackHandler();
        Handler<FeedbackListener<? extends Model>, FeedbackEvent> CLIfeedbackHandler = new Handler<>();

        // add FeedbackListeners
        adminFeedbackHandler.addListener(adminFeedbackListener);
        CLIfeedbackHandler.addListener(CLIfeedbackListener);

        // set FeedbackHandlers
        administration.setFeedbackHandler(adminFeedbackHandler);
        cli.setFeedbackHandler(CLIfeedbackHandler);;

        // create observer für administration
        AdministrationObserver administrationObserver = new AdministrationObserver(administration);

        // attach observer
        administration.attachObserver(administrationObserver);

        // start controller
        cli.start();
    }
}
