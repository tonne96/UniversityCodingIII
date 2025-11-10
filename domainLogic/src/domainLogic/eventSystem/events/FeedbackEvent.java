package domainLogic.eventSystem.events;

import java.util.EventObject;

public class FeedbackEvent extends EventObject {
    private final String feedbackMessage;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FeedbackEvent(Object source, String feedbackMessage) {
        super(source);
        this.feedbackMessage = feedbackMessage;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }
}
