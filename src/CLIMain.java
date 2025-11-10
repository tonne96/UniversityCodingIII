import CLI.CLI;
import domainLogic.Administration;
import domainLogic.eventSystem.handler.AddHandler;
import domainLogic.eventSystem.handler.ListHandler;
import domainLogic.eventSystem.handler.RemoveHandler;
import domainLogic.eventSystem.handler.UpdateHandler;
import domainLogic.eventSystem.listener.AddListener;
import domainLogic.eventSystem.listener.ListListener;
import domainLogic.eventSystem.listener.RemoveListener;
import domainLogic.eventSystem.listener.UpdateListener;

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

        // start controller
        cli.start();
    }
}
