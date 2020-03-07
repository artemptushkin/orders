package ru.example.coyul.methods;

import org.springframework.util.StringUtils;

/**
 * В данном примере видно, что private и public методы перемешены. В связи с чем становится крайне сложно понять, каким же является API класса
 * При анализе кода приходится делать переходы, то вверх по строкам, то вниз.
 * Комфортнее же читать в той последовательности, что он выполняется, то есть ожидать все последующие private методы будут внизу
 *
 * В будущем разделение по модификатором доступа поможет при декомпозиции класса на малые и выделение API интерфейса
 */
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

    private void unregisterContentObserver(ContentObserver observer) {
        if (observer != null) {
            context.unregisterContentObserver(observer);
        }
    }

    private void unregisterObservers() {
        unregisterContentObserver(messengerHistoryObserver);
        unregisterContentObserver(messengerHistoryFirstLoadObserver);
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

    public void onRatingSend(int rating, boolean isForBot) {
        String ratingMessage = ratingInteractor.getRatingTextForSendToChat(rating,isForBot);
        Message message = prepareMessage(ratingMessage);
        sendMessage(message);
        if (disableButtonClickCount > DISABLE_BUTTON_CLICK_COUNT) {
            analyticPlugin.onRatingChatDisabledButtonTap(false, disableButtonClickCount, ratingInteractor.isRatingModeCircle());
        }
    }

    private Message prepareMessage(String ratingMessage) {
        return new Message();
    }

    private void sendMessage(Message message) {

    }
}
