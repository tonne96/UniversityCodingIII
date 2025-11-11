import CLI.CLI;
import domainLogic.Administration;
import CLI.eventSystem.handler.AddHandler;
import CLI.eventSystem.handler.ListHandler;
import CLI.eventSystem.handler.RemoveHandler;
import CLI.eventSystem.handler.UpdateHandler;
import CLI.eventSystem.listener.AddListener;
import CLI.eventSystem.listener.ListListener;
import CLI.eventSystem.listener.RemoveListener;
import CLI.eventSystem.listener.UpdateListener;

public class CLIMain {
    public static void main(String[] args) {
        // create model
        Administration administration = new Administration();

        // create controller
        CLI cli = new CLI();

        // create handler
        AddHandler addHandler = new AddHandler();
        ListHandler listHandler = new ListHandler();
        RemoveHandler removeHandler = new RemoveHandler();
        UpdateHandler updateHandler = new UpdateHandler();

        // create listener
        AddListener addListener = new AddListener(administration);
        ListListener listListener = new ListListener(administration);
        RemoveListener removeListener = new RemoveListener(administration);
        UpdateListener updateListener = new UpdateListener(administration);

        // add listeners
        addHandler.addListener(addListener);
        listHandler.addListener(listListener);
        removeHandler.addListener(removeListener);
        updateHandler.addListener(updateListener);

        // set models
        cli.setAddHandler(addHandler);
        cli.setListHandler(listHandler);
        cli.setRemoveHandler(removeHandler);
        cli.setUpdateHandler(updateHandler);

        // add cli to feedbacklistener from administration
        administration.addFeedbackListener(cli);

        // start controller
        cli.start();
    }
}
