package CLI.eventSystem.handler;

import CLI.eventSystem.events.AddMediaobjectEvent;
import CLI.eventSystem.events.AddUploaderEvent;
import CLI.eventSystem.listener.AddMediaobjectListener;
import CLI.eventSystem.listener.AddUploaderListener;

import java.util.LinkedList;
import java.util.List;

public class AddUploaderHandler {
    private final List<AddUploaderListener> listenerList = new LinkedList<>();


    public void addListener(AddUploaderListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(AddUploaderListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(AddUploaderEvent addUploaderEvent) {
        for (AddUploaderListener listener : listenerList) {
            listener.onEvent(addUploaderEvent);
        }
    }
}
