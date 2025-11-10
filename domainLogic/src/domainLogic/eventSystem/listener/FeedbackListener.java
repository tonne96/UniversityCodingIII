package domainLogic.eventSystem.listener;

import domainLogic.eventSystem.events.FeedbackEvent;

public interface FeedbackListener {
    void onFeedback(FeedbackEvent feedbackEvent);
}
