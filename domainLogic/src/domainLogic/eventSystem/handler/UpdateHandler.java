package domainLogic.eventSystem.handler;

import domainLogic.eventSystem.events.UpdateEvent;
import domainLogic.eventSystem.listener.UpdateListener;

import java.util.LinkedList;
import java.util.List;

public class UpdateHandler {

    private List<UpdateListener> listenerList = new LinkedList<>();

    public void addListener(UpdateListener listener) {
        this.listenerList.add(listener);
    }

    public void remove(UpdateListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(UpdateEvent updateEvent) {
        for (UpdateListener listener : listenerList) {
            listener.onEvent(updateEvent);
        }
    }
}
