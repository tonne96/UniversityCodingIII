package CLI.eventSystem.handler;

import CLI.eventSystem.events.FeedbackEvent;
import CLI.eventSystem.listener.FeedbackListener;

import java.util.LinkedList;
import java.util.List;

public class FeedbackHandler {

    private final List<FeedbackListener> listenerList = new LinkedList<>();

    public void addListener(FeedbackListener feedbackListener) {
        this.listenerList.add(feedbackListener);
    }

    public void remove(FeedbackListener feedbackListener) {
        this.listenerList.remove(feedbackListener);
    }

    public void handle(FeedbackEvent feedbackEvent) {
        for (FeedbackListener feedbackListener : listenerList) {
            feedbackListener.onEvent(feedbackEvent);
        }
    }
}
