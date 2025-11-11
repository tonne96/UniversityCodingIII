import CLI.CLI;
import CLI.eventSystem.handler.*;
import CLI.eventSystem.listener.*;
import CLI.eventSystem.observer.AdministrationObserver;
import domainLogic.Administration;

public class CLIMain {
    public static void main(String[] args) {
        // create model
        Administration administration = new Administration();

        // create controller
        CLI cli = new CLI();

        // create handler
        AddMediaobjectHandler addMediaobjectHandler = new AddMediaobjectHandler();
        AddUploaderHandler addUploaderHandler = new AddUploaderHandler();
        ListHandler listHandler = new ListHandler();
        RemoveHandler removeHandler = new RemoveHandler();
        UpdateHandler updateHandler = new UpdateHandler();

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
        FeedbackListener CLIfeedbackListener = new FeedbackListener(cli);
        FeedbackListener adminFeedbackListener = new FeedbackListener(administration);

        // create Feedbackhandler
        FeedbackHandler adminFeedbackHandler = new FeedbackHandler();
        FeedbackHandler CLIfeedbackHandler = new FeedbackHandler();

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
