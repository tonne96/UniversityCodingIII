package domainLogic.eventSystem.handler;

import domainLogic.eventSystem.events.AddEvent;
import domainLogic.eventSystem.listener.AddListener;

import java.util.LinkedList;
import java.util.List;

public class AddHandler {

    private List<AddListener> listenerList = new LinkedList<>();

    public void addListener(AddListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(AddListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(AddEvent addEvent) {
        for (AddListener listener : listenerList) {
            listener.onEvent(addEvent);
        }
    }
}
