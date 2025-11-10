package domainLogic.eventSystem.listener;


import java.util.EventObject;

public interface EventListener <E extends EventObject>{
    void onEvent(E event);
}
