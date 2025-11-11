package CLI.eventSystem.listener;

import CLI.eventSystem.events.FeedbackEvent;

public interface FeedbackListener {
    void onFeedback(FeedbackEvent feedbackEvent);
}
