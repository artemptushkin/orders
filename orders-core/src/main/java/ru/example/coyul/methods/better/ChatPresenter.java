package ru.example.coyul.methods.better;

import org.springframework.util.StringUtils;
import ru.example.coyul.methods.*;

public class ChatPresenter {

    private static final int DISABLE_BUTTON_CLICK_COUNT = 2;

    private AuthInteractor authInteractor;
    private NotificationInteractor notificationsInteractor;
    private ChatContext context;

    private ContentObserver messengerHistoryObserver;
    private ContentObserver messengerHistoryFirstLoadObserver;
    private ConversationType conversationType;
    private int disableButtonClickCount;
    private RatingInteractor ratingInteractor;

    private AnalyticsPlugin analyticPlugin;
    private ConverationState conversationState;

    public void onPause() {
        authInteractor.onDetach();
        unregisterObservers();
        notificationsInteractor.notify();
    }

    public void onResume() {
        if (isConversation()) {
            getViewState().setChannelViewState(false);
            if (!StringUtils.isEmpty(conversationState.getTitle())) {
                analyticPlugin.onChannelHistoryShow(conversationState);
            }
        }
        registerObservers();
    }

    public void onRatingSend(int rating, boolean isForBot) {
        String ratingMessage = ratingInteractor.getRatingTextForSendToChat(rating,isForBot);
        Message message = prepareMessage(ratingMessage);
        sendMessage(message);
        if (disableButtonClickCount > DISABLE_BUTTON_CLICK_COUNT) {
            analyticPlugin.onRatingChatDisabledButtonTap(false, disableButtonClickCount, ratingInteractor.isRatingModeCircle());
        }
    }

    private void unregisterObservers() {
        unregisterContentObserver(messengerHistoryObserver);
        unregisterContentObserver(messengerHistoryFirstLoadObserver);
    }

    private void unregisterContentObserver(ContentObserver observer) {
        if (observer != null) {
            context.unregisterContentObserver(observer);
        }
    }

    private ViewState getViewState() {
        return new ViewState();
    }

    private void registerObservers() {
        registerContentObserver(messengerHistoryObserver);
        registerContentObserver(messengerHistoryFirstLoadObserver);
    }

    private void registerContentObserver(ContentObserver messengerHistoryObserver) {
    }

    private boolean isConversation() {
        return conversationType == ConversationType.CHANNEL;
    }

    private Message prepareMessage(String ratingMessage) {
        return new Message();
    }

    private void sendMessage(Message message) {

    }
}
