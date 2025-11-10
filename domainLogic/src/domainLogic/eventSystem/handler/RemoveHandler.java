package domainLogic.eventSystem.handler;

import domainLogic.eventSystem.events.RemoveEvent;
import domainLogic.eventSystem.listener.RemoveListener;

import java.util.LinkedList;
import java.util.List;

public class RemoveHandler {

    private List<RemoveListener> listenerList = new LinkedList<>();

    public void addListener(RemoveListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(RemoveListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(RemoveEvent removeEvent) {
        for (RemoveListener listener : listenerList) {
            listener.onEvent(removeEvent);
        }
    }
}
