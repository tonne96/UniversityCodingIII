package CLI.eventSystem.handler;

import CLI.eventSystem.events.FeedbackEvent;
import CLI.eventSystem.listener.FeedbackListener;
import domainLogic.Model;

import java.util.LinkedList;
import java.util.List;

public class FeedbackHandler {

    private final List<FeedbackListener<? extends Model>> listenerList = new LinkedList<>();

    public void addListener(FeedbackListener<? extends Model> feedbackListener) {
        this.listenerList.add(feedbackListener);
    }

    public void remove(FeedbackListener<? extends Model> feedbackListener) {
        this.listenerList.remove(feedbackListener);
    }

    public void handle(FeedbackEvent feedbackEvent) {
        for (FeedbackListener<? extends Model> feedbackListener : listenerList) {
            feedbackListener.onEvent(feedbackEvent);
        }
    }
}
