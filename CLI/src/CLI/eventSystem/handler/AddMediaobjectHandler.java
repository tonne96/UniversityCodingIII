package CLI.eventSystem.handler;

import CLI.eventSystem.events.AddMediaobjectEvent;
import CLI.eventSystem.listener.AddMediaobjectListener;

import java.util.LinkedList;
import java.util.List;

public class AddMediaobjectHandler {

    private final List<AddMediaobjectListener> listenerList = new LinkedList<>();


    public void addListener(AddMediaobjectListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(AddMediaobjectListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(AddMediaobjectEvent addMediaobjectEvent) {
        for (AddMediaobjectListener listener : listenerList) {
            listener.onEvent(addMediaobjectEvent);
        }
    }
}
