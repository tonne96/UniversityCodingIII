package CLI.eventSystem.listener;

import CLI.eventSystem.events.FeedbackEvent;
import domainLogic.Model;

public class FeedbackListener <E extends Model> implements EventListener<FeedbackEvent> {
    private E model;

    public FeedbackListener(E model) {
        this.model = model;
    }

    @Override
    public void onEvent(FeedbackEvent event) {
        System.out.println(event.getFeedbackMessage());
    }
}
